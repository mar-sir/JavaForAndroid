package com.example;
/**
 * 数据交换
 */

/**
 * Created by huangcl on 2016/12/1.
 */

public class Demo7 {
    public static void main(String[] args) {
        int a = 10, b = 30;
        System.out.println(a + "," + b);
        swap(a, b);

        int[] nums = {100, 200};
        swap(nums);
    }


    //交换a和b的数值
    static void swap(int a, int b) {
        /*int c=a;
		a=b;
		b=c;
		*/
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println(a + "," + b);
    }


    //方法参数： 引用类型
    static void swap(int[] nums) {

        swap(nums[0], nums[1]);

        System.out.println(nums[0] + "," + nums[1]); //此时数组中的数值不会改变

        int c = nums[0];
        nums[0] = nums[1];
        nums[1] = c;

        System.out.println(nums[0] + "," + nums[1]); //此时，两个数值已交换
    }
}
