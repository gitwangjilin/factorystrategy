package com.wjl.strategyfactory.spring1.test;

import com.wjl.strategyfactory.spring1.app.Appconfig;
import com.wjl.strategyfactory.spring1.dao.IndexDao;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

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
        //注释配置应用程序上下文
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Appconfig.class);
        IndexDao bean = applicationContext.getBean(IndexDao.class);
        bean.indexDao();
    }

}
