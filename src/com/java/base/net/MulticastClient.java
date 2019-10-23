package com.java.base.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * @ClassName MulticastClient
 * @Description TODO
 * @Author LiJialiang
 * @Date 2019/7/8 20:29
 * @Version 1.0
 **/
public class MulticastClient {
    public static void main(String[] args) throws IOException {
        MulticastSocket socket = new MulticastSocket(4447);
        InetAddress address = InetAddress.getByName("230.0.0.1");
        /*add group*/
        socket.joinGroup(address);
        DatagramPacket packet;
        /*for*/
        for (int i = 0; i < 5; i++) {
            byte[] buf = new byte[256];
            /*receive message*/
            packet = new DatagramPacket(buf,buf.length);
            socket.receive(packet);
            String receive = new String(packet.getData());
            System.out.println("More quote message:"+receive);
        }
        /*leave group*/
        socket.leaveGroup(address);
        socket.close();
    }
}
