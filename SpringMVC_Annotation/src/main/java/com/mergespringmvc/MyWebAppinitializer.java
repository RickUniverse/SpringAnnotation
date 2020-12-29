package com.mergespringmvc;

import com.mergespringmvc.config.AppConfig;
import com.mergespringmvc.config.RootConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author lijichen
 * @date 2020/11/30 - 21:01
 */
//Web容器启动的时候创建对象，调用方法来初始化容器以及控制器
public class MyWebAppinitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    //获取根容器的配置类：（Spring的配置文件），父容器
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    //获取web容器的配置类；（SpringMVC的配置文件），子容器
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{AppConfig.class};
    }

    //获取DispatcherServlet的映射信息
    //   /  : 拦截所有资源，包括静态资源但是不拦截.jsp资源
    //   /* : 拦截所有资源，包括静态资源和.jsp资源
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
