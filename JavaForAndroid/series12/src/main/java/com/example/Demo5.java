package com.example;

import java.io.File;

/**
 * Created by huangcl on 2016/12/16.
 */

public class Demo5 {
    //我新建的测试文件
    public static final String PATH = "/Volumes/huang/Test";

    public static void main(String[] args) {
        printFiles(new File(PATH));

        deleteFile(new File(PATH));
    }

    /**
     * 递归打印
     *
     * @param file
     */
    private static void printFiles(File file) {
        if (file.isDirectory()) {
            for (File file1 : file.listFiles()) {
                printFiles(file1);
            }
        }
        //也是退出条件
        System.out.println(file);
    }

    // 实现递归方式删除文件目录及子目录中的文件
    private static void deleteFile(File file) {
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                deleteFile(f);
            }
        }
        file.delete();// 删除文件或空目录
        System.out.println(file + "已删除");
    }
}
