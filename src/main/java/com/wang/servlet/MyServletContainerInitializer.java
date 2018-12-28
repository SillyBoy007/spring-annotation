package com.wang.servlet;

import com.wang.service.HelloService;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.util.EnumSet;
import java.util.Set;
//容器启动时，会将HandlesTypes指定类型下面的子类，实现类，子接口传递过来
@HandlesTypes(value = {HelloService.class})
public class MyServletContainerInitializer implements ServletContainerInitializer  {
    /**
     * 应用启动，会运行onStartup方法
     * ServletContext arg1:代表当前WEb应用的ServletContext,一个web应用相当于一个webContext
     *
     * @param set 所有HandlesTypes指定的类型以及子类
     * @param servletContext
     * @throws ServletException
     */
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        for (Class<?> cla:set){
            System.out.println("============================="+cla.getName());
        }
        //注册Servlet
        ServletRegistration.Dynamic userServlet = servletContext.addServlet("userServlet", new UserServlet());
        //配置Servlet映射信息
        userServlet.addMapping("/userServlet");

        //注册监听器
        servletContext.addListener(UserListener.class);

        //注册Filter
        FilterRegistration.Dynamic userFilter = servletContext.addFilter("userFilter", UserFilter.class);
        //配置Filter的映射信息
        userFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST),true,"/");
    }
}
