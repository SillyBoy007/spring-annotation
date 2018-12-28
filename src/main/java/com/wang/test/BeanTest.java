package com.wang.test;

import com.wang.bean.Person;
import com.wang.config.PersonConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//测试Bean注解
public class BeanTest {
    public static void main(String[] args) {
        //使用beanxml配置文件获取bean
       /* ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);*/
       //使用注解配置获取bean
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(PersonConfig.class);
        Person person = (Person) annotationConfigApplicationContext.getBean("person");
        System.out.println(person);

        String[] beanNamesForType = annotationConfigApplicationContext.getBeanNamesForType(Person.class);
        for (String name:beanNamesForType){
            System.out.println(name);
        }




    }
}
