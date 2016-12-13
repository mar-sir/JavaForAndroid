package com.example;


import java.io.FileReader;
import java.io.IOException;

/**
 * Created by huangcl on 2016/12/13.
 */

public class Demo2 {
    public static void main(String[] args) {
        //1.声明FileReader对象
        FileReader fileReader = null;
        try {
            //2. 实例化FileReader对象
            fileReader = new FileReader(Config.PATH + "testFileWriter2.txt");//可能会抛出FileNotFoundException异常
            //3.文本读取
            int num = 0;
            while ((num = fileReader.read()) != -1) {//每次读一个字符，如果为-1表示已到文件结束位置
                System.out.print((char) num);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();//关闭流
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
