package com.example;

/**
 * Created by huangcl on 2016/12/14.
 */

import java.io.FileOutputStream;

/**
 * FileOutputStream
 */
public class Demo2 {

    private static final String fileName = "testOutput.java";

    public static void main(String[] args) {
        //普通的写
        write();
    }

    /**
     *
     */
    private static void write() {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(Config.PATH + fileName);
            outputStream.write("你好啊，美女".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
