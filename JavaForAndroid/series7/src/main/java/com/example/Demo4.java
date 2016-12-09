package com.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by huangcl on 2016/12/9.
 */

public class Demo4 {
    public static void main(String[] args) {
        Collection<Student> cs = new ArrayList<Student>();
        cs.add(new Student("李xx", 20));
        cs.add(new Student("xxx", 19));
        cs.add(new Student("hhahah", 20));
        sop2(cs);

    }


    //接收的引用类型要么是Student类，要么是Student的父类：  确定下限
    static void sop2(Collection<? super Student> cs) {
        Iterator<?> iterator = cs.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
