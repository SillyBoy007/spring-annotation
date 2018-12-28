package com.wang.config;

import com.wang.bean.Color;
import com.wang.bean.ColorFactoryBean;
import com.wang.bean.Red;
import com.wang.condition.MyImportBeanDefinitionRegistrar;
import com.wang.condition.MyImportSelector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;

/**
 * 给容器注册组件
 * 1.包扫描+组件标注注解(@Controller,@Service,@Repository，@Component)
 * 2.@Bean(导入第三方包里的组件)
 * 3.@Import[快速给容器导入组件]
 *      1)@Import(要导入容器的组件)，容器中就会自动注册这个组件
 *      2)ImportSelector:返回需要导入的组件的全类名数组
 *      3)ImportBeanDefinitionRegistrar:
 * 4.使用Spring提供的FactoryBean注册组件:
 *      1)默认获取到的是工厂bean调用getObject创建的对象
 *      2)获取工厂bean本身需要在bean的id前加"&"
 */

@Import({/*Color.class,*/Red.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
@Configuration
public class ImportConfig {
    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
}
