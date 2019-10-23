package com.java.base.thread;

/**
 * @ClassName Ex_8
 * @Description TODO deadLock demo
 * @Author LiJialiang
 * @Date 2019/7/1 5:47
 * @Version 1.0
 **/
public class Ex8_12 {
    public static void main(String[] args) {
        Ball ball = new Ball();
        Player0 player0 = new Player0(ball);
        Player1 player1 = new Player1(ball);
        Player2 player2 = new Player2(ball);
        player0.start();
        player1.start();
        player2.start();

    }
}

class Ball {
    boolean ballFlag0 = false;
    boolean ballFlag1 = false;
    boolean ballFlag2 = false;
}

class Player0 extends Thread {
    Ball ball = null;

    public Player0(Ball ball) {
        this.ball = ball;
    }

    @Override
    public void run() {
        while (true) {
            while (ball.ballFlag1 == true) {

            }
            ball.ballFlag1  = true;
            while (ball.ballFlag0) {

            }
            if (ball.ballFlag1 == true && ball.ballFlag0 == false) {
                ball.ballFlag0 = true;
                System.out.println("player0 get ball");
                ball.ballFlag1 = false;
                ball.ballFlag0 = false;
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Player1 extends Thread {
    Ball ball = null;

    public Player1(Ball ball) {
        this.ball = ball;
    }

    @Override
    public void run() {
        while (true) {
            while (ball.ballFlag0 == true) {

            }
            ball.ballFlag0 = true;
            while (ball.ballFlag2 == true) {

            }
            if (ball.ballFlag0 == true && ball.ballFlag2 == false) {
                ball.ballFlag2 = true;
                System.out.println("player1 get ball");
                ball.ballFlag0 = false;
                ball.ballFlag2 = false;
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

class Player2 extends Thread {
    Ball ball = null;

    public Player2(Ball ball) {
        this.ball = ball;
    }

    @Override
    public void run() {
        while (true) {
            while (ball.ballFlag2 == true) {

            }
            ball.ballFlag2 = true;
            while (ball.ballFlag1 == true) {

            }
            if (ball.ballFlag2 == true && ball.ballFlag1 == false) {
                ball.ballFlag1 = true;
                System.out.println("player2 get ball");
                ball.ballFlag2 = false;
                ball.ballFlag1 = false;
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
