package com.wang.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Car implements InitializingBean,DisposableBean {
    public Car(){
        System.out.println("car cons...");
    }
  /*  public void init(){
        System.out.println("car init...");
    }
    public ovid destroy(){
        System.out.println("car destroy...");
    }*/

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet...在properties设置之后调用(初始化方法)");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy方法");
    }
}
