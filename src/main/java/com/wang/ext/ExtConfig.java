package com.wang.ext;

import com.wang.bean.Blue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 扩展原理
 * BeanPostProcessor,bean后置处理器,bean创建对象初始化前后进行拦截工作的
 * BeanFactoryPostProcessor（beanFactory的后置处理）:
 *      在BeanFactory标准初始化之后调用,所有的bean定义已经保存加载到beanFactory,但是bean的实例还未创建
 *      1) ioc容器创建对象
 *      2) invokeBeanFactoryPostProcessor(beanFactory);执行BeanFactoryPostProcessor;
 *
 *
 */
@ComponentScan("com.wang.ext")
@Configuration
public class ExtConfig {
    @Bean
    public Blue blue(){
        return new Blue();
    }
}
