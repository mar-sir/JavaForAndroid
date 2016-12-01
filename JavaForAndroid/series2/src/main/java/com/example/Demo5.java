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

    }
}
