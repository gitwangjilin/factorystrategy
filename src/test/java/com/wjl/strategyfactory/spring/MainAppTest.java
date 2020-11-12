package com.wjl.strategyfactory.spring;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*************************************************************************
 ******
 * - Copyright (c) 2020 redshield.com
 * - File Name: MainAppTest
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2020/11/12   WangJiLin     Create the current class
 *************************************************************************
 ******/
@SpringBootTest
public class MainAppTest {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("Beans.xml");
//        scope 在spring IoC容器仅存在一个Bean实例，Bean以单例方式存在，默认值
//        Your Message : ceshi
//        Your Message : ceshi
//        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
//        obj.setMessage("ceshi");
//        HelloWorld objA = (HelloWorld) context.getBean("helloWorld");
//        objA.getMessage();
//        HelloWorld objB = (HelloWorld) context.getBean("helloWorld");
//        objB.getMessage();

//        prototype  每次从容器中调用Bean时，都返回一个新的实例，即每次调用getBean()时，相当于执行newXxxBean()
//        Your Message : I'm object A
//        Your Message : null
//        HelloWorld objA = (HelloWorld) context.getBean("helloWorld");
//        objA.setMessage("I'm object A");
//        objA.getMessage();
//        HelloWorld objB = (HelloWorld) context.getBean("helloWorld");
//        objB.getMessage();
//        context.registerShutdownHook();




//        XmlBeanFactory factory = new XmlBeanFactory
//                (new ClassPathResource("Beans.xml"));
//        HelloWorld obj = (HelloWorld) factory.getBean("helloWorld");
//        obj.getMessage();



//        ApplicationContext context = new FileSystemXmlApplicationContext
//                ("C:\\Users\\Chinadaas\\v1.1\\user\\factorystrategy\\src\\main\\resources\\Beans.xml");
//        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
//        obj.getMessage();
    }
}
