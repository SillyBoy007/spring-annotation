package com.wang.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component //将后置处理器加入容器中
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization is run ...."+"bean:"+bean+"=>beanName:"+beanName);

        //返回要用的bean对象
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization is run ...."+"bean:"+bean+"=>beanName:"+beanName);
        return bean;
    }
}
