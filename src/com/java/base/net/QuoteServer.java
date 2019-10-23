package com.java.base.net;

/**
 * @ClassName QuoteServer
 * @Description TODO
 * @Author LiJialiang
 * @Date 2019/7/8 5:15
 * @Version 1.0
 **/
public class QuoteServer {
    public static void main(String[] args) {
        new QuoteServerThread().start();
    }
}
