package com.wang.controller;

import com.wang.service.MyHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @Autowired
    private MyHelloService myHelloService;
    @ResponseBody
    @RequestMapping("/myhello")
    public String hello(){
        return myHelloService.sayHello();
    }
    @RequestMapping("/success")
    public String success(){
        return "success";
    }
}
