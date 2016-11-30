package com.example;
/**
 * switch分支语句
 * <p>
 * 格式：
 * <p>
 * switch(表达式1){ //表达式的数据类型： char,byte,short,int,long,enum(jdk 1.5),String(jdk 1.7)
 * <p>
 * case 数值1:
 * <p>
 * //当表达式1的值为当前位置的数值1时
 * <p>
 * 语句;
 * <p>
 * case 数值2：
 * <p>
 * 语句;
 * <p>
 * break;
 * default:
 * <p>
 * //上面case语句没有一个被执行或者在case语句中不存在break，则进入此处，进行默认行为的处理
 * <p>
 * }
 */

/**
 * Created by huangcl on 2016/11/30.
 */

public class Demo5 {

    public static void main(String[] args) {
        switch (10) {

            case 5:
                System.out.println("表达式与5匹配");
                break;
            case 10:
                System.out.println("表达式与10匹配");
                break;
            case 15:
                System.out.println("表达式与15匹配");
                break;
            default:
                System.out.println("表达式中不存在与10匹配的语句或没有出现break");

        }
        switch (5) {

            case 5: {
                int i = 5; //变量的作用域： 从声明位置开始到 右大括号结束
                System.out.println(i);
                //break;
            }
            case 10:
                int i = 10;
                System.out.println(i);
                break;
            case 15:
                System.out.println("表达式与15匹配");
                break;
            default:
                System.out.println("表达式中不存在与10匹配的语句或没有出现break");

        }
    }
}
