package com.wang.service;

import com.wang.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Transactional
    public void insertUser(){
        userDao.insert();
        int i = 1/0;
        System.out.println("插入成功");
    }
}
