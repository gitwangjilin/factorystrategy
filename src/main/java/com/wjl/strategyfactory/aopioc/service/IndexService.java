package com.wjl.strategyfactory.aopioc.service;

import com.wjl.strategyfactory.spring.dao.IndexDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/*************************************************************************
 ******
 * - Copyright (c) 2021 shangzhao.com
 * - File Name: IndexService
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
@Service
public class IndexService {
    @Autowired
//    @Qualifier()
    public IndexDao indexDao;
}
