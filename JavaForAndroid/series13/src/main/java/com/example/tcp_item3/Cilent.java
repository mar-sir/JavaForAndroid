package com.example.tcp_item3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
/**
 * Created by huangcl on 2016/12/20.
 */

public class Cilent {

    public static void main(String[] args) throws Exception {

        //1. 创建Socket，连接指定位置（IP和Port）的计算机
        Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(), Server.PORT);

        System.out.println("连接成功");

        //2. 为了接收键盘的数据，将键盘的字节流转成缓冲字符流
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //3. 为了向服务端发送数据，将socket的输出字节流转成缓冲字符流
        PrintWriter sWriter = new PrintWriter(socket.getOutputStream(), true);

        //4. 读取服务端发来的数据，将socket的输入字节流转成缓冲字符流
        BufferedReader sReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));


        String line = null;
        while (true) {
            line = reader.readLine();//会阻塞，读键盘的数据

            //向服务端发送数据
            sWriter.println(line);

            if (line.equals("exit")) { //不接收服务端发送过来的数据
                break;
            }

            line = sReader.readLine();
            System.out.println(line);
        }
        reader.close();
        sReader.close();
        sWriter.close();
        socket.close();
    }
}
