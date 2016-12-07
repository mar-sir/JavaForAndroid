package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangcl on 2016/12/7.
 */

/**
 * List
 */
public class Demo3 {
    public static void main(String[] args) {
        List list1 = new ArrayList();
        list1.add("aaa");
        list1.add("bbb");
        list1.add("ccc");
        list1.add("ddd");
        list1.add("eee");
        list1.add("fff");
        list1.add("ggg");
        System.out.println(list1.get(4));//eee
        System.out.println(list1);//[aaa, bbb, ccc, ddd, eee, fff, ggg]
        list1.set(2, "eee");
        list1.add(3, "zzz");//指定位置添加元素
        System.out.println(list1);//[aaa, bbb, eee, zzz, ddd, eee, fff, ggg]
        System.out.println(list1.indexOf("eee"));//2
        System.out.println(list1.lastIndexOf("eee"));//5
        System.out.println(list1.subList(2, 4));//返回[2,4)左右开的元素//[eee, zzz]
    }
}
