package com.wjl.strategyfactory.jdk8.src;

import java.util.ArrayList;
import java.util.List;
//引用
public class Java8Cite {
    public static void main(String[] args) {
        List<String> names = new ArrayList();

        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");
        names.forEach(System.out::println);
    }
}
