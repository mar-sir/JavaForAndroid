package com.example.udp_item1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by huangcl on 2016/12/20.
 */

public class ReceiverData {
    public static void main(String[] args) throws IOException {
        System.out.println("准备接收广播数据...");


        //创建数据包的Socket
        DatagramSocket dSocket = new DatagramSocket(SendData.PORT);//确定接收哪一个端口的数据包--广播频道

        byte[] bytes = new byte[1024];

        //创建一个待接收数据的数据包
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);

        //接收站点Socket发送过来的数据
        dSocket.receive(dp); //会阻塞

        //获取数据包中的数据
        byte[] data = dp.getData();

        InetAddress address = dp.getAddress();
        System.out.println(address.getHostAddress() + ":" + dp.getPort() + "--发来的数据---");
        System.out.println(new String(data, 0, dp.getLength()));


    }
}
