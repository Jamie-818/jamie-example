package com.spring.example.aop.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 请求日志
 * @author jamie
 */
@Component
@Aspect
public class RequestLog {

    Logger log = LoggerFactory.getLogger(RequestLog.class);

    /**
     * Define a pointcut
     */
    @Pointcut("execution(public * com..*.controller..*.*(..))")
    public void controllerLog() {

    }

    /**
     * 进入controller之前
     * @param joinPoint 连接点
     */
    @Before("controllerLog()")
    public void before(JoinPoint joinPoint) throws Exception {
        HttpServletRequest request =
                ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        log.info("请求IP：{}", request.getRemoteAddr());
        log.info("请求路径：{}", request.getRequestURL());
        log.info("请求方式：{}", request.getMethod());
        // log.info("请求参数：{}", getRequest(joinPoint, request.getMethod()));
        Map<String, Object> fieldsName = getFieldsName(joinPoint);
        log.info("请求参数：{}", JSONObject.toJSONString(fieldsName));

    }

    private Map<String, Object> getFieldsName(JoinPoint joinPoint) throws Exception {
        String classType = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        // 参数值
        Object[] args = joinPoint.getArgs();
        Class<?>[] classes = new Class[args.length];
        for(int k = 0; k < args.length; k++){
            // 对于接受参数中含有MultipartFile，ServletRequest，ServletResponse类型的特殊处理，我这里是直接返回了null。（如果不对这三种类型判断，会报异常）
            if(args[k] instanceof MultipartFile
                    || args[k] instanceof ServletRequest
                    || args[k] instanceof ServletResponse){
                return null;
            }
            if(!args[k].getClass().isPrimitive()){
                // 当方法参数是基础类型，但是获取到的是封装类型的就需要转化成基础类型
                //                String result = args[k].getClass().getName();
                //                Class s = map.get(result);

                // 当方法参数是封装类型
                Class<?> s = args[k].getClass();

                classes[k] = s == null ? args[k].getClass() : s;
            }
        }
        ParameterNameDiscoverer pnd = new DefaultParameterNameDiscoverer();
        // 获取指定的方法，第二个参数可以不传，但是为了防止有重载的现象，还是需要传入参数的类型
        Method method = Class.forName(classType).getMethod(methodName, classes);
        // 参数名
        String[] parameterNames = pnd.getParameterNames(method);
        // 通过map封装参数和参数值
        HashMap<String, Object> paramMap = new HashMap<>(16);
        for(int i = 0; i < parameterNames.length; i++){
            paramMap.put(parameterNames[i], args[i]);
        }
        return paramMap;
    }

    private static HashMap<String, Class<?>> map = new HashMap<>() {
        {
            put("java.lang.Integer", int.class);
            put("java.lang.Double", double.class);
            put("java.lang.Float", float.class);
            put("java.lang.Long", long.class);
            put("java.lang.Short", short.class);
            put("java.lang.Boolean", boolean.class);
            put("java.lang.Char", char.class);
        }
    };

    private String getRequest(JoinPoint joinPoint, String methodType) {
        Object[] args = joinPoint.getArgs();
        Stream<?> stream = ArrayUtils.isEmpty(args) ? Stream.empty() : Arrays.stream(args);
        List<Object> logArgs = stream.filter(arg -> (!(arg instanceof HttpServletRequest)
                && !(arg instanceof HttpServletResponse))).collect(Collectors.toList());
        StringBuilder paramBuilder = new StringBuilder();
        for(int i = 0; i < logArgs.size(); i++){
            try{
                String httpMethodName = HttpMethod.GET.name();
                if(args[i] instanceof StandardMultipartHttpServletRequest){
                    continue;
                }
                String param = JSON.toJSONString(args[i]);
                paramBuilder.append(httpMethodName.equals(methodType) ? (i != logArgs.size() - 1
                                                                         ? (param + "&")
                                                                         : param) : param);
            }catch(Exception e){
                e.printStackTrace();
                log.error("获取请求参数失败", e);
            }
        }
        return String.valueOf(paramBuilder);
    }

    /**
     * Print the time that request method execution spend
     */
    @Around("controllerLog()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object[] args = joinPoint.getArgs();
        Object retVal = joinPoint.proceed(args);
        long endTime = System.currentTimeMillis();
        log.info("执行时间：{} ms", endTime - startTime);
        log.info("返回值：{}", JSONObject.toJSONString(retVal));
        return retVal;
    }

    /**
     * Print exception
     */
    @AfterThrowing(throwing = "e", pointcut = "controllerLog()")
    public void afterThrowing(Throwable e) {
        e.printStackTrace();
        log.error("发生异常：{}", e.toString());
    }

}
