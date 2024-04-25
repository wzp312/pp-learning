package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//请求处理类
@RestController
public class HelloController {
    @RequestMapping("/Hello")
    public String Hello(){
        System.out.println("Hello word~");
        return "Hello Word~";
    }
}
