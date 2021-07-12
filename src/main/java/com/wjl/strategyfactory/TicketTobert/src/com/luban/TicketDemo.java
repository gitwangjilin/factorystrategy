package com.wjl.strategyfactory.TicketTobert.src.com.luban;

/*************************************************************************
 ******
 * - Copyright (c) 2021 shangzhao.com
 * - File Name: TicketDemo
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
public class TicketDemo extends Thread {
    private  int index = 1;
    private static final int Max = 50;

    @Override
    public void run() {
        synchronized (this) {
            while (index <= Max) {
                System.out.println(Thread.currentThread().getName() + "叫到的号码是：" + (index++));
            }
        }
    }

    public static void main(String[] args) {
        TicketDemo t1 = new TicketDemo();
        TicketDemo t2 = new TicketDemo();
        TicketDemo t3 = new TicketDemo();
        TicketDemo t4 = new TicketDemo();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
