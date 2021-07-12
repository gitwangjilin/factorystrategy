package com.wjl.strategyfactory.aopioc.test;

import com.wjl.strategyfactory.aopioc.config.Appconfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*************************************************************************
 ******
 * - Copyright (c) 2021 shangzhao.com
 * - File Name: Test
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2021/7/7   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Appconfig.class);
    }
}
