package com.springannotation.entities;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.util.StringValueResolver;

/**
 * @author lijichen
 * @date 2020/11/27 - 17:28
 */
public class Color implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {
    public void setBeanName(String s) {
        System.out.println("当前bean的name（id）："+s);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContext(IOC容器)："+applicationContext);
    }

    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        String resolveStringValue = stringValueResolver.
                resolveStringValue("这是setEmbeddedValueResolver解析后的字符串：${os.name},#{123*123}");
        System.out.println(resolveStringValue);
    }
}
