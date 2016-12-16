package com.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by huangcl on 2016/12/16.
 */

public class Demo7 {
    //文件路径
    public static final String PATH = "/Volumes/huang/studyfromGitHub/JavaForAndroid/JavaForAndroid/series11/src/main/java/files/testRAF.txt";

    public static void main(String[] args) {
        //写
        //testWrite();

        testRead();

    }

    /**
     * 读
     */
    private static void testRead() {
        RandomAccessFile accessFile = null;
        //读写模式创建实例
        try {
            accessFile = new RandomAccessFile(PATH, "r");//只读模式创建实例
            String name = null;
            int age = 0;
            float money = 0.0f;
            byte[] bytes = new byte[5];
            //假如要先读第二个人的信息
            accessFile.skipBytes(13);//则跳过前13字节
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = accessFile.readByte();//读取一个字节
            }
            name = new String(bytes);
            age = accessFile.readInt();
            money = accessFile.readFloat();
            System.out.println("name2:-->" + name + "\t" + age + "\t" + money);
            //读第一个
            accessFile.seek(0);//指针回到0
            //假如要先读第二个人的信息
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = accessFile.readByte();//读取一个字节
            }
            name = new String(bytes);
            age = accessFile.readInt();
            money = accessFile.readFloat();
            System.out.println("name1:-->" + name + "\t" + age + "\t" + money);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                accessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     */
    private static void testWrite() {
        RandomAccessFile accessFile = null;
        try {
            //读写模式创建实例
            accessFile = new RandomAccessFile(PATH, "rw");
            //读取文件长度
            System.out.println(accessFile.length() + " B");//0B

            //将文件指针移动中间位置
            accessFile.seek(accessFile.length() / 2);
            String name = null;
            int age = 0;// int 的长度为4
            float money = 1.2f;// float 的长度为4
            //double长度为8

            name = "name1";// 长度为5de字符串
            age = 20;
            money = 23.5f;
            accessFile.writeBytes(name);
            //读取文件长度
            System.out.println(accessFile.length() + "B");//5B
            accessFile.writeInt(age);
            System.out.println(accessFile.length() + "B");//9B
            accessFile.writeFloat(money);
            System.out.println(accessFile.length() + "B");//13B
            System.out.println("================================");

            name = "name2";// 长度为5de字符串
            age = 21;
            money = 24.5f;
            accessFile.writeBytes(name);
            System.out.println(accessFile.length() + "B");//18B
            accessFile.writeInt(age);
            System.out.println(accessFile.length() + "B");//22B
            accessFile.writeFloat(money);
            System.out.println(accessFile.length() + "B");//26B

            //accessFile.writeUTF("hello，你好！");
            //注：从中间写入的数据是覆盖后面的内容，因此在写数据时，尽量追加在内容之后
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                accessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
