package com.example;

/**
 * Created by huangcl on 2016/12/6.
 */

/**
 * 自动拆装箱
 */
public class Demo10 {
    public static void main(String[] args) {

        String ss = "19.5";
        Double ssD = Double.parseDouble(ss);

        //int ssI=Integer.parseInt(ss); //报异常，不能将带有小数的字符串转成整数

        System.out.println(ssD.toString());//19.5


        System.out.println(Integer.toString(34, 10));//转成指定进制(转成十进制)//34

        Integer a = 100; //自动装箱： 先创建Integer，然后将100存入到Integer创建的内存中

        int sum = a + 10;  //自动拆箱： 先调用a.intValue()将其值取出，与10进行计算，将结果赋于sum

        System.out.println(sum);//110


        Integer a1 = 100;
        Integer a2 = 100;
        //java默认情况下，会在常量池中创建-128~127常量对象
        System.out.println(a1 == a2);//true
        ////////////////////////////////
        Integer a5 = 234;
        Integer a6 = 234;
        //java默认情况下，会在常量池中创建-128~127常量对象
        System.out.println(a5 == a6);//false
        ////////////////////////////////
        Integer a3 = 0;
        System.out.println(a1 == (a2 + a3));//true

        System.out.println(a1.hashCode() + "," + a2.hashCode());//true

        //注：整型数值的hashCode()是其本身，除Long之外（有可能不相同）
        Long l1 = new Long(1234567800L);

        System.out.println(l1.hashCode());//1234567800
    }
}
