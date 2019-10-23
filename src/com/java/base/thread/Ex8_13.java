package com.java.base.thread;

/**
 * @ClassName Ex8_13
 * @Description TODO Priority
 * @Author LiJialiang
 * @Date 2019/7/1 6:27
 * @Version 1.0
 **/
public class Ex8_13 {
    public static void main(String[] args) {
        TestThread[] runners = new TestThread[2];
        for (int i = 0; i < runners.length; i++) {
            runners[i] = new TestThread(i);
        }
        runners[0].setPriority(2);
        runners[1].setPriority(3);
        for (int i = 0; i < runners.length; i++) {
            runners[i].start();
        }

    }
}

class TestThread extends Thread {
    int ticket = 1;
    int num;

    public TestThread(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        while (ticket < 400000) {
            ticket++;
            if (ticket % 50000 == 0) {
                System.out.println("Thread:"+num+",ticket:"+ticket);
                yield();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
