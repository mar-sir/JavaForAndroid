package com.example;

/**
 * Created by huangcl on 2016/12/1.
 */

/**
 * 二维数组
 * 定义格式：
 * <p>
 * 数据类型[][] 数组名 = new 数据类型[行大小][列大小];
 * <p>
 * 数据类型[][] 数组名 =new 数据类型[][]{{1,3,2},{2,3,4},{},{0,9,2}}
 * <p>
 * 数据类型[][] 数组名 ={{1,3,2},{2,3,4},{},{0,9,2}}
 */
public class Demo10 {

    public static void main(String[] args) {
        int[][] scores = new int[][]{{90, 80, 100}, {92, 90, 100}, {91, 95, 96}, {95, 100, 100}, {97, 98, 100}};


        //循环一维数组：行
        for (int i = 0; i < scores.length; i++) {

            System.out.print("第 " + (i + 1) + " 人的成绩：");

            //循环二维数组： 列
            for (int j = 0; j < scores[i].length; j++) {

                if (j != scores[i].length - 1)
                    System.out.print(scores[i][j] + ",");
                else
                    System.out.print(scores[i][j] + "\n");
            }
        }
    }
}
