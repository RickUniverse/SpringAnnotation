package com.springannotation.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author lijichen
 * @date 2020/11/28 - 18:27
 */
@Configuration
@EnableAspectJAutoProxy//开启切面动态代理
public class ConfigOfAOP {

    //将切入点类加入到IOC容器中
    @Bean
    public MathCalculator mathCalculator() {
        return new MathCalculator();
    }
    //将切面类加入到IOC容器中
    @Bean
    public LogAspects logAspects() {
        return new LogAspects();
    }
}
