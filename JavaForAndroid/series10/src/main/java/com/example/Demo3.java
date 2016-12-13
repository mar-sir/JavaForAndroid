package com.example;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by huangcl on 2016/12/13.
 */

public class Demo3 {
    public static void main(String[] args) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(Config.PATH + "testFileWriter2.txt");
            char[] buffer = new char[4];//每次最多读4个字符
            int n = 0;
            while ((n = fileReader.read(buffer)) != -1) {//每次最多读4个字符，如果为-1表示已到文件结束位置
                //打印本次读取的内容，从0位置开始，到本次读取的字符个数
                System.out.println("读取 "+n+"个字符： "+new String(buffer,0,n));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
