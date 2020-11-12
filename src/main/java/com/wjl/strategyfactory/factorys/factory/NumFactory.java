package com.wjl.strategyfactory.factorys.factory;

import com.wjl.strategyfactory.factorys.service.NumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*************************************************************************
 ******
 * - Copyright (c) 2020 redshield.com
 * - File Name: NumFactory
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
@Component
public class NumFactory {
    @Autowired
    private Map<String, NumService> context = new ConcurrentHashMap<>();
    public NumService getLicRetInfo(String type) {
        return this.context.get(type);
    }

}



