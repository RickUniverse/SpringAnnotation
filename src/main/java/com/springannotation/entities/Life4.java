package com.springannotation.entities;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author lijichen
 * @date 2020/11/27 - 18:32
 */
@Component
public class Life4 implements BeanPostProcessor, ApplicationContextAware {

    private ApplicationContext applicationContext;

    public Life4() {
        System.out.println("Life4  constorion.....");
        //报错
//        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//        System.out.println(beanDefinitionNames.length);
    }

    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessBeforeInitialization:+name" + s + "Bean:  " + o);
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessAfterInitialization:+name" + s + "Bean:  " + o);
        return o;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
