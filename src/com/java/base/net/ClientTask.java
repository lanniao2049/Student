package com.java.base.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @ClassName ClientTask
 * @Description TODO
 * @Author LiJialiang
 * @Date 2019/7/6 16:37
 * @Version 1.0
 **/
public class ClientTask {

    public static void main(String[] args) {
        BufferedReader is = null;
        PrintWriter pw = null;
        Socket socket = null;
        try {
            /*create socket*/
            socket = new Socket("127.0.0.1",4700);
            /*keyword inputStream*/
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
            /*print*/
            pw = new PrintWriter(socket.getOutputStream());
            /*bufferedReader*/
            is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            /*send and receive*/
            String readLine;
            readLine = sin.readLine();
            while (!readLine.equals("bye")) {
                pw.println(readLine);
                pw.flush();
                System.out.println("Client:"+readLine);
                System.out.println("Server:"+is.readLine());
                readLine = sin.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            /*close stream,socket*/
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
        }
    }

}
