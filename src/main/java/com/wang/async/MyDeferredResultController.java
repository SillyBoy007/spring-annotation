package com.wang.async;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.UUID;

@Controller
public class MyDeferredResultController{
    /**
     * 一个线程创建订单,一个线程等待处理订单
     * @return
     */
    @ResponseBody
    @RequestMapping("/createOrder")
    public DeferredResult<Object> createOrder(){
        //设置等待时间，3秒后等待超时
        DeferredResult<Object> deferredResult = new DeferredResult<>((long)3000,"createFail");
        DeferredResultQueue.save(deferredResult);
        return deferredResult;
    }
    @ResponseBody
    @RequestMapping("/create")
    public String create(){
        String order = UUID.randomUUID().toString();
        DeferredResult<Object> deferredResult = DeferredResultQueue.get();
        deferredResult.setResult(order);
        return "success===>"+order;
    }
}
