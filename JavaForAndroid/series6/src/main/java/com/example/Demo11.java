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
 * TreeMap自定义比较器
 * <p>
 * 案例:按地区存放学校
 * 建模
 * //School
 * //Area
 */
public class Demo11 {
    public static void main(String[] args) {
        List<School> schools1 = new ArrayList<School>();
        schools1.add(new School("10", "火星1"));
        schools1.add(new School("11", "火星2"));
        schools1.add(new School("12", "火星3"));

        List<School> schools2 = new ArrayList<School>();
        schools2.add(new School("20", "北京1"));
        schools2.add(new School("21", "北京2"));
        schools2.add(new School("22", "北京3"));


        //如果TreeMap<K,V>的K是自定义类型 ，则此类必须实现Comparable<T>接口，用于比较排序
        Map<Area, List<School>> clsMap = new TreeMap<Area, List<School>>();
        clsMap.put(new Area("1004", "火星"), schools1);
        clsMap.put(new Area("1002", "北京"), schools2);

        Set<Map.Entry<Area, List<School>>> entrySet = clsMap.entrySet();
        for (Map.Entry<Area, List<School>> cls : entrySet) {
            List<School> s = cls.getValue();
            System.out.println(cls.getKey().id+"\t" + cls.getKey().name + ":" + s);
        }

    }
}

//
class Area implements Comparable<Area> {
    //名字
    String name;
    //编号
    String id;

    public Area(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Area o) {
        //先比较班级的名称，如果名称相同，再比较id(也可以先比较id再比较name)
        int r = this.name.compareTo(o.name);
        return r == 0 ? this.id.compareTo(o.id) : r;
    }

    @Override
    public String toString() {
        return this.name + "\t";
    }
}

class School {
    private String id;
    private String name;

    public School(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "School[id=" + id + ", name=" + name + "]";
    }
}
