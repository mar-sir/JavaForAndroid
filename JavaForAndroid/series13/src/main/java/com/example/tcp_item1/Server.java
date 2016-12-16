package com.example.tcp_item1;

/**
 * Created by huangcl on 2016/12/16.
 */

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 */
public class Server {
    public static final int PORT=4584;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            // 创建SocketServer对象，并声明监听Socket连接的端口号
            serverSocket = new ServerSocket(PORT);
            while (true) {//永真一直监听客户端
                //开始接收Socket连接
                Socket accept = serverSocket.accept();//会阻塞，直到有客户端链接
                //连接后打印客户端IP地址
                System.out.println(accept.getInetAddress() + "客户端已连接");
                //但至此客户端不知道是否自己已经连上服务器了，服务器端的告诉他
                //给客户端发送消息
                OutputStream outputStream = accept.getOutputStream();
                outputStream.write("你已经链接成功".getBytes());
                outputStream.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
