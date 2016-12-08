package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Collections
 * <p>
 * Arrays
 */
public class Demo1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("aaa");
        list.add("adc");
        list.add("bcd");
        list.add("abb");
        System.out.println("\n排序前:");
        sop(list);

        //排序
        Collections.sort(list);
        System.out.println("\n排序后:");
        sop(list);
        //反排,前提先执行sort()进行一次排序
        Collections.reverse(list); //反转
        System.out.println("\n反转:");
        sop(list);


        //获取最大的值
        String maxStr = Collections.max(list);
        System.out.println("\n最大值:\r\n---->" + maxStr);

        String ss = "22 90 34 50 65";
        String[] nums = ss.split(" ");
        List<String> ln = new ArrayList<>();
        for (String n : nums) ln.add(n);
        /////////////////////////////////////////////////////
        //将数组转成集合
        List<String> lns = Arrays.asList(nums);

        String maxN = Collections.max(lns);
        System.out.println("\r\n---->" + maxN);

        //将集合转成数组： 可以固定集合大小，不允许再出现删除和增加操作
        String[] str = lns.toArray(new String[lns.size()]);
        System.out.println(str);
    }

    static void sop(List<String> list) {
        for (String s : list)
            System.out.print(s + " ");
    }
}
