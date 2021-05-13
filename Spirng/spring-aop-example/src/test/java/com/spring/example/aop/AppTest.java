package com.spring.example.aop;

import com.spring.example.aop.controller.AopController;
import com.spring.example.aop.pojo.User;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest extends TestCase {

    @Autowired
    AopController aopController;

    @Test
    public void test1() {
        aopController.signTest("9B86E0F7AB984C5E8C004B83ADA395B2", "1620890885", "{\"phone" + "\":\"13800138000\"}");

        System.out.println("----------------------------------------");
        aopController.getTest("1620890885");

        System.out.println("----------------------------------------");
        User user = new User();
        user.setUsername("jamie");
        user.setPhone("13800138000");
        aopController.postTest(user);
    }

}