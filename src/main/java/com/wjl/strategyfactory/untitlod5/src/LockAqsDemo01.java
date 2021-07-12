package com.wjl.strategyfactory.untitlod5.src;

import java.util.concurrent.TimeUnit;

public class LockAqsDemo01 {
    private int m = 0;

    public int next() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return m++;
    }

    public static void main(String[] args) {
        LockAqsDemo01 lockAqsDemo = new LockAqsDemo01();
        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread(() -> {
                System.out.println(lockAqsDemo.next());
            });
            threads[i].start();
        }
    }
}
