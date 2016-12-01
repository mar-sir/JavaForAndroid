package com.example;
/***
 * 基本数据类型与引用数据类型的区别
 */

/**
 * Created by huangcl on 2016/12/1.
 */

public class Demo6 {

    //显示一个数
    static void show(int a) {
        a += 5;//聪明的AndroidStudio 已经发现这里的a没用到
    }

    static void show(int[] nums) {
        nums[0] += 5;
    }


    static void show(String str) {
        str = "haha";
    }

    public static void main(String[] args) {
        int a = 10;
        show(a);
        System.out.println(a);//10  并不是15
        int[] nums = {9, 5, 2};
        show(nums); //将数组的首地址传给了方法中的数组引用
        System.out.println(nums[0]);//14 并不是9
        //////////////////////////////////
        //字符串的常量对象：  保存在常量池中
        String str = "hihi";
        String str2 = "hihi";
        System.out.println(str == str2);//结果：true
        show(str);//将str变量的内容“hihi”传给方法
        System.out.println(str);//输出：hihi
        String str3 = new String("hihi");
        String str4 = str3;
        str3 = "hehe"; //hehe在常量池不存在，则会在常量池中创建对象，str3就指向这个对象
        System.out.println(str4);//输出： hihi
    }
}
