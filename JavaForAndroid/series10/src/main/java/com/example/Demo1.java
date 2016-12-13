package com.example;

import java.io.FileWriter;
import java.io.IOException;

/**
 * IO流代码很难看，主要是因为异常处理过多
 */
public class Demo1 {
    public static void main(String[] args) {
        FileWriter writer = null;
        FileWriter writer1 = null;

        FileWriter writer2 = null;
        FileWriter writer3 = null;
        try {
            //1. 创建FileWriter对象，并在构造方法中指定文件路径
            writer = new FileWriter(Config.PATH + "testFileWriter1.txt");//此文件是在当前工程目录下
            //2.向文件字符中写入一串文本数据
            writer.write("hello");
            writer.flush();//3、在关闭流之前，先执行刷新//刷一次代表写入一次

            //构造方法的第二个参数，表示是否追加内容
            writer1 = new FileWriter(Config.PATH + "testFileWriter1.txt");//写入的新的内容会在原内容的后面增加
            writer1.write("你好-->1");
            writer1.flush();

            //构造方法的第二个参数，表示是否追加内容
            writer2 = new FileWriter(Config.PATH + "testFileWriter2.txt");
            writer2.write("你好-->2");
            writer2.flush();

            //构造方法的第二个参数，表示是否追加内容 true 追加 false 覆盖
            writer3 = new FileWriter(Config.PATH + "testFileWriter2.txt", false);//写入的新的内容会覆盖原内容
            writer3.write("你好-->");
            writer3.flush();
            writer3.write("猪");
            writer3.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close(); //关闭流
                writer1.close();
                writer2.close();
                writer3.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
