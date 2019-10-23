package com.java.base.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName ServerTask
 * @Description TODO
 * @Author LiJialiang
 * @Date 2019/7/6 16:37
 * @Version 1.0
 **/
public class ServerTask {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        BufferedReader is = null;
        PrintWriter pw = null;
        /*create serverSocket*/
        try {
            server = new ServerSocket(4700);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*create socket*/
        try {
            socket = server.accept();
            /*bufferedInputStream*/
            is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            /*printWriter*/
            pw = new PrintWriter(socket.getOutputStream());
            /*keyword inputStream*/
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
            /*receive and send*/
            String readLine;
            readLine = sin.readLine();
            while (!readLine.equals("bye")) {
                pw.println(readLine);
                pw.flush();
                System.out.println("Client:"+is.readLine());
                System.out.println("Server:"+readLine);
                readLine = sin.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            /*close stream,serverSocket,socket*/
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (pw != null) {
                pw.close();
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
