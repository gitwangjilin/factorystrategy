package com.wjl.strategyfactory.spring.mybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/*************************************************************************
 ******
 * - Copyright (c) 2021 redshield.com
 * - File Name: MyInvocationHandler
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
public class MyInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理");
        return null;
    }
}
