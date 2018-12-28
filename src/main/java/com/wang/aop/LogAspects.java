package com.wang.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * 切面类
 */
@Aspect
public class LogAspects {
    //抽取公共表达式
    //本类引用:pointCut()
    //其他切面类引用:com.wang.aop.LogAspects.pointCut()
    //@Pointcut("execution(public int com.wang.aop.MathCalculator.div(int ,int ))")
    @Pointcut("execution(public int com.wang.aop.MathCalculator.*(..))")
    public void pointCut(){

    }
    //在目标方法之前切人,切入点表达式
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+"方法开始运行...@Before,参数列表是"+Arrays.asList(joinPoint.getArgs()));
    }
    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+"方法结束...@After,参数列表是"+Arrays.asList(joinPoint.getArgs()));
    }
    @AfterReturning(value = "pointCut()",returning = "result")
    public void logRet(JoinPoint joinPoint,Object result){ //joinPoint必须放在参数第一位，否则则会报错
        System.out.println(joinPoint.getSignature().getName()+"方法结果打印...@AfterReturning,运行结果"+result);
    }
    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void logException(Exception exception){
        System.out.println("方法异常...@AfterThrowing,异常结果"+exception);
    }
}
