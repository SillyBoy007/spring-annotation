package com.wang.async;

import org.springframework.web.context.request.async.DeferredResult;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public  class DeferredResultQueue {
    public static Queue<DeferredResult<Object>> queue=new ConcurrentLinkedDeque<>();
    public static void save(DeferredResult<Object> deferredResult){
        queue.add(deferredResult);
    }
    public static DeferredResult<Object> get(){
        return queue.poll();
    }
}
