package com.java.base.net;

/**
 * @ClassName MulticastServer
 * @Description TODO
 * @Author LiJialiang
 * @Date 2019/7/8 20:35
 * @Version 1.0
 **/
public class MulticastServer {
    public static void main(String[] args) {
        new MulticastServerThread().start();
    }
}
