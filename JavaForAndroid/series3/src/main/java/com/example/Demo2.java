package com.example;

/**
 * Created by huangcl on 2016/12/2.
 */

import java.util.Arrays;

/**
 * 二分法查找
 * <p>
 * 前提：必须是有序数组
 */
public class Demo2 {
    private static final int[] arrs = {45, 12, 46, 20, 48, 33};

    private static final int[] arrs1 = {45, 12, 46, 20, 48, 33};

    public static void main(String[] args) {
        //首先排序数组
        insertSort(arrs);
        sop(arrs);
        //查找
        int index = binaryFind(arrs, 20);

        int index2 = binaryFind(arrs, 90);

        sop(index, 20);
        sop(index2, 90);
        System.out.println("================系统自带的Arrays类=================");
        Arrays.sort(arrs1);
        System.out.println(Arrays.toString(arrs1));
        System.out.println("20查找的位置：" + Arrays.binarySearch(arrs1, 20));
        System.out.println("90查找的位置：" + Arrays.binarySearch(arrs1, 90));

    }

    private static void sop(int index, int key) {
        System.out.println();
        if (index != -1) {
            System.out.println(key + "的位置为:" + index);
        } else {
            System.out.println("没有找到" + key + "的位置");
        }
    }

    private static int binaryFind(int[] arrs, int key) {
        //数组操作 下标是关键
        //定义下标
        int min = 0;//最小值下标
        int max = arrs.length - 1;//最大值下标
        int mid = arrs.length / 2;//中间值下标
        while (min < max) {//查找的终止条件
            if (arrs[mid] > key) {//表明key在数组前部分
                max = mid - 1;
            } else if (arrs[mid] < key) {//表明key在数组后半部分
                min = mid + 1;
            } else {
                return mid;//找到下标
            }
            mid = (min + max) / 2;//中间下标也要改变
        }
        return -1;
    }


    private static void sop(int[] arrs) {
        System.out.println("排序后:");
        for (int k : arrs) {
            System.out.print(k + "\t");
        }
    }

    private static void insertSort(int[] arrs) {
        for (int i = 1; i < arrs.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arrs[j] < arrs[j - 1]) {
                    int temp = arrs[j - 1];
                    arrs[j - 1] = arrs[j];
                    arrs[j] = temp;
                } else {
                    break;
                }
            }
        }
    }
}
