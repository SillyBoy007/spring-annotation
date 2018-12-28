package com.wang.async;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/asyncServlet",asyncSupported = true)
public class AsyncHelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(Thread.currentThread()+"主线程start..."+System.currentTimeMillis());
        //1.支持异步处理 asyncSupported = true
        //2.开启异步
        AsyncContext asyncContext = req.startAsync();
        //3.业务逻辑业务处理
        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread()+"副线程start..."+System.currentTimeMillis());
                    sayHello();
                    asyncContext.complete();

                    //4.获取响应
                    ServletResponse response = asyncContext.getResponse();
                    response.getWriter().write("hello,async...");
                    System.out.println(Thread.currentThread()+"副线程end..."+System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println(Thread.currentThread()+"主线程end..."+System.currentTimeMillis());

        //测试结果，主线程接受请求处理，并立即得到释放，副线程处理业务逻辑
        /**
         * Thread[http-apr-8080-exec-9,5,main]主线程start...1545911791802
         * Thread[http-apr-8080-exec-9,5,main]主线程end...1545911791806
         * Thread[http-apr-8080-exec-10,5,main]副线程start...1545911791806
         * Thread[http-apr-8080-exec-10,5,main]副线程end...1545911794807
         */
    }
    public void  sayHello() throws InterruptedException {
        Thread.sleep(3000);
    }
}
