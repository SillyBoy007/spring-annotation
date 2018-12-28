package com.wang.test;

import com.wang.bean.Color;
import com.wang.config.ImportConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ImportTest {
    @Test
    public void testImport(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ImportConfig.class);
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String name:beanDefinitionNames){
            System.out.println(name);
        }


    }
    @Test
    public void testBeanFactory(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ImportConfig.class);

        //工厂bean调用的是getObject取得的对象
        Color colorFactoryBean = (Color) annotationConfigApplicationContext.getBean("colorFactoryBean");
        Color colorFactoryBean2 = (Color) annotationConfigApplicationContext.getBean("colorFactoryBean");
        System.out.println("bean的类型:"+colorFactoryBean.getClass());

        System.out.println(colorFactoryBean==colorFactoryBean2);

        //获取ColorFactoryBean
        Object bean = annotationConfigApplicationContext.getBean("&colorFactoryBean");
        System.out.println("bean的类型:"+bean.getClass());


    }
}
