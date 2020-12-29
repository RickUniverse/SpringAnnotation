package com.springannotation.entities;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author lijichen
 * @date 2020/11/27 - 18:14
 */
public class ColorFactoryBean implements FactoryBean<Blue> {
    //返回什么类型
    public Blue getObject() throws Exception {
        return new Blue();
    }

    public Class<?> getObjectType() {
        return Blue.class;
    }

    //是否是单例的
    //flase表示不是单例
    //true表示是单例的
    public boolean isSingleton() {
        return false;
    }
}
