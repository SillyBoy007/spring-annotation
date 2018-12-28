package com.wang.config;

import com.wang.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//在配置类里配置
@Configuration//告诉spring这是一个配置类

//包扫描注解
@ComponentScan(value = "com.wang"/*excludeFilters = {  //排除
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class,Service.class}) //排除Controller和Service
},*/,includeFilters = { //只包含
        /*@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Repository.class}),
        @ComponentScan.Filter(type = FilterType.REGEX),
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE),
        @ComponentScan.Filter(type = FilterType.ASPECTJ),*/
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})
},useDefaultFilters = false)

//excludeFilters Filter[]
public class PersonConfig {
    @Bean(value = "person") //给spring容器注册一个bean，类型为返回值类型，id是默认是方法名为id,也可以使用value指定
    public Person person(){
        return new Person("lisi",20);
    }
}
