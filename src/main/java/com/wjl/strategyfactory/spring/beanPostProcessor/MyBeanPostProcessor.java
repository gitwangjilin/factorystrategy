package com.wjl.strategyfactory.spring.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/*************************************************************************
 ******
 * - Copyright (c) 2021 redshield.com
 * - File Name: BeanPostProcessor
 * - @Author: WangJiLIn
 * - Description:
 *  BeanPostProcessor是spring框架的提供一个扩展类点
 *  通过实行BeanPostProcessor接口，可以插手bean实例化的过程
 *  aop也是通过BeanPostProcessor和ioc容器建立联系
 * 接⼝描述
 * - Functions:
 *  PriorityOrdered 加载顺序 越小越先
 * - History:
 * Date        Author          Modification
 * 2021/1/14   WangJiLin     Create the current class
 *************************************************************************
 ******/
//
@Component
public class MyBeanPostProcessor implements BeanPostProcessor, PriorityOrdered {
    /**
     * 初始化之前执行
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("indexDao")) {
            System.out.println("postProcessBeforeInitialization");
        }
//        Proxy.newProxyI nstance()
        return bean;
    }

    /**
     * 初始化之后执行
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("indexDao")) {
            System.out.println("postProcessAfterInitialization");
        }
        return bean;
    }

    @Override
    public int getOrder() {
        return 100;
    }
}
