package com.java.base.net;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @ClassName Server
 * @Description TODO
 * @Author LiJialiang
 * @Date 2019/7/7 21:41
 * @Version 1.0
 **/
public class Server {
    public static void main(String[] args) {
        int clientNumber = 0;
        ServerSocket server = null;
        boolean listening = true;
        try {
            server = new ServerSocket(4700);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (listening) {
            try {
                new SocketThread(server.accept(),clientNumber).start();
                clientNumber++;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
