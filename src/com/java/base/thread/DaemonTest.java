package com.java.base.thread;

/**
 * @ClassName DaemonTest
 * @Description TODO
 * @Author LiJialiang
 * @Date 2019/6/30 18:58
 * @Version 1.0
 **/
public class DaemonTest {
    public static void main(String[] args) {
        System.out.println("main start");
        DaemonT1 t1 = new DaemonT1();
        t1.setDaemon(true);
        t1.start();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main end");
    }
}

class DaemonT1 extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("==========");
        }
    }
}
