package com.example.tcp_item6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by huangcl on 2016/12/20.
 */

public class Cilent {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(), Server.PORT);

        System.out.println("连接服务器成功...");

        //创建Socket的两个流对象
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        //创建读取文件的输入流
        FileInputStream fis = new FileInputStream("src\\res\\圆珠画.jpg");

        //在上传文件之前，将文件的基本信息发送给服务端
        dos.writeUTF("圆珠画.jpg");
        dos.writeInt(fis.available());
        dos.flush();

        byte[] bytes = new byte[1024];
        int len = -1;
        while ((len = fis.read(bytes)) != -1) {
            dos.write(bytes, 0, len); //向服务端写数据
            dos.flush(); //将数据刷新到流中
        }

        //关闭文件流
        fis.close();

        //向服务端发送上传完成的标识-over
        //dos.write("over".getBytes());
        //dos.flush();

        //接收服务端回复的数据
        System.out.println(dis.readUTF());

        socket.shutdownInput();
        socket.shutdownOutput();
        socket.close();
    }
}
