package com.example;

/**
 * Created by huangcl on 2016/12/20.
 */

public class Demo12 {
    public static void main(String[] args) {
        int a = fun(5);
    }

    /**
     * 递归求阶乘
     *
     * @param n
     */
    private static int fun(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * fun(n - 1);
    }

    /**
     * 古典兔子
     *
     * @param x
     * @return
     */
    public static int getNums(int x) {
        int nums = 1;

        if (x == 1 || x == 2) {
            return nums;
        }
        return getNums(x - 1) + getNums(x - 2);
    }
}
