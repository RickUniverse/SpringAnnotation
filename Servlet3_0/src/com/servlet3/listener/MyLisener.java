package com.servlet3.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author lijichen
 * @date 2020/11/30 - 19:43
 */
public class MyLisener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("MyLisener[contextInitialized] method run ServletContext Create...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("MyLisener[contextInitialized] method run ServletContext Destroy...");
    }
}
