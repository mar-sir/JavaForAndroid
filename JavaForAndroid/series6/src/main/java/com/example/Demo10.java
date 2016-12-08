package com.example;

/**
 * Created by huangcl on 2016/12/8.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * TreeMap：
 * 使用了二叉权的数据结构，key是有序，保存其唯一性用到了hashCode()、equals()以及比较器（唯一性判断同HashSet）
 */
public class Demo10 {
    public static void main(String[] args) {
        //来个稍微复杂点的：存放一个Student链表
        //TreeMap<K,V>K类必须实现Comparable<T>接口，用于比较排序
        TreeMap<String, List<Student>> map = new TreeMap<>();

        List<Student> students1 = new ArrayList<>();
        students1.add(new Student("小花", 23));
        students1.add(new Student("小黑", 20));
        students1.add(new Student("小鱼", 29));
        students1.add(new Student("小小", 23));
        map.put("小班", students1);

        List<Student> students2 = new ArrayList<>();
        students2.add(new Student("大花", 230));
        students2.add(new Student("大黑", 200));
        students2.add(new Student("大鱼", 290));
        students2.add(new Student("大大", 230));
        map.put("大班", students2);

        Set<Map.Entry<String, List<Student>>> entries = map.entrySet();
        for (Map.Entry<String, List<Student>> entry : entries) {
            List<Student> s = entry.getValue();
            System.out.println(entry.getKey() + ":" + s);
        }
    }
}

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "[" + this.name + ":\t" + this.age + "]";
    }

}
