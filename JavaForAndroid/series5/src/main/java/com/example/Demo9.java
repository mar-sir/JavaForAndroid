package com.example;

import java.io.UnsupportedEncodingException;

/**
 * Created by huangcl on 2016/12/6.
 */

/**
 * String 简介 final修饰的类
 */
public class Demo9 {
    public static void main(String[] args) {

        String s1 = "abc";
        String s2 = "abc";

        System.out.println(s1 == s2);//内存地址的比较//true

        int len = s1.length();
        for (int i = 0; i < len; i++) {

            //charAt(int index)获取指定位置的字符
            System.out.println(s1.charAt(i));//a//b//c
        }

        String s3 = "http://www.baidu.com/images/logdgre/dgo.gif";
        if (s3 != null && s3.length() > 0) {

            //从字符串中截取文件名（后部分数据）
            String fileName = s3.substring(s3.lastIndexOf("/") + 1);

            //提示快捷键：alt+/
            System.out.println(fileName);//dgo.gif

            //截取前部分数据
            String prefix = s3.substring(0, s3.indexOf(":"));
            System.out.println(prefix);//http
        }

        //比较
        String s4 = "acdaaa";
        String s5 = "cd";

        //进行内容比较
        System.out.println(s4.equalsIgnoreCase(s5));//false

        //判断 是否包含子字符串
        System.out.println(s4.contains(s5));//true

        //将字符串转为字节数组
        String name = "张三";
        //默认编码为unicode, 可选的有utf-8,gbk,gb2312,iso8859-1

        byte[] bytes;
        try {
            bytes = name.getBytes("gb2312");//gbk和gb2312编码中，每一个汉字点2个字节
            System.out.println(bytes.length);//4

            //注意： 编码和解码必须保持一致
            System.out.println(new String(bytes, "gb2312"));//张三

            //基本数据类型转成字符串
            String s6 = String.valueOf(100);
            s6 = String.valueOf(78.85);

            //查看字符串的hashCode()
            System.out.println("张三".hashCode() + "," + name.hashCode());

            //比较字符中，如果两个字符串完全相等，则返回0
            System.out.println("abd".compareTo("abddddddd"));//-6

        } catch (UnsupportedEncodingException e) {
            //ctrl+d 快速删除整行
            e.printStackTrace();
        }


    }
}
