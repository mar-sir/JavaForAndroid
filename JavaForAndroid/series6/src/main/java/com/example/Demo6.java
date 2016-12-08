package com.example;

/**
 * Created by huangcl on 2016/12/7.
 */

import java.util.Iterator;
import java.util.TreeSet;

/**
 * TreeSet:  数据结构是黑红二叉树，保存数据的唯一性同HashSet，同时增加的对象必须是可排序的
 * <p>
 * 排序方式：
 * 1、 增加的对象类，实现Comparable接口
 * 2、 创建比较器，需要创建类，并实现Comparator接口
 */
public class Demo6 {

    public static void main(String[] args) {

        TreeSet treeSet = new TreeSet();

        //添加对象时，先确保对象的唯一性，再调用String.compareTo(Object obj)比较大小
        //默认排序方式：从小到大排序（依字符的ASCII码值或字符串长度）
        treeSet.add("aaa");
        treeSet.add("ccc");
        treeSet.add("bbb");
        treeSet.add("aaa");
        treeSet.add("eee");

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println(treeSet);//[aaa, bbb, ccc, eee]
    }
}
