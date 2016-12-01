package com.example;

import java.util.Scanner;
/**
 * 方法（函数）: 为了减少代码的重复性，可以被多次调用
 * <p>
 * 声明方法时：
 * 1、 方法是否有结果：有返回值
 * 2、 调用方法时，是否需要不确定数: 需要,则声明参数
 */

/**
 * Created by huangcl on 2016/12/1.
 */

public class Demo2 {

    public static void main(String[] args) {
        //输入两个数，求和
        sum();
    }
    //自定义方法，实现输入两个数并求和
    static void sum() {
        //输入两个数，求和
        Scanner sc = new Scanner(System.in);
        int sum = 0, num = 0;
        System.out.println("请输入第一个数：");
        num = sc.nextInt();
        sum += num;
        System.out.println("请输入第二个数：");
        num = sc.nextInt();
        sum += num;
        System.out.println("两个数的和：" + sum);
        sc.close();//关闭与I/O的连接，释放资源
    }
}
