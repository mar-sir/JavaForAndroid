package com.example;

/**
 * Created by huangcl on 2016/12/7.
 */

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ArrayList 基本用法同Demo3
 */
public class Demo4 {

    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("aaa");
        list1.add("bbb");
        list1.add("ccc");
        list1.add("ddd");
        list1.add("eee");
        list1.add("fff");
        list1.add("ggg");
        //错误写法
        /*
        for (String s : list1) {
            list1.remove(s);//Exception in thread "main" java.util.ConcurrentModificationException
        }*/
        Iterator<String> iterator = list1.iterator();
        //错误写法
       /* while (iterator.hasNext()) {
            iterator.remove();//Exception in thread "main" java.lang.IllegalStateException
        }*/
        //正确写法
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        System.out.println(list1);
    }
}
