package com.example;

/**
 * Created by huangcl on 2016/12/15.
 */

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 字节流，字符流转换
 */
public class Demo5 {
    public static void main(String[] args) {
        //输入流绑定键盘输入
        InputStream inputStream = System.in;
        //字符输入流声明
        InputStreamReader inputStreamReader = null;
        try {
            //实例化带有编码格式的字符流
            inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            //包装
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = null;
            while (true) {
                //判断读取
                line = new String(bufferedReader.readLine());
                if (line.trim().equalsIgnoreCase("exit")) {
                    break;
                }
                //打印输出
                System.out.println(line);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
