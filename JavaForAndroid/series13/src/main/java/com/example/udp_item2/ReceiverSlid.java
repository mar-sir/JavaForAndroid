package com.example.udp_item2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by huangcl on 2016/12/20.
 */

/**
 * 实时接收数据包-- 接收端
 */
public class ReceiverSlid {


    public static void main(String[] args) throws IOException, InterruptedException {
        DatagramSocket dSocket = new DatagramSocket(3000);
        byte[] bytes = new byte[1024];

        //每一次接收数据包的对象
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
        String ip = null;
        int port = 0;

        while (true) {
            dSocket.receive(dp);
            ip = dp.getAddress().getHostAddress();
            port = dp.getPort();

            byte[] data = dp.getData();

            System.out.println(ip + ":" + port + "--接收到数据--");
            System.out.println(new String(data, 0, data.length));

            Thread.sleep(1000);
        }

    }


}
