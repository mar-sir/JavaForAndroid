package com.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Created by huangcl on 2016/12/13.
 */

public class Demo8 {

    public static void main(String[] args) {
        try {
            //读取Demo6中的内容
            FileReader reader = new FileReader(Demo7.PATH);
            //使用自己的CoustomerBufferReader
            CoustomerBufferReader bufferReader=new CoustomerBufferReader(reader);
            String line=null;
            while ((line=bufferReader.readLine())!=null){
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class CoustomerBufferReader {
    private Reader in;
    //缓冲数组
    private char[] buffer=new char[1024];
    //每次读取的字符个数
    private int nChars;
    //缓冲数组的索引下标
    private int nextChar;


    public CoustomerBufferReader(Reader in) {
        this.in = in;
    }

    public int read() throws IOException {
        if (nChars == 0) {//表示缓冲中没有可读的字符
            //读取节点流（字符流）中数据到缓冲数组中
            nChars = in.read(buffer);
            nextChar = 0;
        }
        if (nChars < 0) {//判断是否读取末尾
            return -1;
        }
        int num = buffer[nextChar++];//从缓冲数组中获取一个字符
        nChars--;//读一轮，减一个
        return num;
    }

    public String readLine() throws IOException {
        int num = -1;
        StringBuilder builder = new StringBuilder();
        while ((num = read()) != -1) {
            if (num == '\r') {
                continue;
            } else if (num == '\n') {
                return builder.toString();
            }
            builder.append((char) num);//将读取的一个字符存放到变量中
        }
        //防止最后一行不存在换行符时，无法读取最后一行
        if (builder.length() > 0)
            return builder.toString();

        return null;
    }

}
