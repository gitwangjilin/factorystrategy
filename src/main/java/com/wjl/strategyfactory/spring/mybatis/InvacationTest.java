package com.wjl.strategyfactory.spring.mybatis;

import org.aspectj.weaver.ast.Test;

import java.lang.reflect.Proxy;

/*************************************************************************
 ******
 * - Copyright (c) 2021 redshield.com
 * - File Name: InvacationTest
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2021/1/17   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class InvacationTest {
    public static void main(String[] args) {
        CardDao dao = (CardDao)Proxy.newProxyInstance(Test.class.getClassLoader(), new Class[]{CardDao.class}, new MyInvocationHandler());
    }
}
