package com.example;

import java.io.File;
import java.io.IOException;

/**
 *
 */
public class Demo1 {

    //绝对路径
    public static final String PATH1 = "/Volumes/huang/1/1.txt";
    //绝对路径
    public static final String PATH2 = "/Volumes/huang/1";

    public static void main(String[] args) {
        //createFileway1(PATH1);
        //createFileWay2(PATH2, "2.txt");
        createWay3(PATH2, "3.txt");
    }

    /**
     * @param filePath 系统磁盘的根节点到当前文件所在的目录和文件名
     */
    static void createFileway1(String filePath) {
        File file = new File(filePath);
        // 如：c:/user/src/Demo1.java
        // 如：/Volumes/huang/hello.txt
        //file.getAbsolutePath() 文件的绝对路径
        System.out.println(file.getAbsolutePath() + "," + file.length());
        //但是上面语句并不会在磁盘上创建文件，还需一句话
        try {
            file.createNewFile();//创建文件
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param filePath 已存在的文件路径
     * @param fileName 文件名
     */
    private static void createFileWay2(String filePath, String fileName) {
        File file = new File(filePath, fileName);
        if (!file.exists()) {
            //判断文件是否存在
            System.out.println("指定文件不存在");
            //创建
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        System.out.println(file.getAbsolutePath() + "," + file.length());
    }

    /**
     * @param filePath 文件路径
     * @param fileName 文件名
     */
    static void createWay3(String filePath, String fileName) {
        //构造文件目录对象
        File dir = new File(filePath);
        //判断是否为文件目录
        if (!dir.isDirectory()) {
            throw new RuntimeException("指定的目录不存在");
        }
        //构造最终的文件对象
        File file = new File(dir, fileName);
        if (!file.exists()) {
            try {
                //创建
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(file.getAbsolutePath() + "," + file.length());
        }
    }
}












