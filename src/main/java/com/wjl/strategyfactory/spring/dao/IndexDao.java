package com.wjl.strategyfactory.spring.dao;

import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Repository;

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
@Repository
//@Description("dao") processCommonDefinitionAnnotations 扫描注解
public class IndexDao {
    public  void  query(){
        System.out.println("dao获取到了");
    }
}
