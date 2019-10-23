package com.java.base.thread;

import java.util.Vector;

/**
 * @ClassName VectorSafe
 * @Description TODO
 * @Author LiJialiang
 * @Date 2019/7/6 12:10
 * @Version 1.0
 **/
public class VectorSafe {
    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        while (true) {
            /*add element*/
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }
            /*thread remove element*/
            Thread remove = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (vector) {
                        for (int i = 0; i < vector.size(); i++) {
                            vector.remove(i);
                        }
                    }
                }
            });
            /*thread get element*/
            Thread read = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (vector) {
                        for (int i = 0; i < vector.size(); i++) {
                            System.out.println(vector.get(i));
                        }
                    }
                }
            });
            remove.start();
            read.start();
            while (Thread.activeCount()>20);
        }
    }
}
