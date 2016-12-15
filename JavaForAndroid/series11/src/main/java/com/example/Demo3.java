package com.example;

/**
 * Created by huangcl on 2016/12/14.
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 带缓冲的字节流
 * <p>
 * 需求:使用带缓冲的字节流拷贝文件
 */
public class Demo3 {

    //纯文本源文件路径
    private static final String txtPath = "/Volumes/huang/studyfromGitHub/JavaForAndroid/JavaForAndroid/series11/src/main/java/com/example/Demo2.java";
    //拷贝后的纯文本文件名
    private static final String txtName = "copy.java";

    //图片源文件路径
    private static String picPath = "/Volumes/huang/studyfromGitHub/JavaForAndroid/JavaForAndroid/series11/src/main/java/images/step1.png";
    //拷贝后的图片名
    private static String picName = "copyPic.png";

    public static void main(String[] args) {
        //copy(txtPath, txtName);
        copy(picPath, picName);
    }

    /**
     * 拷贝文件
     * Config.PATH 是上面提到的
     *
     * @param sourcePath 源路径
     * @param targetName 文件名
     */
    private static void copy(String sourcePath, String targetName) {
        //申明变量
        FileInputStream inputStream = null;
        BufferedInputStream bufferedInputStream = null;

        FileOutputStream outputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        //实例化变量
        try {
            inputStream = new FileInputStream(sourcePath);
            bufferedInputStream = new BufferedInputStream(inputStream);

            outputStream = new FileOutputStream(Config.PATH + targetName);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            byte[] bytes = new byte[2048];//大小可以自己指定，但不要非常非常大。
            int len = 0;
            while ((len = bufferedInputStream.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes, 0, len);//向缓冲区中写入指定长度的数据
                bufferedOutputStream.flush();//将数据从内存中写入到文件中
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedInputStream.close();//关闭流(处理流)，其中的包装流会自动关闭
                bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
