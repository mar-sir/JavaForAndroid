package com.example;


/**
 * Created by huangcl on 2016/12/8.
 */

public class Demo2 {

    public static void main(String[] args) {
        Manager<Student> manager = new Manager<Student>();
        manager.add(new Student("小鱼", 20));
        manager.add(new Student("小黑", 30));
        manager.add(new Student("SF", 21));

        System.out.println("get--->" + manager.get(1));

        manager.sop();
    }
}
