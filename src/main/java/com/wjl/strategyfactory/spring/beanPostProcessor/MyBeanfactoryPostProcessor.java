package com.wjl.strategyfactory.spring.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/*************************************************************************
 ******
 * - Copyright (c) 2021 redshield.com
 * - File Name: MyBeanfactoryPostProcessor
 * - @Author: WangJiLIn
 * - Description:
 *
 *         applicationContext.addBeanFactoryPostProcessor(new MyBeanfactoryPostProcessor());
 *         这个是自己添加进去的
 *         @Component 这个是spring启动的时候加载进去的
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2021/1/14   WangJiLin     Create the current class
 *************************************************************************
 ******/
@Component
public class MyBeanfactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("1111111111111111111111111");
        AnnotatedBeanDefinition annotatedBeanDefinition = (AnnotatedBeanDefinition)beanFactory.getBeanDefinition("indexDao");
        annotatedBeanDefinition.setScope("prototype");
    }
}
