package com.example;

/**
 * for循环：
 * <p>
 * 定义格式：
 * <p>
 * for(初始化表达式1;循环表达式2;循环条件变量变化表达式3){
 * <p>
 * //循环体
 * <p>
 * }
 * <p>
 * 表达式1： 定义循环中使用的变量和循环条件中的变量，其作用域仅限当前for循环中
 * 表达式2： 每次循环的条件表达式，只有条件为true时，才会执行循环体
 * <p>
 * 表达式3： 执行完循环体之后，执行的表达式，一般用于改变循环条件变量的值
 * <p>
 * <p>
 * //嵌套for：
 * <p>
 * for(;;){
 * for(;;){
 * <p>
 * }
 */

/**
 * Created by huangcl on 2016/11/30.
 */

public class Demo7 {

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            //循环100次
        }

        int i = 0;
        for (; i < 100; i++) {
            //循环100次
        }

        System.out.println(i); //i的作用域只限于for循环体中，可以将初始化表达式的变量放在for循环外定义

       /* for (; ; ) { //死循环

        }*/
        //如果上面的死循环执行，就不会执行下面的调用方法
        toHex(1000);
    }

    private static void toHex(int num) {
        String result = "";

        while (num > 0) {
            int ln = num & 15; //取低四位
            if (ln >= 10) {
                result = (char) (ln - 10 + 'a') + result;
            } else {
                result = ln + result;
            }

            num = num >> 4; //向右移动四位，即取高四位

        }

        System.out.println("0x" + result);
    }
}
