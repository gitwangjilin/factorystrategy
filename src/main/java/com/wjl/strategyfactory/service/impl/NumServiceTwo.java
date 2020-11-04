package com.wjl.strategyfactory.service.impl;

import com.wjl.strategyfactory.constant.Type;
import com.wjl.strategyfactory.service.NumService;
import org.springframework.stereotype.Component;

/*************************************************************************
 ******
 * - Copyright (c) 2020 redshield.com
 * - File Name: NumServiceTwo
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
@Component(Type.NUM_1)
public class NumServiceTwo implements NumService {
    @Override
    public String getNum() {
        return "1111111111111";
    }
}
