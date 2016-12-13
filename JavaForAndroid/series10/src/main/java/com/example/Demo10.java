package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by huangcl on 2016/12/13.
 */

public class Demo10 {
    //拷贝源文件
    public static final String PATH = "/Volumes/huang/studyfromGitHub/JavaForAndroid/JavaForAndroid/series10/src/main/java/com/example/Demo6.java";
    public static final String NAME = "testDemo9.java";

    public static void main(String[] args) {
        FileReader reader = null;
        BufferedReader bufferedReader = null;

        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try {
            reader = new FileReader(PATH);
            bufferedReader = new BufferedReader(reader);

            fileWriter = new FileWriter(Config.PATH + NAME);
            bufferedWriter = new BufferedWriter(fileWriter);
            String line = null;
            boolean isFirstLine=true;//刚开始绝B第一行
            while ((line = bufferedReader.readLine()) != null) {  //读一行，写一行
                if (isFirstLine){//第一行直接写
                    bufferedWriter.write(line);
                    isFirstLine=false;//写完之后绝B不是第一行了
                }else {
                    bufferedWriter.newLine();//插入换行
                    bufferedWriter.write(line);
                }
                bufferedWriter.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
