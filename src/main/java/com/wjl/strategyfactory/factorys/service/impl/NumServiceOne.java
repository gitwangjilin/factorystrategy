package com.wjl.strategyfactory.factorys.service.impl;

import com.wjl.strategyfactory.factorys.constant.Type;
import com.wjl.strategyfactory.factorys.service.NumService;
import org.springframework.stereotype.Component;

/*************************************************************************
 ******
 * - Copyright (c) 2020 redshield.com
 * - File Name: NumServiceOne
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2020/11/4   WangJiLin     Create the current class
 *************************************************************************
 ******/
@Component(Type.NUM_0)
public class NumServiceOne implements NumService {
    @Override
    public String getNum() {
    return "000000000000000000";
    }
}
