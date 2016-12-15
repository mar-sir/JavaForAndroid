package com.example;

/**
 * Created by huangcl on 2016/12/15.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

/**
 * 需求:接收键盘输入的内容，并打印到文件里去
 */
public class Demo6 {

    public static void main(String[] args) {
//1. 通过转换流，获取到读取键盘的字符输入流
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "copy.txt";//文件名
        //涉及到了System.in,System.out,System.setOut(...),PrintWriter

        //设置控制输出的数据位置--保存到文件中
        try {
            //File.separator分隔符
            System.setOut(new PrintStream(Config.PATH + File.separator + fileName));//当向控制台输出内容时，直接将内容存入此文件中，并不会显示在控制台中
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //2. 通过转换流，将控制台的字节流转换成缓冲的字符流
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        //3. 开始读取数据
        String line = null;
        while (true) {
            try {
                line = reader.readLine().trim();
                if (line.equalsIgnoreCase("exit")) {
                    break;
                }
                writer.write(line);
                writer.newLine();
                writer.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

}
