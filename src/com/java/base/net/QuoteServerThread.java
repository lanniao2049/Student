package com.java.base.net;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

/**
 * @ClassName QuoteServerThread
 * @Description TODO
 * @Author LiJialiang
 * @Date 2019/7/8 5:16
 * @Version 1.0
 **/
public class QuoteServerThread extends Thread {
    DatagramSocket socket = null;
    BufferedReader in = null;
    boolean moreQuote = true;

    public QuoteServerThread() {
        this("QuoteServerThread");
    }

    public QuoteServerThread(String name) {
        super(name);
        try {
            socket = new DatagramSocket(4445);
            in = new BufferedReader(new FileReader("D:\\ideaCode\\Student\\src\\com\\java\\base\\net\\on.txt"));
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (moreQuote) {
            try {
                byte[] buf = new byte[256];
                /*receive udp message*/
                DatagramPacket packet = new DatagramPacket(buf,buf.length);
                socket.receive(packet);
                /*read inputStream*/
                String dStr = null;
                if (in == null) {
                    dStr = new Date().toString();
                } else {
                    dStr = getNexQuote();
                }
                /*send ude message*/
                buf = dStr.getBytes();
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                packet = new DatagramPacket(buf,buf.length,address,port);
                socket.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
                moreQuote = false;
            }
        }
        socket.close();
    }
    public String getNexQuote() {
        String rest = null;
        try {
            rest = in.readLine();
            if (rest == null) {
                in.close();
                moreQuote = false;
                rest = "No more Quote.Goodbye";
            }
        } catch (IOException e) {
            rest = "Quote exception";
        }
        return rest;
    }
    ArrayList<String> strings = new ArrayList<>();
    LinkedList<Integer> integers = new LinkedList<>();
}
