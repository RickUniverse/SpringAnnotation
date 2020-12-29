package com.servlet3.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lijichen
 * @date 2020/12/1 - 20:06
 */
//1，asyncSupported = true 开启支持异步请求，默认值为false
@WebServlet(value = "/async", asyncSupported = true)
public class MyAsyncServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //2,开启异步模式
        System.out.println("主线程开始："+Thread.currentThread()+"="+System.currentTimeMillis());
        AsyncContext startAsync = req.startAsync();
        startAsync.start(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("副线程开始："+Thread.currentThread()+"="+System.currentTimeMillis());
                    sayHello();
                    startAsync.complete();//业务完成
                    //3 获取到异步上下文
                    AsyncContext asyncContext = req.getAsyncContext();
                    //4 获取响应
                    ServletResponse response = asyncContext.getResponse();
                    response.getWriter().write("hello Async");
                    System.out.println("副线程结束："+Thread.currentThread()+"="+System.currentTimeMillis());
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println("主线程结束："+Thread.currentThread()+"="+System.currentTimeMillis());
    }

    public void sayHello() throws InterruptedException {
        Thread.sleep(3000);
    }
}
