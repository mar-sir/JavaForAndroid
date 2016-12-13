package com.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by huangcl on 2016/12/13.
 */

/**
 * 读取Demo6.java的内容
 */
public class Demo7 {
    public static final String PATH = "/Volumes/huang/studyfromGitHub/JavaForAndroid/JavaForAndroid/series10/src/main/java/com/example/Demo6.java";

    public static void main(String[] args) {
        //1.申明
        FileReader reader = null;
        BufferedReader bufferedReader = null;
        try {
            //2.实例化
            reader = new FileReader(PATH);
            bufferedReader = new BufferedReader(reader);
            //3.读取
            String msg=null;
            while ((msg=bufferedReader.readLine())!=null){//如果是null，则表示文件结束
                System.out.println(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
