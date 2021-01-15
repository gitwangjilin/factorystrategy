package com.wjl.strategyfactory.spring.test;

import com.wjl.strategyfactory.spring.app.Appconfig;
import com.wjl.strategyfactory.spring.dao.IndexDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*************************************************************************
 ******
 * - Copyright (c) 2021 redshield.com
 * - File Name: SpringTest
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
public class SpringTest {
    public static void main(String[] args) {
        //初始化bean
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Appconfig.class);
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(IndexDao.class);
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
//        applicationContext.register(IndexDao.class);
//        applicationContext.refresh();
        IndexDao bean = applicationContext.getBean(IndexDao.class);
        bean.query();
    }
}
