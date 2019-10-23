package com.java.base.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ReentrantlockDemo
 * @Description TODO
 * @Author LiJialiang
 * @Date 2019/7/6 12:37
 * @Version 1.0
 **/
public class ReentrantlockDemo {
    private static ReentrantLock lock = new ReentrantLock();

    public void write() {
        lock.lock();
        try {
            long startTime = System.currentTimeMillis();
            System.out.println("will write work!");
            for (; ; ) {
                if (System.currentTimeMillis() - startTime > Integer.MAX_VALUE) {
                    break;
                }
            }
            System.out.println("write work done!");
        } finally {
            lock.unlock();
        }
    }

    public void read() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            System.out.println("read work !!");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantlockDemo reentrantlockDemo = new ReentrantlockDemo();
        reentrantlockDemo.write();
        reentrantlockDemo.read();
    }
}
