package com.example;
//package com.example 包，包路径

/**
 * public 访问控制符（public 代表公有，谁都可以访问）
 * class 类
 * Demo1 类名
 */
public class Demo1 {
    //相当于C的main函数

    /**
     * public 访问控制符（public 代表公有，谁都可以访问）
     * static 静态的
     * void   标志没有返回值
     * main   方法名
     * String[] 参数类型
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        //在控制台输出Hello Java!
        System.out.println("Hello Java!");

        //说明参数用途
        for (String s : args) {
            System.out.println(s);
        }
    }
}
