package com.wjl.strategyfactory.spring.beanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/*************************************************************************
 ******
 * - Copyright (c) 2021 redshield.com
 * - File Name: MyIovocationHandler
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2021/1/19   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class MyIovocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
