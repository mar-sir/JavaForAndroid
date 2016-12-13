package com.example;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by huangcl on 2016/12/13.
 */

public class Demo2 {
    public static void main(String[] args) {

        FileWriter writer = null;
        try {

            //构造方法的第二个参数，表示是否追加内容
            writer = new FileWriter(Config.PATH + "testFileWriter3.txt", false);//写入的新的内容会覆盖原内容
            writer.write("你好");
            writer.flush();
            writer.write("猪啊");
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
