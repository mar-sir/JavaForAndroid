package com.example.tcp_item4;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by huangcl on 2016/12/20.
 */

public class Cilent {

    public static void main(String[] args) throws Exception {

        //1. 创建Socket，连接指定位置的计算机
        Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(), Server.PORT);

        System.out.println("连接成功...准备上传文件");

        //2. 创建读取本地文件的输入流
        BufferedReader fReader = new BufferedReader(new FileReader("src\\day11\\Demo1.java"));

        //3. 创建向服务端发送数据的输出流
        PrintWriter sWriter = new PrintWriter(socket.getOutputStream(), true);

        //4. 接收服务端发送过来的数据，创建数据输入流
        DataInputStream dis = new DataInputStream(socket.getInputStream());

        //5. 开始通信
        String line = null;
        while ((line = fReader.readLine()) != null) { //开始读文件
            //向服务端发送已读取的数据
            sWriter.println(line);
        }

        //文件上传完成
        sWriter.println("over");

        //读取服务端的回复数据
        String reply = dis.readUTF();
        System.out.println(reply);

        fReader.close();
        sWriter.close();
        dis.close();

        socket.close();
    }
}
