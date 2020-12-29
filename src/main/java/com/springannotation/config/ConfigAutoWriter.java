package com.springannotation.config;

import com.springannotation.dao.BookDao;
import com.springannotation.entities.Color;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author lijichen
 * @date 2020/11/28 - 15:57
 */
@Configuration
@ComponentScan({"com.springannotation.dao","com.springannotation.service","com.springannotation.controller"})
public class ConfigAutoWriter {

    @Bean
    public Color color() {
        return new Color();
    }

    @Primary//优先装配这个对象，没有Qualifier优先级高
    @Bean
    public BookDao bookDao2(Color color){//自动装配，默认就是@Autowrite的效果
        return new BookDao(color);
    }
}
