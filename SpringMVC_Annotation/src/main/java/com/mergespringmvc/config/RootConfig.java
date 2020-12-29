package com.mergespringmvc.config;

import com.mergespringmvc.pojo.Hello;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @author lijichen
 * @date 2020/11/30 - 21:10
 */
//Spring的容器不扫描controller
@ComponentScan(value = "com.mergespringmvc",excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
})
public class RootConfig {

    @Bean
    public Hello hello() {
        return new Hello();
    }
}
