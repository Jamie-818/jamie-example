package com.jamie.example.rmi;

import com.jamie.example.rmi.pojo.User;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

/**
 * user实现类 要想实现类可以使用rmi远程调用，必须继承 UnicastRemoteObject
 * @author jamie
 */
public class UserServiceImpl extends UnicastRemoteObject implements IUserService {

    Map<Object, User> userMap = new HashMap<>(16);

    public UserServiceImpl() throws RemoteException {
        super();
        User user1 = new User();
        user1.setId(1);
        user1.setName("张三");
        User user2 = new User();
        user2.setId(2);
        user2.setName("李四");
        userMap.put(user1.getId(), user1);
        userMap.put(user2.getId(), user2);
    }

    /**
     * 获取用户信息
     * @param id id
     */
    @Override
    public User getByUserId(int id) throws RemoteException {
        return userMap.get(id);
    }

}
