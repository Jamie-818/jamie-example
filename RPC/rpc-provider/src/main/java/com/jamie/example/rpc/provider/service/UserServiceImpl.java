package com.jamie.example.rpc.provider.service;

import com.jamie.example.rpc.api.api.IUserService;
import com.jamie.example.rpc.api.pojo.User;
import com.jamie.example.rpc.provider.anno.RpcService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jamie
 */
@RpcService
@Service
public class UserServiceImpl implements IUserService {

    Map<Object, User> userMap = new HashMap<>();

    @Override
    public User getUserById(int id) {
        if(userMap.size() == 0){
            User user1 = new User();
            user1.setId(1);
            user1.setName("张三");
            User user2 = new User();
            user2.setId(2);
            user2.setName("李四");
            userMap.put(user1.getId(), user1);
            userMap.put(user2.getId(), user2);
        }
        return userMap.get(id);
    }

}