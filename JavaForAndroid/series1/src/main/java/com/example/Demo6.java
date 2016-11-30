package com.example;
/**
 * 循环语句：
 * <p>
 * while循环： 先判断条件，如果条件为true则执行循环体，当循环体执行完后，再接着判断条件。。。
 * <p>
 * while(条件表达式){
 * <p>
 * 循环体; //执行某一重复使用的功能代码
 * <p>
 * 改变循环条件的值;
 * }
 * <p>
 * do-while循环： 先执行循环体，再判断条件
 * <p>
 * do{
 * <p>
 * }while(条件表达式)
 * <p>
 * while与do-while的区别：
 * <p>
 * while是先判断后执行（可能一次都不执行循环体），
 * do-while先执行，再判断（至少执行一次循环体）
 */

/**
 * Created by huangcl on 2016/11/30.
 */

public class Demo6 {

    public static void main(String[] args) {
        //要求： 求1~100之间数值的和
        int i = 1;
        int sum = 0;

        while (i <= 100) {
            sum += i;
            i++;
        }

        System.out.println("sum=" + sum);
        //重置变量
        i = 1;
        sum = 0;
        do {
            sum += i;
            i++;
        } while (i <= 100);
        System.out.println("sum=" + sum);
       //要求： 求5的阶乘
        int y = 5;
        int result = 1;
        do {
            result *= i;
            y--;
        } while (y > 1);

        System.out.println("5的阶乘为 " + result);

    }
}
