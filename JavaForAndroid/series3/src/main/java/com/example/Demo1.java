package com.example;

/**
 * 数组简单排序
 */
public class Demo1 {
    private static final int[] arrs = {45, 12, 46, 20, 48, 33};

    public static void main(String[] args) {
        //冒泡排序
        //bubbleSort(arrs);
        //选择排序
        //selectSort(arrs);
        //简化版选择排序
        //betterSelectSort(arrs);
        //插入排序
        insertSort(arrs);

    }


    /**
     * 冒泡排序
     * 保证最大值在最后面
     *
     * @param arrs
     */
    static void bubbleSort(int[] arrs) {
        beforeSort(arrs);
        for (int i = 0; i < arrs.length; i++) {
            for (int j = 0; j < arrs.length - 1 - i; j++) {
                if (arrs[j] > arrs[j + 1]) {
                    int temp = arrs[j];
                    arrs[j] = arrs[j + 1];
                    arrs[j + 1] = temp;
                }
                printHint(arrs, i, j);
            }
            System.out.println();
        }
    }


    /**
     * 选择排序
     * 保证最左边的最小
     *
     * @param arrs
     */
    private static void selectSort(int[] arrs) {
        beforeSort(arrs);
        for (int i = 0; i < arrs.length - 1; i++) {
            for (int j = i + 1; j < arrs.length; j++) {
                if (arrs[i] > arrs[j]) {
                    int temp = arrs[j];
                    arrs[j] = arrs[i];
                    arrs[i] = temp;
                }
                printHint(arrs, i, j);
            }
            System.out.println();
        }
    }

    /**
     * 大大的减少数组变动次数
     *
     * @param arrs
     */
    private static void betterSelectSort(int[] arrs) {
        beforeSort(arrs);
        for (int i = 0; i < arrs.length - 1; i++) {
            int k = i;
            for (int j = i + 1; j < arrs.length; j++) {
                if (arrs[k] > arrs[j]) k = j;
            }
            if (k != i) {
                int temp = arrs[i];
                arrs[i] = arrs[k];
                arrs[k] = temp;
            }
            System.out.print("第" + (i + 1) + "次遍排序:" + "\t\t");
            for (int x : arrs) {
                System.out.print(x + "\t");
            }
            System.out.println();

        }
    }


    /**
     * 插入排序,认为左边的数是有序数列
     *
     * @param arrs
     */
    private static void insertSort(int[] arrs) {
        beforeSort(arrs);
        int count = 0;
        for (int i = 1; i < arrs.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arrs[j] < arrs[j - 1]) {
                    int temp = arrs[j - 1];
                    arrs[j - 1] = arrs[j];
                    arrs[j] = temp;
                } else {
                    break;
                }
                System.out.print("第" + ++count + "次遍排序:" + "\t\t");
                for (int x : arrs) {
                    System.out.print(x + "\t");
                }
            }
            System.out.println();
        }

    }

    /**
     * 这体现代码，复用
     *
     * @param arrs
     */
    private static void beforeSort(int[] arrs) {
        System.out.print("排序前:\t\t\t");
        for (int k : arrs) {
            System.out.print(k + "\t");
        }
        System.out.println();
    }

    /**
     * 这体现代码，复用
     * 同样你也可以把数组交换的代码抽做一个方法，
     *
     * @param arrs
     * @param i
     * @param j
     */
    private static void printHint(int[] arrs, int i, int j) {
        System.out.print("第" + (i + 1) + "次" + "第" + (j + 1) + "遍排序:" + "\t\t");
        for (int k : arrs) {
            System.out.print(k + "\t");
        }
    }

}
