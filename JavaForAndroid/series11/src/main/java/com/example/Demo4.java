package com.example;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by huangcl on 2016/12/15.
 */

public class Demo4 {


    /**
     * 打印从键盘输入的字母，直到输入exit结束程序
     *
     * @param args
     */
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        int num = -1;
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                num = inputStream.read();
                //判断字符是否换行
                if (num == '\n') {
                    String line = sb.toString().trim();//去除两边的空格

                    if (line.equalsIgnoreCase("exit")) {
                        break;
                    }
                    System.out.println(line); //打印输入的一行数据(字母是大写)
                    //重置字符串变量的内容
                    sb.delete(0, sb.length());
                }
                sb.append((char) num);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
