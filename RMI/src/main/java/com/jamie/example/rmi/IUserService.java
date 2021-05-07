package com.jamie.example.rmi;

import com.jamie.example.rmi.pojo.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * user接口，编写业务逻辑，要想rmi可以调用，必须继承 Remote
 * @author jamie
 */

public interface IUserService extends Remote {

    /**
     * 获取用户信息
     * @param id id
     */
    User getByUserId(int id) throws RemoteException;

}
