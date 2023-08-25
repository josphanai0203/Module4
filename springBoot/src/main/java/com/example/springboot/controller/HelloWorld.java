package com.example.springboot.controller;

import com.example.springboot.entity.Hello;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    @GetMapping("/hello")
    public Hello greeting(){
        Hello h1 = new Hello(1,"xin chào");
        return h1;
    }
}
