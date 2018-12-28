package com.wang.config;

import com.wang.bean.Person;
import com.wang.condition.LinuxCondition;
import com.wang.condition.WindowsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ConditionConfig {
    /**
     * @Conditional({})按照一定条件进行判断，满足条件容器中注册bean,
     * 若放在类中，整个配置类中的bean满足条件才会被加载到容器中
     *
     * 若是windows系统，注册win,若是linux注册lin
     */
    @Bean("win")
    @Conditional(WindowsCondition.class)
    public Person person(){
        return new Person("win",22);
    }

    @Bean("lin")
    @Conditional(LinuxCondition.class)
    public Person person2(){
        return new Person("lin",11);
    }
    @Bean("person")
    public Person person3(){
        return new Person("person",25);
    }
}
