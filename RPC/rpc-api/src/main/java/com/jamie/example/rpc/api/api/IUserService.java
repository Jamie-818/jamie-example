package com.jamie.example.rpc.api.api;

import com.jamie.example.rpc.api.pojo.User;

/**
 * 用户服务
 * @author jamie
 */
public interface IUserService {

    /**
     * 根据ID查询用户
     * @param id id
     * @return 用户信息
     */
    User getUserById(int id);

}
