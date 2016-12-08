package com.example;

/**
 * Created by huangcl on 2016/12/7.
 */

import java.util.HashSet;
import java.util.Set;

/**
 * Set
 * 存储对象无序，并且唯一
 * 如何判断对象的唯一性：根据Object提供的 int hashCode()和boolean equals(Object obj)方法
 * 唯一性的过程：  先调用对象的hashCode()方法，如果哈希值不相同，则直接添加到集合中，
 * 若哈希值相同，则会调用eqauls()方法判断内容是否相同，若返回false，则表示内容不同，
 * 那么将其添加到集合中，反之，返回true时，则不添加到集合中
 */
public class Demo5 {

    public static void main(String[] args) {
        Set set = new HashSet();
        set.add("aaa");//添加的时候就判断唯一性
        set.add("bbb");
        set.add("ccc");
        set.add("aaa");
        set.add("ddd");
        set.add("aacca");
        set.add("aaa");
        System.out.println(set);//[aaa, ccc, bbb, ddd, aacca]
        Boolean b = false;
        //注：hashCode()相同时，并不一定代表是同一类型的对象
        System.out.println(b.hashCode() + "," + new Integer(1237).hashCode());
    }
}
