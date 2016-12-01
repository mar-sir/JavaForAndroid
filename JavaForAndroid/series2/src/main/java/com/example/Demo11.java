package com.example;

/**
 * Created by huangcl on 2016/12/1.
 */
//十进制转成二进制和十六进制
public class Demo11 {
    public static void main(String[] args) {
        toBinnary(70); // 1000110
        //toBinnary(-5); // 0000 0101 ->  1111 1010 -> 1111 1011

        toHex(120); // 64+32+16+8  -> 0111 1000 -> 78
    }

    //十进制转二进制：参数-整型的数，结果：无
    static void toBinnary(int num) {
        int[] ns = new int[32];

        int index = 0; //数组的索引位置

        while (num != 0) {
            ns[index++] = num & 1; //将低位数放在数组的第一位
            num = num >> 1;
        }
        //倒着显示
        for (int i = ns.length - 1; i >= 0; i--) {
            System.out.print(ns[i]);
        }

    }

    //将十进制转成十六进制： 参数-整型的数，结果：无
    static void toHex(int num) {
        char[] cs = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        char[] result = new char[8];

        int index = result.length - 1;

        while (num != 0) {

            result[index--] = cs[num & 15];

            num = num >> 4; //取下一个数，即高四位数
        }

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }

    }

}
