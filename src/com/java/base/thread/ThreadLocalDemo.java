package com.java.base.thread;

/**
 * @ClassName ThreadLocalDemo
 * @Description TODO
 * @Author LiJialiang
 * @Date 2019/7/6 13:31
 * @Version 1.0
 **/
public class ThreadLocalDemo {
    private static ThreadLocal<Integer> number = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public int getNumber() {
        number.set(number.get()+1);
        return number.get();
    }

    public static void main(String[] args) {
        ThreadLocalDemo s = new ThreadLocalDemo();
        TestClient testClient1 = new TestClient(s);
        TestClient testClient2 = new TestClient(s);
        TestClient testClient3 = new TestClient(s);
        testClient1.start();
        testClient2.start();
        testClient3.start();
    }

    private static class TestClient extends Thread{
        ThreadLocalDemo threadLocalDemo;

        public TestClient(ThreadLocalDemo threadLocalDemo) {
            this.threadLocalDemo = threadLocalDemo;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println("Thread name:"+Thread.currentThread().getName()+",number:"+threadLocalDemo.getNumber());
            }
        }
    }

}

