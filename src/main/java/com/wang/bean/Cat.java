package com.wang.bean;

import org.springframework.stereotype.Component;

@Component
public class Cat {
    public Cat(){
        System.out.println("cat cons...");
    }
    public void init(){
        System.out.println("cat init...");
    }
    public void destroy(){
        System.out.println("cat destroy...");
    }
}
