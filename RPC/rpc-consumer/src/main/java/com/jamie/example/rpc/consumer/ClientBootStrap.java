package com.jamie.example.rpc.consumer;

import com.jamie.example.rpc.api.api.IUserService;
import com.jamie.example.rpc.api.pojo.User;
import com.jamie.example.rpc.consumer.proxy.RpcClientProxy;

/**
 * 测试类
 * @author jamie
 */
public class ClientBootStrap {

    public static void main(String[] args) {
        IUserService userService = (IUserService)RpcClientProxy.createProxy(IUserService.class);
        User user = userService.getUserById(2);
        System.out.println(user);
    }

}
