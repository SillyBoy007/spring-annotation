package com.wang.service;

import com.wang.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Qualifier("bookDao")
    @Autowired
    private BookDao bookDao;
    public void useBook(){
        bookDao.useBook();
        System.out.println(bookDao);
    }
}
