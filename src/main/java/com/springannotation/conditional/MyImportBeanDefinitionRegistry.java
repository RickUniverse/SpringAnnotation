package com.springannotation.conditional;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author lijichen
 * @date 2020/11/27 - 17:50
 */
public class MyImportBeanDefinitionRegistry implements ImportBeanDefinitionRegistrar {
    /**
     *
     * @param annotationMetadata : 当前类的注解信息
     * @param beanDefinitionRegistry ：BeanDefinition注册类
     *                               把所有需要添加到容器中的bean；调用
     *                               BeanDefitionRegistry。registryBeanDefinition手工注册进来
     */
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        boolean definition = beanDefinitionRegistry.containsBeanDefinition("com.springannotation.entities.Yellow");
        boolean definition2 = beanDefinitionRegistry.containsBeanDefinition("com.springannotation.entities.Blue");

        if (definition && definition2) {
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition();
//            beanDefinitionRegistry.registerBeanDefinition("rainBow",new RootBeanDefinition());//手工注册一个rainbow
        }
    }
}
