package com.java.base.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName AtomicIntegerDemo
 * @Description TODO
 * @Author LiJialiang
 * @Date 2019/7/6 13:03
 * @Version 1.0
 **/
public class AtomicIntegerDemo {
    // private volatile int count = 0;
    //
    // public synchronized void increase() {
    //     count++;
    // }
    // public int get(){
    //     return count;
    // }

    private AtomicInteger counter = new AtomicInteger();
    public void increase() {
        counter.incrementAndGet();
    }
    public int get() {
        return counter.get();
    }

}
