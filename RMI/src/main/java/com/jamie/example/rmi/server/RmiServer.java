package com.jamie.example.rmi.server;

import com.jamie.example.rmi.IUserService;
import com.jamie.example.rmi.UserServiceImpl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * rmi服务端
 * @author jamie
 */
public class RmiServer {

    public static void main(String[] args) {
        try{//1.注册Registry实例. 绑定端口
            Registry registry = LocateRegistry.createRegistry(9998);
            //2.创建远程对象
            IUserService userService = new UserServiceImpl();
            //3.将远程对象注册到RMI服务器上即(服务端注册表上)
            registry.rebind("userService", userService);
            System.out.println("---RMI服务端启动成功----");
        }catch(RemoteException e){
            e.printStackTrace();
        }
    }

}
