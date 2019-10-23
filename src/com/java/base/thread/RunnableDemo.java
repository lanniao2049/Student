package com.java.base.thread;

/**
 * @ClassName RunnableDemo
 * @Description TODO
 * @Author LiJialiang
 * @Date 2019/6/30 13:22
 * @Version 1.0
 **/
public class RunnableDemo {

    public static void main(String[] args) {
        // RunnableT2 t2  = new RunnableT2();
        // new Thread(t2,"thread1").start();
        // new Thread(t2,"thread2").start();
        // new Thread(t2,"thread3").start();
        Ticket ticket = new Ticket(200);
        new Consumer(ticket).start();
        new Producer(ticket).start();
    }

}

class RunnableT1 implements Runnable {
    private long sleepTime;
    public RunnableT1() {
        this.sleepTime = (long) ((Math.random())*6000);
    }

    @Override
    public void run() {
        System.out.println("Runnable start,"+Thread.currentThread().getName());
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Runnable end,"+Thread.currentThread().getName()+",sleepTime:"+sleepTime);
    }
}

class RunnableT2 implements Runnable {
    private int ticket = 200;

    @Override
    public void run() {
        while (ticket > 0) {
            System.out.println(Thread.currentThread().getName()+" is selling ticket:"+ticket--);
        }
    }
}

class Ticket {
    int number = 0;
    int i = 0;
    int size;
    boolean available = false;

    public Ticket(int size) {
        this.size = size;
    }

    public synchronized void put() {
        if (available) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Producer puts ticket:"+(++number));
        available = true;
        notify();
    }

    public synchronized void buy() {
        if (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (available == true && i <= number) {
            System.out.println("Consumer buys ticket:"+(++i));
        }
        if (i == number) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            available = false;
        }
        notify();
    }
}

class Producer extends Thread {
    Ticket ticket = null;

    public Producer(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public void run() {
        while (ticket.number < ticket.size) {
            // System.out.println("Producer ticket:"+(++ticket.number));
            // ticket.available = true;
            ticket.put();
        }
    }
}

class Consumer extends Thread {
    Ticket ticket = null;
    int i = 0;

    public Consumer(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public void run() {
        while (ticket.i < ticket.size) {
            // if (ticket.available == true && i <= ticket.number) {
            //     System.out.println("Consumer ticket:"+(++i));
            // }
            // if (i == ticket.number) {
            //     try {
            //         Thread.sleep(1);
            //     } catch (InterruptedException e) {
            //         e.printStackTrace();
            //     }
            //     ticket.available = false;
            // }
            ticket.buy();
        }

    }
}