package com.wang.test;

import com.wang.aop.MathCalculator;
import com.wang.config.AOPConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AOPTest {
    @Test
    public void test01(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AOPConfig.class);
        MathCalculator bean = annotationConfigApplicationContext.getBean(MathCalculator.class);
        bean.div(1,2);
    }
}
