package com.mergespringmvc.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lijichen
 * @date 2020/12/1 - 19:53
 */
//框架不能这么整
//1，asyncSupported = true 开启支持异步请求，默认值为false
//@WebServlet(value = "/Async",asyncSupported = true)
public class HelloAsyncServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //2,开启异步模式
//        AsyncContext asyncContext = req.startAsync();
//        req.starAsync();
    }
}
