package com.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by huangcl on 2016/12/7.
 */

/**
 * Collection
 */
public class Demo2 {
    public static void main(String[] args) {
        Collection datas = new LinkedList();//可以不像数组那样指定大小
        datas.add("aaa");//添加元素
        System.out.println(datas.add("bbb"));//true
        if (!datas.contains("ccc")) {
            datas.add("ccc");
        }
        ///////////////////////////////////////////
        Collection datas1 = new ArrayList();
        datas1.add("aaa");
        datas1.add("bbb");
        //判断子集合中的所有对象是否存在
        if (datas.containsAll(datas1)) {//true
            System.out.println("datas包含datas1");//输出
        }
        Collection datas3 = new ArrayList(10);
        datas3.add("eee");
        datas3.add("fff");
        datas3.add("ggg");
        datas.addAll(datas3);
        //////////////////////////////////////////
        System.out.println(datas);//[aaa, bbb, ccc, eee, fff, ggg]
        System.out.println(datas.size());//6

        datas.remove("ccc");
        datas.retainAll(datas3);
        System.out.println(datas);//[eee, fff, ggg]
        datas.clear();
        System.out.println(datas.size());//0

        Iterator iterator = datas1.iterator();//迭代器
        while (iterator.hasNext()) {
            System.out.println(iterator.next());//输出datas1中所有元素
        }
    }
}
