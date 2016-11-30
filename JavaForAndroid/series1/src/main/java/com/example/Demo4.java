package com.example;

import java.util.Scanner;
/**
 * /*if分支语句
 * <p>
 * 格式：
 * if(条件) 单行语句; else 单行语句;
 * <p>
 * if(条件){ 多行语句; } else{ 多行语句; }
 * <p>
 * if(){} else if(){} else if(){} else{ },整体结构，只有一个分支会执行
 * <p>
 * if(){
 * <p>
 * if(){} else{}  //嵌套if-else语句
 *
 */

//要求： 输入两个数，输出最大的一个数

/**
 * Created by huangcl on 2016/11/30.
 */

public class Demo4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入两个数");
        int a = sc.nextInt();
        int b = sc.nextInt();

        int cc = 100;
        if (cc <= 100) {

            cc += 50;

            if (cc < 100) {
                System.out.println("红包还不到100");
            } else if (cc < 500) {
                System.out.println("红包快到500了，再给点。。。^_^");
            } else {
                System.out.println("哈。。红包已超过500了");
            }
        }

        //输入一个星期的数，并输出对应的星期名称，0-星期日，1-星期一，。。6-星期六

        System.out.println("输入一个星期的数,0-星期日，1-星期一,...,6-星期六: ");

        int wIndex = sc.nextInt();

        String wName = "星期";
        if (wIndex == 0) {
            wName += "日";
        } else if (wIndex == 1) {
            wName += "一";
        } else if (wIndex == 2) {
            wName += "二";
        } else if (wIndex == 3) {
            wName += "三";
        } else if (wIndex == 4) {
            wName += "四";
        } else if (wIndex == 5) {
            wName += "五";
        } else if (wIndex == 6) {
            wName += "六";
        } else {
            wName = "星期的编号出错！！！";
        }

        System.out.println(wName);
    }

}
