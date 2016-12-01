package com.example;

public class Demo1 {

    public static void main(String[] args) {
        int k = 1, count = 0;
        for (; k <= 100; k++) {

            if (k % 2 == 0) {
                continue;  //结束本次循环，转到下一次循环
                //后面代码同样不会执行
            }
            count++;//有多少个奇数
        }
        System.out.println(count);
        System.out.println("===================================");
        //
        int sum = 0;
        outer:
        for (int m = 0; m < 100; m++) {
            inner:
            for (int n = 0; n < 20; n++) {
                sum += n;  //sum ++;
                if (n == 5) break;//跳出了当前循环,但跳不出第二层循环
                if (sum >= 100) {
                    break outer;//跳出outer
                }
            }

        }
        System.out.println(sum);
    }
}
