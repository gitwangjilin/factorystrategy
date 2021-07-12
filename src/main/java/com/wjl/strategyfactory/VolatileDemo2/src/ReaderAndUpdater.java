package com.wjl.strategyfactory.VolatileDemo2.src;

import java.util.concurrent.TimeUnit;

public class ReaderAndUpdater {
    final static int Max = 50;
    //
    static volatile int init_value = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            int localValue = init_value;
            while (localValue < Max) {
                if (localValue != init_value) {
                    System.out.println("The init_value:" + init_value);
                    localValue = init_value;
                }
            }
        }, "Reader").start();
        new Thread(() -> {
            int localValue = init_value;
            while (localValue < Max) {
                System.out.println("updateL:" + (++localValue));
                init_value = localValue;
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "update").start();
    }
}
