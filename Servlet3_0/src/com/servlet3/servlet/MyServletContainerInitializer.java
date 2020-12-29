package com.servlet3.servlet;

import com.servlet3.filter.MyFilter;
import com.servlet3.listener.MyLisener;
import com.servlet3.service.HelloService;
import com.servlet3.service.MyServlet;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.util.EnumSet;
import java.util.Set;

/**
 * @author lijichen
 * @date 2020/11/30 - 19:17
 */
//传入感兴趣的类型，该类型的所有子接口实现类会在web启动时放在Set<Class<?>> set 集合中
@HandlesTypes(value = {HelloService.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {

    /**
     *
     * @param set 感兴趣的类存放在这里
     * @param servletContext
     * @throws ServletException
     */
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        for (Class<?> aClass : set) {
            System.out.println(aClass);
        }

        //注册组件
        //自己创建new MyServlet()
        ///myServletzh:注册组件
        ServletRegistration.Dynamic dynamic = servletContext.addServlet("myServlet", new MyServlet());
        dynamic.addMapping("/testMyServlet");//映射请求
        //注册Listener ， 直接传入类型
        servletContext.addListener(MyLisener.class);

        //注册Filter,
        //让tomcat创建：MyFilter.class
        FilterRegistration.Dynamic myFilter = servletContext.addFilter("myFilter", MyFilter.class);
        /**
         * 调度类型：DispatcherType.REQUEST
         * 拦截所有请求："/*"
         */
        myFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");

    }
}
