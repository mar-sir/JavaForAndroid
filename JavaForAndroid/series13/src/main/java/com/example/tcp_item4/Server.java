package com.example.tcp_item4;

/**
 * Created by huangcl on 2016/12/20.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现上传文本文件
 */
public class Server {
    public static final int PORT = 9032;

    public static void main(String[] args) throws Exception{
        //1. 创建ServerSocket,监听某一端口上的Socket连接
        ServerSocket server=new ServerSocket(PORT);

        //2. 开始监听Socket的连接
        Socket client=server.accept(); //会阻塞

        System.out.println(client.getInetAddress().getHostAddress()+" 已连接");

        //3.将socket的输入字节流转成缓冲字符流
        BufferedReader cReader=new BufferedReader(new InputStreamReader(client.getInputStream()));

        //4. 将socket的输出字节流转成数据流
        DataOutputStream dos=new DataOutputStream(client.getOutputStream());

        //5. 保存客户端上传的数据，需要文件字符流，并将其转成缓冲字符流
        BufferedWriter fWriter=new BufferedWriter(new FileWriter("tmp.txt"));

        String line=null; //当读取到over，表示客户端文件已上传完成
        while(true){
            line=cReader.readLine();
            if(line.equals("over")){ //表示上传完成
                dos.writeUTF("上传成功！");
                break;
            }

            fWriter.write(line);
            fWriter.newLine();
            fWriter.flush(); //将内存缓冲区的数据写入到文件中
        }

        //向客户端发送关闭流的指令
        client.shutdownInput();
        client.shutdownOutput();

        client.close();

    }
}
