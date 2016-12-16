package com.example.tcp_item1;

/**
 * Created by huangcl on 2016/12/16.
 */

import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 客户端
 */
public class Cilent {
    public static void main(String[] args) {
        Socket socket = null;
        StringBuilder sb = null;
        try {
            //创建客户端的Socket对象，并指定连接ServerSocket的IP和端口
            //此处用的是本机地址
            socket = new Socket(InetAddress.getLocalHost().getHostAddress(), Server.PORT);
            //接收服务器端的消息
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[100];
            int len = 0;
            sb = new StringBuilder();
            while ((len = inputStream.read(bytes)) != -1) {
                sb.append(new String(bytes, 0, len));
            }
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
