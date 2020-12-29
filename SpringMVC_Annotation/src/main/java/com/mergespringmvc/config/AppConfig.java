package com.mergespringmvc.config;

import com.mergespringmvc.interceptor.MyInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author lijichen
 * @date 2020/11/30 - 21:10
 */
//springMVC扫描controller注解
//useDefaultFilters：禁用默认的过滤规则
@ComponentScan(value = "com.mergespringmvc", includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
}, useDefaultFilters = false)
@EnableWebMvc//开启SpringMVC定制配置功能：WebMvcConfigurerAdapter才能使用
public class AppConfig extends WebMvcConfigurerAdapter {


    //视图解析器
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/",".jsp");
    }

    //设置web使用静态资源，相当于xml中的default-servlet-handler
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    //处理静态资源方式二
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/WEB-INF/**").addResourceLocations( "/static/");
//    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/**");//不管任意层的路径，拦截任意多的请求
    }
}
