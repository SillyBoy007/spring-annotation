package com.wang.config;

import com.wang.bean.Car;
import com.wang.bean.Cat;
import com.wang.bean.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Bean的生命周期
 *  ---由容器管理bean的创建,初始化,销毁
 *
 *  构造,创建对象
 *      单实例:在容器启动的时候创建对象
 *      多实例:在每次获取的时候创建对象
 *
 *  初始化:
 *      对象创建完成，并赋值好，然后调用初始化方法...
 *  销毁:
 *      单实例:容器关闭时，进行销毁
 *      多实例：容器不会管理这个bean,bean不会销毁
 * 1).使用自定义的初始化和销毁方法
 *      指定init-methdo和destroy-method
 *
 * 2)使用InitializingBean和DisposableBean初始化和销毁方法
 *
 * 3)使用@PostConstruct&@PreDestroy
 * @PostConstruct 在bean创建完成并属性赋值完成，执行初始化方法
 * @PreDestroy 在容器销毁前通知我们清理
 *
 * 4)BeanPostProcessor,bean的后置处理器
 * ---1.postProcessBeforeInitialization 在bean的初始化方法之前进行一些处理工作
 * ---2.执行初始化方法
 * ---3.postProcessAfterInitialization  在bean的初始化方法调用之后进行调用
 *
 * Spring底层对BeanPostProcessor的使用:
 *     bean赋值，注入其他组件,@Autowired,生命周期注解功能,@Asybc等都是通过BeanPostProcessor完成的
 *
 *  */
@ComponentScan("com.wang.bean")
@Configuration
public class LifeCycleConfig {
    //@Scope("prototype")
    //@Bean(initMethod = "init",destroyMethod = "destroy")
    @Bean
    public Car car(){
        return new Car();
    }

    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Cat cat(){
        return new Cat();
    }

    @Bean
    public Dog dog(){
        return new Dog();
    }
}
