package com.mergespringmvc.message;

import com.mergespringmvc.config.RootConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lijichen
 * @date 2020/11/30 - 22:02
 */
public class TestConfig {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class);
        Object hello = context.getBean("hello");
        System.out.println(hello);
    }
}
