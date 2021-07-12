package com.wjl.strategyfactory.untitlod5.src;

public class LockAqsDemo02 {
    private MyLock lockAQS = new MyLock();
    private int m = 0;

    public int next() {
        lockAQS.lock();
        try {
            return m++;
        } finally {
            lockAQS.unlock();
        }
    }

    public static void main(String[] args) {
        LockAqsDemo02 lockAqsDemo = new LockAqsDemo02();
        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread(() -> {
                System.out.println(lockAqsDemo.next());
            });
            threads[i].start();
        }
    }
}
