package com.wjl.strategyfactory.spring1.dao;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

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
public class IndexDao {
   public void indexDao(){
       System.out.println("初始化spring环境");
   }
}
