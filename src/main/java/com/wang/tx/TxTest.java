package com.wang.tx;

import com.wang.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TxTest {
    @Test
    public void txTest(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userservice = annotationConfigApplicationContext.getBean(UserService.class);
        userservice.insertUser();
        annotationConfigApplicationContext.close();
    }
}
