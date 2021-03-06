package com.wjl.strategyfactory.aopioc.dao;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

/*************************************************************************
 ******
 * - Copyright (c) 2021 shangzhao.com
 * - File Name: IndexDaoImpl
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2021/7/12   WangJiLin     Create the current class
 *************************************************************************
 ******/
@Repository
public class IndexDaoImpl2 implements IndexDao ,InitializingBean {
    public IndexDaoImpl2(){
        System.out.println("Constructor");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("init");
    }
    @PostConstruct
    public void init(){
        System.out.println("init  PostConstruct");
    }
}
