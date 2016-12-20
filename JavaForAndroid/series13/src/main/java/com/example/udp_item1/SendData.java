package com.example.udp_item1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by huangcl on 2016/12/20.
 */

public class SendData {
    public static final int PORT = 4341;

    public static void main(String[] args) throws Exception {
        //创建广播数据的Socket对象--广播站点
        DatagramSocket dSocket = new DatagramSocket();

        byte[] bytes = "您好".getBytes();

        //准备发送数据包
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length,
                InetAddress.getLocalHost(), PORT); //指定接收数据包的socket端口

        //开始发送数据
        dSocket.send(dp);

        //关闭资源
        dSocket.close();
    }
}
