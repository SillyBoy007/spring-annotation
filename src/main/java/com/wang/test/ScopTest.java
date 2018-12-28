package com.wang.test;

import com.wang.bean.Person;

import com.wang.config.ScopConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//测试包扫描注解
public class ScopTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ScopConfig.class);
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();

        for (String bean : beanDefinitionNames){
            System.out.println(bean);
        }
        Person person = (Person) annotationConfigApplicationContext.getBean("person");
        Person person2 = (Person) annotationConfigApplicationContext.getBean("person");

        System.out.println(person==person2);
    }

}
