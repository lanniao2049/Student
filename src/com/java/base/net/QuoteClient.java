package com.java.base.net;

import java.io.IOException;
import java.net.*;

/**
 * @ClassName QuoteClient
 * @Description TODO
 * @Author LiJialiang
 * @Date 2019/7/8 5:15
 * @Version 1.0
 **/
public class QuoteClient {
    public static void main(String[] args) {
        // if (args.length != 1) {
        //     System.out.println("Must user hostname");
        //     return;
        // }
        try {
            DatagramSocket socket = new DatagramSocket();
            /*send udp message*/
            byte[] buf = new byte[256];
            InetAddress address = InetAddress.getByName("127.0.0.1");
            DatagramPacket packet = new DatagramPacket(buf,buf.length,address,4445);
            socket.send(packet);
            /*receive udp message*/
            packet = new DatagramPacket(buf,buf.length);
            socket.receive(packet);
            /*display message*/
            String receive = new String(packet.getData());
            System.out.println("Message: "+receive);
            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
