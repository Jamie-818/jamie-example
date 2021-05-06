package com.jamie.example.netty.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * chatController
 * @author jamie
 */
@Controller
public class ChatController {

    @RequestMapping("/")
    public String chat() {
        return "chat";
    }

}