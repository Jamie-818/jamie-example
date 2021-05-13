package com.spring.example.aop.service;

public class UserServiceImpl implements UserService {

    @Override
    public void add() {
        System.out.println("增加");
    }

    @Override
    public void delete() {
        System.out.println("删除");
    }

    @Override
    public void update() {
        System.out.println("更新");
    }

    @Override
    public void select() {
        System.out.println("查询");
    }

}
