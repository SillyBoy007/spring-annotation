package com.wang.test;

import com.wang.bean.Person;
import com.wang.config.ConditionConfig;
import com.wang.config.ImportConfig;
import com.wang.config.PersonConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

public class ConditionTest {
    @Test
    public void testCondition(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ConditionConfig.class);

        String[] beanNamesForType = annotationConfigApplicationContext.getBeanNamesForType(Person.class);
        for (String name:beanNamesForType){
            System.out.println(name);
        }

        Map<String, Person> beansOfType = annotationConfigApplicationContext.getBeansOfType(Person.class);

        System.out.println(beansOfType);


        ConfigurableEnvironment environment = annotationConfigApplicationContext.getEnvironment();//获取运行环境
        String property = environment.getProperty("os.name");
        System.out.println(property);

    }


}
