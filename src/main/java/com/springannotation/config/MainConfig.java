package com.springannotation.config;

import com.springannotation.entities.Person;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author lijichen
 * @date 2020/11/26 - 18:38
 */
//配置类==配置文件
@Configuration//告诉Spring这是一个配置类
/**
 * useDefaultFilters = false : 如果使用的是includeFilters，则需要将useDefaultFilters置为false，默认是扫描所有的
 * FilterType.CUSTOM : 使用自定义的规则
 */
@ComponentScans(value = {
        @ComponentScan(value = "com.springannotation",includeFilters = {
                @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyFilterType.class})
        },useDefaultFilters = false)
//        ,
//        @ComponentScan(value = "com.springannotation",excludeFilters = {
//                @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class, Service.class})
//        })
//        ,
//        @ComponentScan(value = "com.springannotation",includeFilters = {
//                @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Repository.class, Component.class})
//        }, useDefaultFilters = false)
} )
public class MainConfig {

    /**
     * @Bean("person") 是 id唯一标识，如果没有给值，则默认是方法名
     * @return 实例的对象
     */
    @Bean("person")//给容器中注册一个bean
    public Person person(){
        return new Person(1,"sdfa",new Date());
    }
}
