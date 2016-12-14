package com.example;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 需求：控制台输出本文件内容
 */
public class Demo1 {
    //文件地址
    public static final String PATH = "/Volumes/huang/studyfromGitHub/JavaForAndroid/JavaForAndroid/series11/src/main/java/com/example/Demo1.java";

    public static void main(String[] args) {
        //read();//测试InputStream 的read()方法
        reads();//测试InputStream 的read(byte []bytes)方法
    }

    /**
     * 测试read(byte[] bytes)
     * 可以控制字符集
     */
    private static void reads() {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(PATH);
            byte[] bytes = new byte[inputStream.available()];//inputStream.available()获取文件长度
            //读取的字节长度
            int len = inputStream.read(bytes);//将数据一次性读取到字节数组中
            System.out.println("读取长度" + len + "\n" + new String(bytes, "utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 测试read()
     * 每次读一个字节，并打印,如果存在中文，可能会乱码
     */
    private static void read() {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(PATH);
            int len = 0;
            while ((len = inputStream.read()) != -1) {
                System.out.print((char) len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
