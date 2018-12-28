package com.wang.config;

import com.wang.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class ScopConfig {
    //默认是单实例的
    @Bean
    /**
     * prototype 多例
     * singleton 单例
     * request 同一次请求创建一个实例
     * session 同一个session创建一个实例
     *
     */
    //@Scope("prototype")
    /**
     *
     * 单实例bean，默认在容器启动的时候创建对象
     * 懒加载:容器启动不创建对象，第一次使用(获取)创建Bean，并初始化,第二次使用就使用第一次创建的对象
     *
     */
    @Lazy

    public Person person(){
        System.out.println("添加Person....");
        return new Person("张三",23);
    }
}
