package com.wang.bean;


import org.springframework.beans.factory.annotation.Value;

public class Person {

    /**
     * 使用@Value赋值
     * 1.基本数值
     * 2.可以写SPEL,#{}
     * 3.使用${}获取配置文件中的值
     */
    @Value("zhangsan")
    private String name;
    @Value("#{1+2}")
    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
