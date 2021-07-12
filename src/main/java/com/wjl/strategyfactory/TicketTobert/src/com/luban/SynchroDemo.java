package com.wjl.strategyfactory.TicketTobert.src.com.luban;

import java.util.concurrent.TimeUnit;

/*************************************************************************
 ******
 * - Copyright (c) 2021 shangzhao.com
 * - File Name: SynchroDemo
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2021/6/22   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class SynchroDemo {
    //修饰静态方法
    public synchronized static void accessResources0(){
        try {

            TimeUnit.SECONDS.sleep(2);
            System.out.println(Thread.currentThread().getName()+" is runing");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //修饰非静态方法

    //代码块1（对象）this指的是当前对象
    public  void accessResources1(){
        synchronized(this){
            try {
                synchronized (this){
                    TimeUnit.MINUTES.sleep(2);
                }
                System.out.println(Thread.currentThread().getName()+" is runing");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //代码块1（CLASS类）
    public  void accessResources4(){
        synchronized(SynchroDemo.class){//ClassLoader  class  ——-》堆   Class   所有的对象
            //有Class对象的所有的对象都共同使用这一个锁
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName()+" is runing");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        final SynchroDemo deno01=new SynchroDemo();
        for (int i = 0; i < 5; i++) {
            new Thread(deno01::accessResources1).start();
        }
    }
}
