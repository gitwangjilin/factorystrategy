package com.wjl.strategyfactory.spring;

/*************************************************************************
 ******
 * - Copyright (c) 2020 redshield.com
 * - File Name: HelloWorld
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2020/11/12   WangJiLin     Create the current class
 *************************************************************************
 ******/
//@Data
public class HelloWorld {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public void getMessage() {
        System.out.println("Your Message : " + message);
    }
    public void init(){
        System.out.println("Bean is going through init.");
    }
    public void destroy(){
        System.out.println("Bean will destroy now.");
    }
}
