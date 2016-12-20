package com.example.udp_item2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/**
 * Created by huangcl on 2016/12/20.
 */

/**
 * 实现实时发送数据包
 */
public class SendSlid {
    public static final int PORT = 6785;

    public static void main(String[] args) throws IOException {
        DatagramSocket dSocket = new DatagramSocket();

        //创建键盘输入流对象，使用缓冲字符流
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //开始读取键盘输入的数据
        String line = null;
        byte[] bytes = null;
        DatagramPacket dp = null;
        SocketAddress sAddress = new InetSocketAddress("127.0.0.1", PORT); //发送的目的地

        while (true) {
            line = reader.readLine();

            bytes = line.getBytes();
            dp = new DatagramPacket(bytes, bytes.length, sAddress); //创建待发送的数据包对象

            dSocket.send(dp);

            if (line.equals("over")) {
                break;
            }
        }

        dSocket.close(); //关闭资源
    }
}
