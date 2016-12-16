package com.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by huangcl on 2016/12/16.
 */

public class Demo8 {
    //文件路径
    public static final String PATH = "/Volumes/huang/studyfromGitHub/JavaForAndroid/JavaForAndroid/series11/src/main/java/files/testOutput.txt";

    public static void main(String[] args) {

//        write();
        read();
    }

    /**
     *
     */
    private static void read() {
        DataInputStream inputStream=null;
        try {
            inputStream=new DataInputStream(new FileInputStream(PATH));
            //2. 读取数据
            String txt=inputStream.readUTF();//读取utf-8编码的字符串
            int a=inputStream.readInt();
            int b=inputStream.readInt();
            int num=inputStream.readChar();
            boolean flag=inputStream.readBoolean();

            System.out.println(txt+"\r\n"+a+" "+b+","+num+","+flag);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //关闭流
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * DataOutputStream 写
     */
    private static void write() {
        DataOutputStream outputStream = null;
        try {
            //传入字节流实例获取对象实例
            outputStream = new DataOutputStream(new FileOutputStream(PATH));
            //写入基本数据
            outputStream.writeUTF("你好，Java"); //写入utf-8编码字符串
            outputStream.writeInt(10);
            outputStream.writeInt(34);
            outputStream.writeChar('a');
            outputStream.writeBoolean(true);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
