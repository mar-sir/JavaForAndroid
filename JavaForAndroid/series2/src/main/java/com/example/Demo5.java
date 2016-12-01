package com.example;
/**
 * 数组： 存储相同类型的一组数据，
 * 数组也是一种数据类型，是引用数据类型（数组、类、接口）
 * <p>
 * 定义格式：
 * 数据类型[] 数组名 =new 数据类型[数组的长度];
 * <p>
 * //new 是在内存中分配空间，空间的大小由数组的长度和数据类型决定。
 * //在数组的内存分配完成后，会将内存的首地址返回给数组名，
 * 因此数组名是指向内存空间首地址的引用
 * <p>
 * 数组定义的其它格式：
 * 格式1：
 * int[] ns=new int[]{8,1,2,3,5,6,7};
 * <p>
 * 在创建数组时，根据指定的初始化值列表，确定数组的长度，来分配内存空间
 * <p>
 * 格式2： int[] ns={9,1,4,6,9,10};
 * <p>
 * 格式2的增强版
 * <p>
 * 说明：格式1和2都是静态方式创建数组
 */

/**
 * Created by huangcl on 2016/12/1.
 */

public class Demo5 {
    public static void main(String[] args) {
        //定义一个可以存放5个整数的数组
        int[] nums = new int[5]; //根据数据类型和长度，在内存分配了20byte
        nums[0] = 1;
        nums[4] = 9;
        //nums[2]=? //数组在创建完成后，会初始化每个成员的值
        for (int i = 0; i < 5; i++) {
            //此时的数组的有效索引范围： 0~4
            System.out.println(i + ":" + nums[i]);
        }
        //nums[5]; //出错，会出现ArrayIndexOutOfBoundsException

        //声明数组的长度，必须在创建数组时指定，不能在声明时指定
        //char[10] cs=new char[]; //错误的，数组的长度必须在创建时指定


        //int[] nd=new int[5]{1,7,9,10,2}; //错误：数组的固定长度不能与初始化列表同时存在
        int[] ns=new int[]{1,7,9,10,2};

        for(int i=0;i<ns.length;i++){
            System.out.print(ns[i]+"\t");
        }

    }
}
