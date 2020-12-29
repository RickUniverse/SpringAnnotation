package com.springannotation.config;

import com.springannotation.entities.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author lijichen
 * @date 2020/11/27 - 19:41
 */
@PropertySource(value = {"classpath:/person.properties"})
@Configuration
public class ConfigAttribute {

    @Bean
    public Person person() {
        return new Person(1,"asdfasdf",null);
    }
}
