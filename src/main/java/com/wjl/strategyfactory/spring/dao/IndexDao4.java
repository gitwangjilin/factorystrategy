package com.wjl.strategyfactory.spring.dao;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

/*************************************************************************
 ******
 * - Copyright (c) 2021 redshield.com
 * - File Name: IndexDao
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2021/1/10   WangJiLin     Create the current class
 *************************************************************************
 ******/
//@Repository
//@Description("dao") processCommonDefinitionAnnotations 扫描注解
public class IndexDao4 implements BeanPostProcessor {
    public IndexDao4(){
        System.out.println("构造方法");
    }
//    @PostConstruct
//    public void init(){
//        System.out.println("init");
//    }
    public  void  query(){
        System.out.println("dao获取到了");
    }

    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("indexDao")){

        }
        return null;
    }

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }
}
