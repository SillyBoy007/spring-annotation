package com.wang.test;

import com.wang.config.LifeCycleConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifeCycleTest {
    @Test
    public void test(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        System.out.println("容器创建完成");

        //annotationConfigApplicationContext.getBean("car");//多实例，获取bean时调用创建对象,容器关闭不会销毁bean
        annotationConfigApplicationContext.close();//关闭容器，执行销毁方法

    }
}
