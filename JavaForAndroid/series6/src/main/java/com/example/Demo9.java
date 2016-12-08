package com.example;

/**
 * Created by huangcl on 2016/12/8.
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;


/**
 * LinkedHashMap
 * LinkedHashMap和HashMap区别
 * LinkedHashMap 保存了记录的插入顺序
 * HashMap 则无序存放
 */
public class Demo9 {

    public static void main(String[] args) {
        //关注点一：看添加之后的输出结果对比
        System.out.println("关注点一：LinkedHashMap输出:");
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(1, "aaa");//添加元素
        linkedHashMap.put(7, "www");
        linkedHashMap.put(5, "ggg");
        linkedHashMap.put(1, "nnn");//修改元素
        linkedHashMap.put(6, "ooo");
        linkedHashMap.put(7, "232");
        linkedHashMap.put(12, "ffds");

        Set<Map.Entry<Integer, String>> entries = linkedHashMap.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> next = iterator.next();
            System.out.print(next.getKey() + "-->" + next.getValue() + "\t");
            //1-->nnn	7-->232	5-->ggg	6-->ooo	12-->ffds
        }

        System.out.println();
        System.out.println("关注点一：HashMap输出:");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "aaa");//添加元素
        map.put(7, "www");
        map.put(5, "ggg");
        map.put(1, "nnn");//修改元素
        map.put(6, "ooo");
        map.put(7, "232");
        map.put(12, "ffds");
        Set<Map.Entry<Integer, String>> entries1 = map.entrySet();//迭代
        Iterator<Map.Entry<Integer, String>> iterator1 = entries1.iterator();
        while (iterator1.hasNext()) {
            Map.Entry<Integer, String> mapNext = iterator1.next();
            System.out.print(mapNext.getKey() + "-->" + mapNext.getValue() + "\t");
            //1-->nnn	5-->ggg	6-->ooo	7-->232	12-->ffds
        }
        /////////////////////////////////////////////////////////////////
        //关注点二：换一个构造方法
        System.out.println();                                              //10 大小//0.75还不清楚//true代表使用访问顺序
        LinkedHashMap<Integer, String> linkedHashMap1 = new LinkedHashMap<>(10, 0.75f, true);
        linkedHashMap1.put(1, "aaa");//添加元素
        linkedHashMap1.put(7, "www");
        linkedHashMap1.put(5, "ggg");
        linkedHashMap1.put(1, "nnn");//修改元素
        linkedHashMap1.put(6, "ooo");
        linkedHashMap1.put(7, "232");
        linkedHashMap1.put(12, "ffds");
        System.out.println("=======================================================");
        System.out.println("更换构造方法后未使用元素之前输出");
        Set<Map.Entry<Integer, String>> entries2 = linkedHashMap1.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator2 = entries2.iterator();
        while (iterator2.hasNext()) {
            Map.Entry<Integer, String> next = iterator2.next();
            System.out.print(next.getKey() + "-->" + next.getValue() + "\t");
            //5-->ggg	1-->nnn	6-->ooo	7-->232	12-->ffds
        }
        System.out.println();
        //关键点来了
        System.out.println(linkedHashMap1.get(6));//ooo
        System.out.println(linkedHashMap1.get(12));//ffds
        System.out.println("更换构造方法后未使用元素之后输出");
        Set<Map.Entry<Integer, String>> entries3 = linkedHashMap1.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator3 = entries3.iterator();
        while (iterator3.hasNext()) {
            Map.Entry<Integer, String> next = iterator3.next();
            System.out.print(next.getKey() + "-->" + next.getValue() + "\t");
            //5-->ggg	1-->nnn	7-->232	6-->ooo	12-->ffds
        }

    }
}
