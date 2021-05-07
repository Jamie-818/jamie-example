package com.jamie.example.rmi.pojo;

import java.io.Serializable;

/**
 * rmi传输测试对象
 * rmi传输对象必须实现Serializable
 * @author jamie
 */
public class User implements Serializable {

    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
