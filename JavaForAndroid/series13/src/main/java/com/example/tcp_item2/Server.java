package com.example.tcp_item2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by huangcl on 2016/12/16.
 */

public class Server {
    public static final int PORT = 8964;

    public static void main(String[] args) throws Exception {

        //1.创建ServerSocket对象，并声明监听Socket的端口号
        ServerSocket server = new ServerSocket(PORT);

        //2. 接收客户端的连接
        Socket client = server.accept();
        System.out.println(client.getInetAddress().getHostAddress() + " 已连接");

        //3. 读取客户端发送的数据，转换大写并再次发送给客户端
        //3.1创建读取流对象,并且包装成字符缓冲流
        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));

        //3.2创建写出流对象，包装成打印字符流
        PrintWriter writer = new PrintWriter(client.getOutputStream(), true);//true表示输出数据时自动向客户端发送

        String line = null;
        while (true) {
            line = reader.readLine(); //会阻塞，等待客户端发来数据

            if (line.equals("exit")) break;

            writer.println(line.toUpperCase()); //将接收的数据转换成大写，再次发送给客户端
        }

        reader.close();
        writer.close();

        server.close(); //关闭Socket

    }
}
