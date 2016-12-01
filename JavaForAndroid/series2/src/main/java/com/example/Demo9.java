package com.example;

/**
 * Created by huangcl on 2016/12/1.
 */

/**
 * jdk 1.5中增强for循环
 * <p>
 * 格式：  for(数据类型 变量名：数组名){ 循环体  }
 * <p>
 * 过程： 将数组中数从0的位置依次读取
 * <p>
 * 不好之处： 在循环体中无法访问 当前读取的索引值
 */
public class Demo9 {
    public static void main(String[] args) {
        //动态生成10个随机数(1~100)，并读取（打印）
        int[] nums = new int[10];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * 100 + 1); //生成1~100之间的随机数
        }

        //打印
        for (int n : nums) {
            System.out.print(n + "\t");
        }
    }
}
