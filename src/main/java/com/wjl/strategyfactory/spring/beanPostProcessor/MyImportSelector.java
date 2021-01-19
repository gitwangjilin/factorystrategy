package com.wjl.strategyfactory.spring.beanPostProcessor;

import com.wjl.strategyfactory.spring.dao.IndexDao3;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/*************************************************************************
 ******
 * - Copyright (c) 2021 redshield.com
 * - File Name: MyImportSelector
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
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        System.out.println("MyImportSelector");
        return new String[]{IndexDao3.class.getName()};
    }
}
