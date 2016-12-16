package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by huangcl on 2016/12/16.
 */

/**
 * ByteArrayOutputStream打印本文件内容
 */
public class Demo9 {
    //源文件路径
    public static final String sourcePath = "/Volumes/huang/studyfromGitHub/JavaForAndroid/JavaForAndroid/series11/src/main/java/com/example/Demo9.java";

    //文件名

    public static void main(String[] args) {
        try {
            //得到字节流
            FileInputStream inputStream = new FileInputStream(sourcePath);

            //将字节流转成字符流
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            //将字节流包装成一个缓冲字符流
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            //创建内存流对象--内存输出流
            ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream(inputStream.available());

            //将字节流转换成字符流
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(arrayOutputStream);


            //将字符流包装成缓冲字符流--BufferedWriter
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            String msg = null;
            while ((msg = bufferedReader.readLine()) != null) {
                bufferedWriter.write(msg);//向内存中写入数据
                bufferedWriter.newLine();
                bufferedWriter.flush();//将缓冲区的数据写入到内存流中使用的内存区中
            }
            byte[] bytes = arrayOutputStream.toByteArray();
            System.out.println(new String(bytes));

            //关闭流
            bufferedReader.close();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
