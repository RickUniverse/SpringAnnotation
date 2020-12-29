package com.springannotation.manager;

import com.springannotation.aop.ConfigOfAOP;
import com.springannotation.aop.MathCalculator;
import com.springannotation.config.*;
import com.springannotation.entities.Person;
import com.springannotation.tx.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * @author lijichen
 * @date 2020/11/26 - 18:42
 */
public class TestAnnotation {

    private ApplicationContext applicationContext;


    @Test
    public void testTX() throws SQLException {
        applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService bean = applicationContext.getBean(UserService.class);

        bean.insert();

    }


    @Test
    public void testAspectsAOP() {
        applicationContext = new AnnotationConfigApplicationContext(ConfigOfAOP.class);
        MathCalculator bean = applicationContext.getBean(MathCalculator.class);
        bean.div(1,0);

    }




    //自动装配
    @Test
    public void testProfile() {
        applicationContext = new AnnotationConfigApplicationContext();
        //1，设置需要激活的环境
        ((AnnotationConfigApplicationContext) applicationContext).getEnvironment().setActiveProfiles("test","dev");
        //2,注册配置类
        ((AnnotationConfigApplicationContext) applicationContext).register(ConfigProfile.class);
        //3,启动刷新容器
        ((AnnotationConfigApplicationContext) applicationContext).refresh();
        String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
    }
    @Test
    public void testAutoWrite() {
        applicationContext = new AnnotationConfigApplicationContext(ConfigAutoWriter.class);

        Object bookService = applicationContext.getBean("bookService");
        Object color = applicationContext.getBean("color");

        System.out.println(bookService);
        System.out.println(color);

    }


    @Test
    public void testAssignAttlibute() {
        applicationContext = new AnnotationConfigApplicationContext(ConfigAttribute.class);
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);
    }


    @Test
    public void testBeanLife() {
        applicationContext = new AnnotationConfigApplicationContext(MyConfig2.class);
        Object life = applicationContext.getBean("life");
        Object life2 = applicationContext.getBean("life2");
        Object life3 = applicationContext.getBean("life3");

        ((AnnotationConfigApplicationContext) applicationContext).close();
    }



    @Test
    public void testFactoryBean() {
        applicationContext = new AnnotationConfigApplicationContext(MyConfig2.class);
        Object colorBlue = applicationContext.getBean("colorFactoryBean");
        Object colorBlue2 = applicationContext.getBean("colorFactoryBean");
        System.out.println(colorBlue.getClass());
        System.out.println(colorBlue == colorBlue2);


    }


    @Test
    public void testConditional() {
        applicationContext = new AnnotationConfigApplicationContext(MyConfig2.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);

        }
        System.out.println("------------------------");
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        System.out.println(Arrays.toString(beanNamesForType));
        Environment environment = applicationContext.getEnvironment();
        System.out.println(environment.getProperty("os.name"));
    }


    @Test
    public void testComponentScan2() {
        applicationContext = new AnnotationConfigApplicationContext(MyConfig2.class);
        Object person = applicationContext.getBean("person");
        Object person2 = applicationContext.getBean("person");
    }
    @Test
    public void testComponentScan() {
        applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();//容器中所有的对象
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);

        }
    }


    @Test
    public void testAnnotation() {
        applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person bean = applicationContext.getBean(Person.class);
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
        System.out.println(bean);
    }

    @Test
    public void testXML() {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person bean = applicationContext.getBean(Person.class);
        System.out.println(bean);
    }

}
