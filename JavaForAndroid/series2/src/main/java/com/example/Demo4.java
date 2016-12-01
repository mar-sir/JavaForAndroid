package com.example;

/**
 * 局部变量的作用域，只限于方法内部
 * <p>
 * 方法的调用:  入栈，分配内存空间，初始化局部变量
 * 方法的返回： 出栈，释放内存空间，在方法中定义的局部变量也就消失
 */


/**
 * Created by huangcl on 2016/12/1.
 */

public class Demo4 {


    public static void main(String[] args) {
        int a = 100;
        int b = 300;

        int sum = add(a, b); //调用方法，并获取其计算的结果

        sop("" + sum);
    }


    static int add(int a, int b) {

        //默认对每一个数增加相应的值
        a += 10;
        b += 20;
        int sum = a + b;

        return sum;
    }

    static void sop(String msg) {
        System.out.println(msg);

    }
}
