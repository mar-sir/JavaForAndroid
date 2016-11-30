package com.example;

/**
 * Created by huangcl on 2016/11/30.
 */

public class Demo3 {

    public static void main(String[] args) {

        //'\'转义
        zhuanYi();

        //运算符
        yunSuanFu();
    }


    private static void yunSuanFu() {
        int a=18;
        int b=10;

        int c=a-b;

        //算术 + , - , *, /, %, ++,--
        int d=++c; //先自加，后返回（表达式的结果）,因此d=9,c=9

        int e=c++; //先返回，后自加，e=9,c=10

        int f=a/b; //取整数，f=1

        int h=a%b; //取余数，h=8


        //赋值：  = , +=,-=,/=, *=, %=

        //String.format(String ,Object ...) 格式化字符串，
        //将第一个参数中%位置的值用后面的参数替换,按先后顺序替换，
        //可用的%格式： %d 整数, %f,%.2f 带小数位的float/double,%s 字符串
        System.out.println(String.format("a=%d,b=%d,c=%d,d=%d,e=%d,f=%d,h=%d",a,b,c,d,e,f,h));//a=18,b=10,c=10,d=9,e=9,f=1,h=8


        h*=2; //h=h*2;

        byte b1=127;

        b1+=1; // -128

        //b1=127+1; //错误的，128已超出为byte类型大小

        System.out.println(b1);//-128

        //比较:  >, >= ,  < ,  <= ,  ==, != ,表达式结果为boolean

        System.out.println("c>d="+(c>d)); //c>d=true

        boolean b2=c>d;

        System.out.println("a==c ->"+(a==c)); //a==c ->false

        //逻辑：  &&， || ， ！， &，|

        // true && true  = true, true && false = false
        // true || false =true, false || true = true
        //  !true =false
        //  true & false :  false,
        // &与&&区别：   && 如果第一个是false则不再判断后面的值  & 两个都要判断
        // | 与|| 区别： || 如果第一个是true,则不再判断后面的值，| 两个都要判断


        //位运算:  & 按位与，两个都为1时，则为1，否则为0 ，eg. 1&0=0，1&1=1
        //         | 按位或，两个中任一个是1时，则为1, eg.   1|0=1,1|1=1,0|0=0
        //         ^ 按位异或， 两个相同时，为0，不同时为1， eg. 1^0=1,0^0=0,1^1=0

        //          ~ 按位取反，如果取反之后为负数，则按负数的正数取反加1得出结果，eg. ~10=-11

        System.out.println(~10000);//-10001

        //移位运算符：>> 向右移，相当于除于2^n  << 向左移，相当于乘于2^n    >>> 无符号移动

        // -10 >>2 ,与-10/4=-2 不同， 8>>3 ,  8/8=1;  -10>>>2, 无符号移动


        System.out.println(-10>>>2);//无符号移动，高位补0 //1073741821
    }





    //常用的转义字符   "\t" 制表 "\n" 换行
    private static void zhuanYi() {

        System.out.println("\t*\t*\t*");//	*	*	*
        //\t  制表符，\" , \\, \r\n (window 换行）,\n (linux 换行）

        System.out.println("name=\"小红\",\"age\":20");//name="小红","age":20

        System.out.println("name=\"小黑\",\n\"age\":20");//name="小黑",
        //"age":20
        System.out.println("\\5\\2\\");// \5\2\

    }
}
