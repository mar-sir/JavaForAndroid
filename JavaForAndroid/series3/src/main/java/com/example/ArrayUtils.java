package com.example;

/**
 * Created by huangcl on 2016/12/2.
 */

/**
 * static的应用：工具类
 * <p>
 * 实现给定数组的排序、查找、转换字符串、打印等功能
 */
public class ArrayUtils {
    //排序
    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int k = i;
            for (int j = i + 1; j < nums.length; j++) {
                //最左边最小
                if (nums[j] < nums[k])
                    k = j;
            }
            if (k != i) {
                swap(nums, i, k);  //静态方法只能调用静态方法
            }
        }
    }

    //交换
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //二分法查找
    public static int binarySearch(int[] nums, int key) {
        int min = 0, max = nums.length - 1, mid = (min + max) / 2;
        while (min <= max) {
            if (nums[mid] < key) {
                min = mid + 1;
            } else if (nums[mid] > key) {
                max = mid - 1;
            } else {
                return mid;
            }
            mid = (min + max) / 2;
        }
        return -1;


        
    }

    //将数组转字符串
    public static String toString(int[] nums) {
        String result = "[";
        for (int i = 0; i < nums.length; i++) {
            if (i != nums.length - 1)
                result += nums[i] + ",";
            else
                result += nums[i] + "]";
        }
        return result;
    }

    //判断数组是否为空
    public static boolean isEmpty(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        return false;
    }

    public static void sop(int[] nums) {
        if (isEmpty(nums)) {
            System.out.println("当前数组为空或null！");
            return;
        }
        System.out.println(toString(nums));
    }
}
