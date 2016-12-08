package com.example;

/**
 * Created by huangcl on 2016/12/8.
 */


import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Map
 */
public class Demo8 {

    public static void main(String[] args) {
        //key   //value//Map<K,V>
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "aaa");//添加元素
        map.put(2, "www");
        map.put(3, "assaa");
        map.put(4, "qqq");
        map.put(5, "ggg");
        map.put(1, "nnn");//修改元素
        map.put(6, "ooo");
        map.put(7, "232");
        map.put(12, "ffds");
        System.out.println(map.size() + "");//获取大小//8
        //////////////////////
        System.out.println(map.isEmpty());//size==0?//false
        //////////////////////
        System.out.println(map.containsKey(10));//查看是否包含某个键//false
        /////////////////////
        System.out.println(map.containsValue("ooo"));//查看是否包含某个值//true
        /////////////////////
        System.out.println(map.get(3));//跟据key获取值//assaa
        /////////////////////
        map.remove(12);//移除键对应的值
        System.out.println(map.containsKey(12));//false
        /////////////////////
        Map<Integer, String> map1 = new HashMap<>();
        map.put(100, "999");//添加元素
        map.put(110, "222");//添加元素
        map.put(120, "333");//添加元素
        map.putAll(map1);//批量保存
        Set<Integer> integers = map.keySet();//获取Map中键的集合
        System.out.println(integers);//[1, 2, 3, 4, 100, 5, 6, 7, 120, 110]
        ////////////////////////
        Collection<String> values = map.values();//获取Map中值的集合
        System.out.println(values);//[nnn, www, assaa, qqq, 999, ggg, ooo, 232, 333, 222]
        ////////////////////////
        Set<Map.Entry<Integer, String>> entries = map.entrySet();//迭代
        Iterator<Map.Entry<Integer, String>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> mapNext = iterator.next();
            System.out.print(mapNext.getKey() + "-->" + mapNext.getValue() + "\t");
            //1-->nnn	2-->www	3-->assaa	4-->qqq	100-->999	5-->ggg	6-->ooo	7-->232	120-->333	110-->222
        }

    }
}
