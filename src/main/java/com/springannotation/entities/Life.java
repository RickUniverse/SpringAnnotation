package com.springannotation.entities;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author lijichen
 * @date 2020/11/27 - 18:32
 */
public class Life {

    public Life() {
        System.out.println("Life  constorion.....");
    }

    public void init() {
        System.out.println("Life  init....");
    }

    public void destory() {
        System.out.println("Life  destory.....");
    }
}
