package com.example;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

/**
 * Created by huangcl on 2016/12/15.
 */

public class Demo4 {
    public static final String PATH = "/Volumes/huang";

    public static void main(String[] args) {
        //FileFileter 显示指定目录下的.doc文件
        // testFileFileter(PATH);
        //FilenameFilter 显示指定目录下的.doc文件
        testFilenameFilter(PATH);
    }

    /**
     * FilenameFilter 显示指定目录下的.doc文件
     *
     * @param path
     */
    private static void testFilenameFilter(String path) {
        File file = new File(path);
        if (!file.isDirectory()) {
            throw new RuntimeException("不是一个有效的目录");
        }
        File[] files = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File file, String s) {
                //假如你不知道 s 是什么，那你就把它打印出来看一看
                System.out.println(s);
                if (s.endsWith(".doc")) return true;
                return false;
            }
        });
        System.out.println("================过滤后文件===========================");
        //打印所有文件
        for (File file1 : files) {
            System.out.println(file1.getName());
        }
    }

    /**
     * //FileFileter 显示指定目录下的.txt文件
     *
     * @param path 指定目录
     */
    private static void testFileFileter(String path) {
        File file = new File(path);
        if (!file.isDirectory()) {
            throw new RuntimeException("不是一个有效的目录");
        }
        File[] files = file.listFiles(new FileFilter() {// 如果是指定类型的文件，则返回true
            @Override
            public boolean accept(File file) {
                String fileName = file.getName();
                //获取文件扩展名
                String txt = fileName.substring(fileName.lastIndexOf(".") + 1);
                if ("doc".equals(txt)) {
                    return true;
                }
                return false;
            }
        });

        //打印所有文件
        for (File file1 : files) {
            System.out.println(file1.getName());
        }

    }
}
