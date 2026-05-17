package com.demo.api_gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class contrGatway {


    @GetMapping("/hello")
    public String hello() {
        return "gateway works";
    }
}