package com.springannotation.config;

import com.springannotation.conditional.LinuxConditional;
import com.springannotation.conditional.MyImportBeanDefinitionRegistry;
import com.springannotation.conditional.MyImportSelector;
import com.springannotation.conditional.WindowConditional;
import com.springannotation.entities.*;
import org.springframework.context.annotation.*;

import java.util.Date;

/**
 * @author lijichen
 * @date 2020/11/27 - 16:39
 */
//如果注解加到这，说明满足条件的这个类的所有配置才会生效
//@Conditional(WindowConditional.class)
//@Conditional(LinuxConditional.class)
@Configuration
@ComponentScan(value = "com.springannotation.entities")
//导入组件，id默认是组件的全类名，
// MyImportSelector.class 是导入该选择器中的bean
//MyImportBeanDefinitionRegistry.class 判断并手工注册一个bean
@Import({Color.class, MyImportSelector.class, MyImportBeanDefinitionRegistry.class})
public class MyConfig2 {

    @Bean
    @Lazy
//    @Scope("prototype")
    public Person person() {
        System.out.println("向容器中添加person。。");
        return new Person(1,"ss",new Date());
    }

    /**
     * 如果是 window 操作系统创建 ：bill
     * 如果是linux 操作系统创建 ： linux
     * @return
     */
    @Conditional({WindowConditional.class})
    @Bean("bill")
    public Person bill() {
        return new Person(1,"bill",new Date());
    }
    @Conditional(LinuxConditional.class)
    @Bean("linus")
    public Person linus() {
        return new Person(2,"linus",new Date());
    }

    //注册工程bean
    @Bean
    public ColorFactoryBean colorFactoryBean() {
        return new ColorFactoryBean();
    }

    //生命周期
//    @Scope("prototype")
    @Bean(initMethod = "init", destroyMethod = "destory")
    public Life life() {
        return new Life();
    }

    @Bean
    public Life2 life2() {
        return new Life2();
    }
    @Bean
    public Life3 life3() {
        return new Life3();
    }
}
