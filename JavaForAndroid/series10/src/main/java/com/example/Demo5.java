package com.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by huangcl on 2016/12/13.
 */

public class Demo5 {
    public static final String NAME = "testDemo5.txt";

    public static void main(String[] args) {
        //1.变量声明
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try {
            //2.实例化变量
            fileWriter = new FileWriter(Config.PATH + NAME);
            bufferedWriter = new BufferedWriter(fileWriter);//装饰者模式，扩展现有功能（包装）,将节点流（文件字符流）对象作为构造参数使用
            //通过缓冲流对象向文本文件中写入数据
            bufferedWriter.write("哈哈，");
            bufferedWriter.newLine();//换行
            bufferedWriter.write("此处发现一个大傻逼。");
            //此处追加文本数据是向缓冲追加，而非是将内容追加到文件内
            bufferedWriter.append("追加内容")
                    .append("\r\n").append("这里也有一个傻逼。");
            //注：缓冲数据是将数据存入内存中，并没有写入到文件中，在关闭流之前必须要执行flush()方法
            bufferedWriter.flush();//将内存的数据写入到文件中
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedWriter.close();//处理流关闭之后，节点流会自动关闭
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
