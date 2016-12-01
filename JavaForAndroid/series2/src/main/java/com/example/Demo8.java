package com.example;

import java.util.Scanner;

/**
 * Created by huangcl on 2016/12/1.
 */
//最值
public class Demo8 {

    public static void main(String[] args) {
        int[] nums = {9, 8, 10, 3, 90, 0, 60}; //以静态方式创建数组

        System.out.println("max-->" + max(nums));

        int[] nums2; //nums2=null;
        //System.out.println("max-->"+max(nums2));  //会报空指针异常:NullPointerException

        nums2 = new int[5];//创建数组，在内存中分配空间，并初始化值（0）

        //接收用户输入5个数值，并求最大的数
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < nums2.length; i++) {
            System.out.println("请输入一个数值：");
            nums2[i] = sc.nextInt();
        }

        System.out.println("max-->" + max(nums2));

    }

    //求数组中最大值
    static int max(int[] nums) {
        int max = nums[0];
        //求最大数,获取数组的长度： 数组名.length;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max; //返回最大值
    }
}
