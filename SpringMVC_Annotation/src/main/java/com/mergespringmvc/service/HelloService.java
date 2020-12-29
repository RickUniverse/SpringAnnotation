package com.mergespringmvc.service;

import org.springframework.stereotype.Service;

/**
 * @author lijichen
 * @date 2020/11/30 - 21:15
 */
@Service
public class HelloService {
    public String sayHello(String name) {
        return "hello " + name;
    }
}
