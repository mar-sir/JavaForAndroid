package com.example;

/**
 * Created by huangcl on 2016/12/6.
 */

import java.util.Scanner;

/**
 * 异常： 在程序运行时发生了不正常的情况，此时由系统中断程序的运行
 * <p>
 * 异常类的由来： 当程序发生不正常情况时，Java中提供一个类描述这个不正常情况的信息，
 * 包含异常信息、异常类名、异常的位置
 * <p>
 * 异常分类：
 * Error 错误： 由系统原因造成的，一般是系统资源分配冲突时或系统崩溃等原因
 * 这一类Error错误，对于程序员来说是无法处理的
 * <p>
 * Exception： 由于程序原因造成的，一般是运算、I/O读取等原因
 * 这一类Exception异常，可以进行处理
 * <p>
 * Java中异常类的体系：
 * <p>
 * Throwable
 * Error:
 * Exception
 * RuntimeException :非受控异常（运行时异常）
 * <p>
 * 在Java中如何处理异常
 * <p>
 * 1、捕获异常处理
 * <p>
 * 格式1：
 * try{
 * 可能出现异常的语句;
 * }catch(异常类型 对象名){
 * 处理异常语句;
 * }
 * <p>
 * 2、抛出异常
 * <p>
 * 1) 声明方法时抛出异常
 * <p>
 * 方法名() throws 异常类名[,异常类名,异常类名] {}
 * <p>
 * 2）在方法中抛出异常
 */
public class Demo4 {

    static int divide(int a, int b) throws ArithmeticException {
        int result = 0;

        result = a / b; //当发生异常时，向调用者抛出异常

        //当异常从某一位置抛出后，其下的语句不会被执行
        System.out.println("计算结果完成....");

        return result;
    }


    public static void main(String[] args) {
        //输入两个数
        Scanner scanner = new Scanner(System.in);

        //将数字字符串转成数值类型
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.close();
        try {
            int r = divide(a, b);

            System.out.println(r);

        } catch (Exception e) { //可以处理所有异常，即Exception类是所有异常的父类
            e.printStackTrace();
        }


    }
}
