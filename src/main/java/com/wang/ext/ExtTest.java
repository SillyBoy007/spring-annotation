package com.wang.ext;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExtTest {
    @Test
    public void extTest(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ExtConfig.class);


        annotationConfigApplicationContext.close();
    }
}
