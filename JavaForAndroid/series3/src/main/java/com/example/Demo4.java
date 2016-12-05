package com.example;

/**
 * Created by huangcl on 2016/12/5.
 */

/**
 * 局部变量与成员变量的区别
 * <p>
 * 局部变量： 随着方法入栈初始化，随着方法出栈而消失
 * 成员变量： 随着对象的初始化创建，随着对象的回收而消失
 */
public class Demo4 {
    public static void main(String[] args) {
        Student student = new Student();
        student.name = "萌萌";
        student.age = 18;

        student.say();

        student = null;//person指向的堆内存会被垃圾回收器（GC）回收
    }
}

class Student {
    String name;
    int age;

    public void say() {
        int id = 1;
        System.out.println(id + "今年" + name  + age+"岁");
    }
}
