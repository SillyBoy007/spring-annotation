package com.wang.config;

import com.wang.aop.LogAspects;
import com.wang.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * AOP：
 *     指程序在运行期间动态地将某段代码切入到指定方法指定位置进行运行的编程方法
 *AOP的使用：
 * 1.导入aop模块(spring-aspects)
 * 2.定义一个业务逻辑类(com.wang.aop.MathCalculator),在业务逻辑运行时将日志进行打印(方法之前，方法结束，方法异常都会打印)
 * 3.定义一个日志切面类(com.wang.aop.LogAspects),切面类的方法需要动态感知MathCalculator的div方法运行到哪里，然后执行通知方法
 *  通知方法:
 *         前置通知(@Before):logStart()，在目标方法运行之前运行
 *         后置通知(@After):logEnd(),在目标方法运行之后运行(无论方法正常结束或异常结束都会调用)
 *         返回通知(@AfterReturning):logRet(),在目标方法正常返回之后执行
 *         异常通知(@AfterThrowing):logException(),在目标方法运行异常之后运行
 *         环绕通知(@Around):动态代理，手动推进目标方法运行(joinPoint.procced())
 *
 * 4.给切面类的方法标注通知注解
 * 5.将切面类和业务逻辑类(目标方法所在类)都加入到容器中
 * 6.必须告诉spring哪个类是切面类(给切面类加上注解@Aspect)
 * 7.给配置类中添加@EnableAspectJAutoProxy,开启基于注解的AOP模式
 *
 *
 * 注意:
 * 1.使用aop的对象不能自己new创建，需要去spring容器中获取
 * 2.joinPoint必须放在参数第一位，否则则会报错
 *
 * 总结；
 * 1) 将业务逻辑组件和切面类都加入容器中,告诉spring那个是切面类(@Aspect)
 * 2) 在切面类上每一个通知方法上标注通知注解，告诉spring何时运行(切入点表达式)
 * 3) 开启基于注解的aop模式(@EnableAspectJAutoProxy)
 *
 *
 * AOP的原理:(给容器中注册了什么组件，组件什么时候工作，组件的功能)
 * 1.@EnableAspectJAutoProxy
 *   @Import({AspectJAutoProxyRegistrar.class})给容器导入AspectJAutoProxyRegistrar
 *   利用AspectJAutoProxyRegistrar自定义给容器中注册bean
 *   给容器中注册
 *
 */
@Configuration
@EnableAspectJAutoProxy //开启spring的aop注解功能
public class AOPConfig {
    @Bean
    public MathCalculator calculator(){
        return new MathCalculator();
    }
    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }
}
