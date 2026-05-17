package com.demo.enrollment_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

  @GetMapping("/")
  public String index(){
    return "index"; // صفحة فارغة + JS
  }
}