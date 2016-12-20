package com.example.tcp_item5;

/**
 * Created by huangcl on 2016/12/20.
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现上传图片功能
 */
public class Server {
    public static final int PORT = 4321;

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(PORT);

        Socket client = server.accept(); //接收客户端的连接

        System.out.println(client.getInetAddress().getHostAddress() + "已连接");

        //创建Socket的两个流对象
        DataInputStream dis = new DataInputStream(client.getInputStream());
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());

        //获取上传文件的信息（文件名和大小)
        String fileName = dis.readUTF();
        int fileLength = dis.readInt();

        //创建写文件流对象
        FileOutputStream fis = new FileOutputStream("src\\imgs\\" + fileName);


        //准备接收上传的数据，并写入到文件流中
        byte[] bytes = new byte[1024]; //1k
        int len = -1;
        int curLen = 0;
        while ((len = dis.read(bytes)) != -1) { //-1是不起作用的，因为是网络流

            fis.write(bytes, 0, len);
            curLen += len;

            if (curLen == fileLength) { //如果当前读取的长度与上件文件的长度相同，表示上传完成
                System.out.println("文件上传完成");
                dos.writeUTF(fileName + " 上传成功");
                break;
            }
        }


        fis.close();//关闭文件流

        client.shutdownInput();
        client.shutdownOutput();

        client.close();
    }
}
