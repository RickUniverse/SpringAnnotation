package com.springannotation.entities;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author lijichen
 * @date 2020/11/27 - 18:32
 */
public class Life3 {

    public Life3() {
        System.out.println("Life3  constorion.....");
    }

    @PostConstruct//对象创建并赋值之后调用
    public void init() {
        System.out.println("Life3  PostConstruct....");
    }

    @PreDestroy//容器移除对象之前
    public void destory() {
        System.out.println("Life3  PreDestroy.....");
    }
}
