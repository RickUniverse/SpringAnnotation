package com.springannotation.entities;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author lijichen
 * @date 2020/11/27 - 18:32
 */
public class Life2 implements InitializingBean, DisposableBean {

    public Life2() {
        System.out.println("Life2  constorion.....");
    }

    public void destroy() throws Exception {
        System.out.println("Life2  destory....");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("Life2  afterPropertiesSet....");
    }
}
