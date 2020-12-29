package com.mergespringmvc.controller;

import com.mergespringmvc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.UUID;
import java.util.concurrent.Callable;

/**
 * @author lijichen
 * @date 2020/11/30 - 21:16
 */
@Controller
public class HelloController {

    @Autowired
    HelloService helloService;

    @ResponseBody
    @RequestMapping("/hello")
    public String sayHello() {
        String hello = helloService.sayHello("tomcat");
        return hello;
    }

    @RequestMapping("/viewResolver")
    public String viewResolver() {
        return "hello";
    }

    @ResponseBody
    @RequestMapping("/async01")
    public Callable<String> async01() {
        System.out.println("主线程开始："+Thread.currentThread()+":"+System.currentTimeMillis());
        Callable<String> callable = new Callable<String>() {
            public String call() throws Exception {
                System.out.println("副线程开始："+Thread.currentThread()+":"+System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("副线程结束并返回："+Thread.currentThread()+":"+System.currentTimeMillis());
                return "public Callable<String> async01() {}";
            }
        };
        System.out.println("主线程结束并返回："+Thread.currentThread()+":"+System.currentTimeMillis());
        return callable;
    }


    @ResponseBody
    @RequestMapping("/createDeferredResult")
    public DeferredResult<Object> deferredResult() {
        //超时时间：(long)4000
        //超时结：果"timeout..."
        DeferredResult<Object> objectDeferredResult = new DeferredResult<Object>((long)4000,"timeout...");
        //放入队列中
        DeferredResultQueue.save(objectDeferredResult);
        return objectDeferredResult;
    }

    //处理延迟的结果队列
    @ResponseBody
    @RequestMapping("handleDeferredResult")
    public String handleDeferredResult() {
        DeferredResult<Object> objectDeferredResult = DeferredResultQueue.get();
        objectDeferredResult.setResult(UUID.randomUUID().toString());//处理结果，createDeferredResult会立即运行
        return (String) objectDeferredResult.getResult();
    }
}
