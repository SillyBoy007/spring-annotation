package com.wang.test;

import com.wang.bean.Boss;
import com.wang.config.AutowiredConfig;
import com.wang.dao.BookDao;
import com.wang.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowireTest {
    @Test
    public void fun(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AutowiredConfig.class);
        BookService service = annotationConfigApplicationContext.getBean(BookService.class);
        //BookDao dao = annotationConfigApplicationContext.getBean(BookDao.class);

        service.useBook();
        //dSystem.out.println(dao);

        Boss boss = annotationConfigApplicationContext.getBean(Boss.class);
        System.out.println(boss);
    }
}
