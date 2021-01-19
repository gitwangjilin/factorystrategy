package com.wjl.strategyfactory.spring.app;

import com.wjl.strategyfactory.spring.beanPostProcessor.MyImportSelector;
import com.wjl.strategyfactory.spring.eanble.Eanble;
import com.wjl.strategyfactory.spring.mybatis.MyImportSelect;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/*************************************************************************
 ******
 * - Copyright (c) 2021 redshield.com
 * - File Name: Appconfig
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
@Configuration
@ComponentScan("com.wjl.strategyfactory.spring")
//@Eanble
public class Appconfig {
}
