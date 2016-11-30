package com.example;

/**
 * Created by huangcl on 2016/11/30.
 */

public class Demo2 {


    public static void main(String[] args) {

        //方法调用
        bianLiang();

        //基本数据类型
        //整型: byte short int long
        //浮点型: float double
        //逻辑型: boolean (false true)
        //字符型: char
        numberTypes();

    }

    private static void numberTypes() {
        byte b1 = 10; //-128~127
        //byte b2=200; //错误：超出最大值

        int i = b1; //合法，小的数据类型向大的数据类型自动转换

        //short s=i; //错误: 大的数据类型不能向小的数据类型转换

        short s2 = (short) i; //合法，强转将大的向小的转

        System.out.println(s2);


        byte b = 20;
        short s = 3000;
        int ii = 89;
        long l = 90;

        //float f=8.0;//非法，因为8.0默认为double类型，因此后面增加f或F
        float f = 8.0f;

        double dd = b + s + ii + l + f;//合法的,自动将小的向大的转型


        String tag = "Hello";
        boolean flag = true;

        System.out.println(flag);
        System.out.println(tag + "  java");//字符串可以通过+连接任一变量，最终生成新的字符串

        System.out.println(dd);
    }


    //命名规则:$ 、字母、下划线开头都行，后面的可以是数字、字母、下划线
    //命名区分大小写
    private static void bianLiang() {
        //变量 有数据类型的，且可以改变内容的标识符
        //(1)变量与常量的相同点是在声明之前都指定变量的数据类型，变量无final关键字声明。
        //（2）声明变量语法：<类型>variable;
        int a = 20;
        //常量 存储在常量池中
        // （1）常量表示的是在程序中不能被修改的数据。
        // （2）声明常量必须用final关键字。
        // （3）常量分为：整型，浮点型，字符型，布尔型，字符串型常量,null。例如，语法：final<类型>variable=值;
        final int b = 30;

        System.out.println(a);

        System.out.println(b);
    }
}
