package com.wjl.strategyfactory.spring.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*************************************************************************
 ******
 * - Copyright (c) 2021 redshield.com
 * - File Name: CardService
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
@Component
public class CardService {
    @Autowired
    CardDao cardDao;
    public void list(){
        cardDao.list();
        System.out.println();
    }
}
