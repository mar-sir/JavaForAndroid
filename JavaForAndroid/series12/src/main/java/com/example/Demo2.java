package com.example;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;

/**
 * Created by huangcl on 2016/12/15.
 */

public class Demo2 {
    //绝对路径
    public static final String PATH = "/Volumes/huang/1/1.txt";

    public static void main(String[] args) {
        File file=new File(PATH);
        //判断是否存在，并且不是目录
        if(!file.exists() || !file.isFile()){
            throw new RuntimeException("文件不存在或是目录");
        }
        //获取日期格式化对象
        DateFormat df=DateFormat.getDateTimeInstance();
        Date mDate=new Date(file.lastModified());
        System.out.println("文件名："+file.getName());
        System.out.println("文件路径："+file.getPath());
        System.out.println("绝对路径："+file.getAbsolutePath());
        System.out.println("所在目录："+file.getParent());
        System.out.println("文件大小："+file.length()+"字节");
        System.out.println("文件最后修改时间："+df.format(mDate));
    }
}
