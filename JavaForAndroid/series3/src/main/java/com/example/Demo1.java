package com.example;

/**
 * 数组简单排序
 */
public class Demo1 {
    private static final int[] arrs = {45, 12, 46, 20, 48, 33};

    public static void main(String[] args) {
        bubbleSort(arrs);
    }


    /**
     * 冒泡排序
     *
     * @param arrs
     */
    static void bubbleSort(int[] arrs) {
        System.out.print("排序前:\t\t\t");
        for (int k : arrs) {
            System.out.print(k + "\t");
        }
        System.out.println();
        for (int i = 0; i < arrs.length; i++) {
            for (int j = 0; j < arrs.length - 1 - i; j++) {
                if (arrs[j] > arrs[j + 1]) {
                    int temp = arrs[j];
                    arrs[j] = arrs[j + 1];
                    arrs[j + 1] = temp;
                }
                System.out.print("第" + (i+1) + "次" + "第" + (j+1) + "遍排序:" + "\t\t");
                for (int k : arrs) {
                    System.out.print(k + "\t");
                }
            }
            System.out.println();
        }
    }
}
