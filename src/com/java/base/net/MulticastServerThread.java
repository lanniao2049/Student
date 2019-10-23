package com.java.base.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.Date;

/**
 * @ClassName MulticastServerThread
 * @Description TODO
 * @Author LiJialiang
 * @Date 2019/7/8 20:35
 * @Version 1.0
 **/
public class MulticastServerThread extends QuoteServerThread {
    private long sleepTime = 5000;

    public MulticastServerThread() {
        super("MulticastServerThread");
    }

    @Override
    public void run() {
        while (moreQuote) {
            byte[] buf = new byte[256];
            /*get inputStream*/
            String dsString = null;
            if (in == null) {
                dsString = new Date().toString();
            } else {
                dsString = getNexQuote();
            }
            buf = dsString.getBytes();
            try {
                /*send udp message*/
                InetAddress address = InetAddress.getByName("230.0.0.1");
                DatagramPacket packet = new DatagramPacket(buf,buf.length,address,4447);
                socket.send(packet);
                /*sleep*/
                try {
                    sleep((long) (Math.random()*sleepTime));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
                moreQuote = false;
            }
        }
        socket.close();
    }
}
