package com.spring.example.aop.aspect;

import com.spring.example.aop.anno.AnnotationTest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 注解切面测试
 * @author jamie
 */
@Aspect
@Component
public class AnnotationTestAspect {

    Logger log = LoggerFactory.getLogger(AnnotationTestAspect.class);

    @Pointcut("@annotation(com.spring.example.aop.anno.AnnotationTest)")
    public void annotationPointcut() {
        log.info("进入注解拦截");
    }

    /**
     * 进入注解的方法之前执行
     * @param joinPoint 连接点
     */
    @Before("annotationPointcut()")
    public void before(JoinPoint joinPoint) {
        // 获取注解值
        AnnotationTest systemLog = ((MethodSignature)joinPoint.getSignature()).getMethod()
                                                                              .getAnnotation(AnnotationTest.class);
        log.info("注解值为：" + systemLog.value());

    }

}
