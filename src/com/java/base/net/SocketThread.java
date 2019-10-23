package com.java.base.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @ClassName SocketThread
 * @Description TODO
 * @Author LiJialiang
 * @Date 2019/7/7 21:43
 * @Version 1.0
 **/
public class SocketThread extends Thread {
    Socket socket;
    int clientNumber;

    public SocketThread(Socket socket, int clientNumber) {
        this.socket = socket;
        this.clientNumber = clientNumber+1;
    }

    @Override
    public void run() {
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Client"+clientNumber+":"+is.readLine());
            String readLine;
            readLine = sin.readLine();
            while (!readLine.equals("bye")) {
                pw.println(readLine);
                pw.flush();
                System.out.println("Server:"+readLine);
                System.out.println("Client"+clientNumber+":"+is.readLine());
                readLine = sin.readLine();
            }
            is.close();
            pw.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
