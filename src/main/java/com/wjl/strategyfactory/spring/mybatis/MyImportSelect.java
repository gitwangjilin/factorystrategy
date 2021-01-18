package com.wjl.strategyfactory.spring.mybatis;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/*************************************************************************
 ******
 * - Copyright (c) 2021 redshield.com
 * - File Name: MyImportSelect
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
public class MyImportSelect implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[0];
    }
}
