package com.example;

/**
 * Created by huangcl on 2016/12/13.
 */

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 需求：copy拷贝 Demo1文件
 * 思路：肯定是边读边写
 */
public class Demo4 {
    //源文件路径
    public static final String PATH = "/Volumes/huang/studyfromGitHub/JavaForAndroid/JavaForAndroid/series10/src/main/java/com/example/Demo1.java";
    public static final String FILENAME = "copyDemo1.java";

    public static void main(String[] args) {
        // 1. 声明文件字符的输入、输出流对象
        FileReader fileReader = null;
        FileWriter fileWriter = null;

        try {
            // 2. 实例化流操作对象
            fileReader = new FileReader(PATH);
            fileWriter = new FileWriter(Config.PATH + FILENAME);//如果文件不存在，则会自动创建
            char[] buffer = new char[6];
            int len = 0;
            while ((len = fileReader.read(buffer)) != -1) {//边读
                fileWriter.write(buffer, 0, len);//边写,将本次读取的字符写入到复制的文件中
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                //最后别忘了关闭流
                fileReader.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
