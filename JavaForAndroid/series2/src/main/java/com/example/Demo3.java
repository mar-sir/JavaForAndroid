package com.example;
/**
 * 方法（函数）: 为了减少代码的重复性，可以被多次调用
 * <p>
 * 声明方法时：
 * 1、 方法是否有结果：有返回值
 * 2、 调用方法时，是否需要不确定数: 需要,则声明参数
 * <p>
 * <p>
 * 注意：
 * 1、 声明的方法一般被main方法调用 ，main方法被 JVM
 * 2、 方法中需要的数据由main方法提供（调用者提供）
 * 3、 方法如果有返回结果，此结果返回给调用者
 * <p>
 * 方法定义的格式：
 * <p>
 * 返回数据类型  方法名（参数列表）{ }
 * <p>
 * 返回数据类型： 无返回类型 void ,有返回类型，是结果的数据类型
 * <p>
 * 在一个类中，可以出现多个重命的方法，
 * 但要求方法的参数不同：个数、类型、同个数但类型不同
 * 从而构成了方法的重载。
 */

/**
 * Created by huangcl on 2016/12/1.
 */

public class Demo3 {

    public static void main(String[] args) {
        int sum = sum(10, 9); //返回结果为19

        sop("sum->" + sum);//sum->19

        sop("10+19+8=" + sum(10, 19, 8));//10+19+8=37

        sop("10.5+19.25=" + sum(10.5, 19.25));//10.5+19.25=29.75
    }

    //有返回结果，有不确定的数
    static int sum(int a, int b) { //方法的重载

        if (a != 0 || b != 0)
            return a + b; //结果返回之后，后面的语句就不会执行

        //如果有返回结果，必须存在一个return语句
        return 0;
    }

    //功能：三个数相加，返回和
    static int sum(int a, int b, int c) { //方法的重载
        return sum(sum(a, b), c);
    }

    //功能：实现2个小数相加的和
    static double sum(double a, double b) { //方法的重载
        return a + b;
    }

    //功能：打印指定的消息，无返回结果，但有不确定的数据（有参）
    static void sop(String msg) {
        System.out.println(msg);

        //如果方法无返回数据，也可以使用return结束方法
        return;

        //return 之后的语句不能被执行--编译就不通过
        //System.out.print("<------->");
    }
}
