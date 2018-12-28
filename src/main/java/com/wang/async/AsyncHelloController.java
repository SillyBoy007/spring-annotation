package com.wang.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Callable;

@Controller
public class AsyncHelloController {
    /**
     * 1.控制器返回Callable
     * 2.Spring异步处理,将Callable提交到TaskExecutor 使用一个隔离的线程进行执行
     * 3.DispacherServlet和所有的Filter退出线程,但是response保持打开状态
     * 4.Callbale返回结果，springMVC将请求重新派发给容器，恢复之前的处理
     * 5.根据Callable返回的结果,springMVC继续进行视图渲染流程等(从请求-视图渲染)。
     *
     * 异步Controller分析:
     * MyInterceptor preHandle..
     * 拦截器拦截的请求:/callable
     * 主线程Thread[http-apr-8080-exec-9,5,main]Start======>1545965335805
     * 主线程Thread[http-apr-8080-exec-9,5,main]End======>1545965335805
     * ==============DispacherServlet及所有的Filter退出线程=============
     * ========================等待Callable执行========================
     * 副线程Thread[MvcAsync1,5,main]Start======>1545965335811
     * 副线程Thread[MvcAsync1,5,main]End======>1545965338811
     * ========================Callable执行完成========================
     * MyInterceptor preHandle..
     * 拦截器拦截的请求:/callable
     * MyInterceptor postHandle..(Callable的之前的返回值就是目标方法的返回值)
     * MyInterceptor afterCompletion..
     *
     *
     * 异步拦截器:
     * 1). 原生API的AsyncListener
     * 2）. SpringMVC实现AsyncHandlerInterceptor
     * @return
     */
    @RequestMapping("/callable")
    @ResponseBody
    public Callable<String> async01(){
        System.out.println("主线程"+Thread.currentThread()+"Start======>"+System.currentTimeMillis());
        Callable<String> callable = new Callable<String>() {

            @Override
            public String call() throws Exception {
                System.out.println("副线程"+Thread.currentThread()+"Start======>"+System.currentTimeMillis());
                Thread.sleep(3000);
                System.out.println("副线程"+Thread.currentThread()+"End======>"+System.currentTimeMillis());
                return "Callable<String> async01()";
            }
        };
        System.out.println("主线程"+Thread.currentThread()+"End======>"+System.currentTimeMillis());

        return callable;
    }

}
