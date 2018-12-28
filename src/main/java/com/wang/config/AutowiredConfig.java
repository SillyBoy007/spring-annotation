package com.wang.config;

import com.wang.dao.BookDao;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 自动装配:
 *      spring利用依赖注入和DI完成对IOC容器中各个组件的依赖关系赋值
 * 1.@Autowired（Spring规范）
 *  1)默认优先按照类型去容器中找对应的组件annotationConfigApplicationContext.getBean(BookDao.class),找到就赋值
 *  2）若有多个相同类型的组件，将属性名称作为组件的id去容器中查找
 *  3)使用@Qualifier("bookDao")来指定需要装配的组件id而不是根据属性
 *  4）自动装配,默认一定要属性赋值好,否则会报错,使用@Autowired(required=false)可以避免报错
 *  5) @Primary("bookDao2")让Spring进行自动装配时，在没有明确用@Qualifier指定的情况下默认使用首选的bean
 * 默认规则(不用写Autowired都能实现自动装配):
 * @Autowired 标注在方法，有参构造，方法参数，spring容器创建当前对象，就会调用该方法，完成赋值，需要的参数从容器中获取，完成自动装配
 * @Bean 标注的方法创建对象的时候，方法参数的值从容器中获取
 *
 * 方法使用的参数，自定义类型的参数从ioc容器中获取
 *  2.JSR：@Resource(),@Inject() （Java规范）
 *      @Resource():
 *      可以和@Autowired一样实现自动装配，默认按照组件名称进行装配,没有支持@Qualifier和@Primary的功能
 *      @Inject():
 *      也可实现自动装配,使用时需要导入javax.inject依赖，可以支持@Qualifier和@Primary的功能,不支持require=false
 *
 * AutowiredAnnotationBeanPostProcessor:解析完成自动装配
 *
 *
 * 3.自定义组件要使用spring底层的一些组件(ApplicationContext,BeanFactory),需要实现xxxAware
 * 在创建对象的时候，会调用接口规定的方法注入相关组件:Aware，把Spring底层一些组件注入到自定义的bean中
 * xxxAware，功能使用xxxProcessor(后置处理器)完成
 *      ApplicationContextAware=>ApplicationContextProcessor
 *
 */
@Configuration
@ComponentScan({"com.wang.service","com.wang.controller","com.wang.dao","com.wang.bean"})
public class AutowiredConfig {

    @Bean("bookDao2")
    public BookDao bookDao(){
        BookDao bookDao = new BookDao();
        bookDao.setLabel("2");
        return bookDao;
    }
}
