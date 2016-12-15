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
        //拷贝纯文本
        //copyFile();
        //拷贝图片
        copyPicture();
    }

    /**
     * 拷贝图片step1.png
     */
    private static void copyPicture() {
        String picSource = "/Volumes/huang/studyfromGitHub/JavaForAndroid/JavaForAndroid/series11/src/main/java/images/step1.png";
        String copyName = "copyPic.png";

        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            inputStream = new FileInputStream(picSource);
            outputStream = new FileOutputStream(Config.PATH + copyName);

            //定义缓冲区--字节数组
            byte[] bytes=new byte[1024]; //每次最多读取1K节字
            int len=-1;  //每次读取的字节长度

            while((len=inputStream.read(bytes))!=-1){ //-1代表的是文件结尾标识
                outputStream.write(bytes, 0, len);
            }

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
