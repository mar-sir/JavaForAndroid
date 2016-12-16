package com.example;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;

/**
 * Created by huangcl on 2016/12/15.
 */

public class Demo3 {
    //我的盘，
    public static final String PATH = "/Volumes";
    //你的盘，
    //public static final String PATH = "D:/";
    public static DateFormat format=DateFormat.getDateTimeInstance();

    public static void main(String[] args) {
        showFiles(new File(PATH));//显示C盘目录下的所有文件及子目录信息
    }

    private static void showFiles(File file) {
        for (File file1 : file.listFiles()) {
          System.out.println(file1.getName()+"---->"+file1.length()+"B"+
                  "["+format.format(new Date(file1.lastModified()))+"]");
        }
    }
}
