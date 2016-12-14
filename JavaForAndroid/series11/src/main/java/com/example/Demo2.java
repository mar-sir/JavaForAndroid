package com.example;

/**
 * Created by huangcl on 2016/12/14.
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileOutputStream
 */
public class Demo2 {

    private static final String fileName = "testOutput.java";

    public static void main(String[] args) {
        //普通的写
        //write();

        copyFile();
    }

    /**
     * 拷贝本类文件
     */
    private static void copyFile() {
        String copyName = "copy.java";
        String sourcePath = "/Volumes/huang/studyfromGitHub/JavaForAndroid/JavaForAndroid/series11/src/main/java/com/example/Demo2.java";

        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            inputStream = new FileInputStream(sourcePath);
            outputStream = new FileOutputStream(Config.PATH + copyName);
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            outputStream.write(bytes);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
