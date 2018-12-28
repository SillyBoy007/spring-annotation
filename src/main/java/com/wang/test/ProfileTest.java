package com.wang.test;

import com.wang.bean.Yellow;
import com.wang.config.ProfileConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class ProfileTest {
    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ProfileConfig.class);
        String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for (String bean: beanNamesForType){
            System.out.println(bean);
        }
    }

    @Test
    public void test02(){
        //1.创建一个application无参构造（不能使用有参构造，要自己写）
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
       //2.设置需要激活的环境
        applicationContext.getEnvironment().setActiveProfiles("test","dev");
       //3.注册主配置类
        applicationContext.register(ProfileConfig.class);
        //4.启动刷新容器
        applicationContext.refresh();


        String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for (String bean: beanNamesForType){
            System.out.println(bean);
        }

        Yellow bean = applicationContext.getBean(Yellow.class);
        System.out.println(bean);
    }
}
