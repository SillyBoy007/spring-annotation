package com.wang.condition;

import com.wang.bean.Yellow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     *
     * @param annotationMetadata 当前类的注解信息
     * @param beanDefinitionRegistry BeanDefinition注册类
     *                               把所有需要添加到容器中的Bean，返回需要导入的组件
     *
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        boolean red  = beanDefinitionRegistry.containsBeanDefinition("com.wang.bean.Red");
        boolean blue = beanDefinitionRegistry.containsBeanDefinition("com.wang.bean.Blue");

        if (blue && red){  //如果容器中有该组件，注册一个
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Yellow.class);
            beanDefinitionRegistry.registerBeanDefinition("yellow",rootBeanDefinition);
        }
    }
}
