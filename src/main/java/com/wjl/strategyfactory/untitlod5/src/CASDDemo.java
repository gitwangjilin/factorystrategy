package com.wjl.strategyfactory.untitlod5.src;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDDemo {
    private static volatile int m = 0;
    //具有原子性自增
    private static AtomicInteger atomicI = new AtomicInteger(0);

    public static void increase1() {
        m++;
    }

    public static void increase2() {
        atomicI.incrementAndGet();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                CASDDemo.increase1();
            }).start();
        }
        System.out.println(m);
        System.out.println("============");
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                CASDDemo.increase2();
            }).start();
        }
        System.out.println(m);
    }
}
