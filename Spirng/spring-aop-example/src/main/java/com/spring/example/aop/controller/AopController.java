package com.spring.example.aop.controller;

import com.spring.example.aop.anno.AnnotationTest;
import com.spring.example.aop.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
public class AopController {

    @PostMapping("/signTest")
    @ResponseBody
    public String signTest(@RequestParam(value = "checksum") String checksum,
                           @RequestParam(value = "time") String time, @RequestBody() String jsonStr) {
        // 此处省略业务代码

        return null;
    }

    @GetMapping("/getTest")
    @ResponseBody
    public String getTest(String time) {
        // 此处省略业务代码

        return null;
    }

    @PostMapping("/postTest")
    @ResponseBody
    public String postTest(@RequestBody() User user) {
        // 此处省略业务代码

        return null;
    }

    @PostMapping("/annoTest")
    @ResponseBody
    @AnnotationTest(true)
    public String annotationTest() {
        return null;
    }

}
