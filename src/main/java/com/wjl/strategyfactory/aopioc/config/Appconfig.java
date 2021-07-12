package com.wjl.strategyfactory.aopioc.config;

import ch.qos.logback.core.db.DriverManagerConnectionSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*************************************************************************
 ******
 * - Copyright (c) 2021 shangzhao.com
 * - File Name: Appconfig
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2021/7/7   WangJiLin     Create the current class
 *************************************************************************
 ******/
@Configuration
@ComponentScan(value = "com.wjl.strategyfactory.aopioc")
//@ComponentScan(value = "com.wjl.strategyfactory.aopioc",
//        excludeFilters = {@ComponentScan.Filter(type = FilterType.REGEX,pattern = "com.wjl.*")})
public class  Appconfig {
//    @Bean
//     SqlsessionFactoryBean sqlsessionFactoryBean(DriverManagerConnectionSource driverManagerConnectionSource){
//        return  new SqlsessionFactory();
//    }
//    public DriverManagerConnectionSource dataSource(){
//        DriverManagerConnectionSource driver = new DriverManagerConnectionSource();
//        driver.setDriverClass("");
//        return driver;
//    }
}
