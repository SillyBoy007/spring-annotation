package com.wang.springmvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

//SpringMVC只扫描Controller,子容器
//useDefaultFilters=false 禁用默认的过滤规则
@ComponentScan(value = "com.wang",includeFilters =
        {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})},useDefaultFilters = false)
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter {
    /**
     * 路径映射规则
     * @param pathMatchConfigurer
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer) {

    }

    /**
     * 视图解析器
     * @param registry
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        //默认所有的页面都从"/WEB-INF/*.jsp"
        //registry.jsp();
        registry.jsp("/WEB-INF/views/",".jsp");
    }


    /**
     * 配置静态资源访问,将springmvc处理不了的请求交给springmvc,开启后可以访问静态资源(*.js,*.jpg,...)
     * @param defaultServletHandlerConfigurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer defaultServletHandlerConfigurer) {
        defaultServletHandlerConfigurer.enable();//相当于开启了default-servlet-handler  <mvc:default-servlet-handler/>
    }

    /**
     * 添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(new MyInterceptor()).addPathPatterns("/success");
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/callable");
    }
}
