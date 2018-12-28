package com.wang.config;

import com.wang.bean.Person;
import com.wang.bean.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@PropertySource(value = {"classpath:/person.properties"})
@Configuration
public class PropertiesConfig {
    @Bean
    public Person person(){
        return new Person();
    }

    @Bean
    public Student student(){
        return new Student();
    }
}
