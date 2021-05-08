package com.jamie.example.rpc.consumer.proxy;

import com.alibaba.fastjson.JSON;
import com.jamie.example.rpc.api.common.RpcRequest;
import com.jamie.example.rpc.api.common.RpcResponse;
import com.jamie.example.rpc.consumer.client.RpcClient;

import java.lang.reflect.Proxy;
import java.util.UUID;

/**
 * 客户端代理类-创建代理对象
 * 1.封装request请求对象
 * 2.创建RpcClient对象
 * 3.发送消息
 * 4.返回结果
 * @author jamie
 */
public class RpcClientProxy {

    public static Object createProxy(Class<?> serviceClass) {
        return Proxy.newProxyInstance(Thread.currentThread()
                                            .getContextClassLoader(), new Class[]{serviceClass}, (proxy, method,
                                                                                                  args) -> {
            //1.封装request请求对象
            RpcRequest rpcRequest = new RpcRequest();
            rpcRequest.setRequestId(UUID.randomUUID().toString());
            rpcRequest.setClassName(method.getDeclaringClass().getName());
            rpcRequest.setMethodName(method.getName());
            rpcRequest.setParameterTypes(method.getParameterTypes());
            rpcRequest.setParameters(args);
            //2.创建RpcClient对象
            RpcClient rpcClient = new RpcClient("127.0.0.1", 8899);
            try{
                //3.发送消息
                Object responseMsg = rpcClient.send(JSON.toJSONString(rpcRequest));
                RpcResponse rpcResponse = JSON.parseObject(responseMsg.toString(), RpcResponse.class);
                if(rpcResponse.getError() != null){
                    throw new RuntimeException(rpcResponse.getError());
                }
                //4.返回结果
                Object result = rpcResponse.getResult();
                return JSON.parseObject(result.toString(), method.getReturnType());
            }finally{
                rpcClient.close();
            }

        });
    }

}
