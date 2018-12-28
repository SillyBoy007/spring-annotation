package com.wang.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Dog implements ApplicationContextAware {
    public ApplicationContext applicationContext;
    public Dog(){
        System.out.println("Dog Cons...");
    }
    @PostConstruct
    public void init(){
        System.out.println("Dog init...");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("Dog PreDestroy...");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


}
