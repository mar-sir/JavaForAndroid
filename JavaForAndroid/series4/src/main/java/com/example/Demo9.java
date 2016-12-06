package com.example;

/**
 * Created by huangcl on 2016/12/6.
 */

/**
 * 多态中成员特点：
 * <p>
 * 成员变量： 能访问哪些成员变量，编译和运行时都看父类
 * 成员方法： 访问哪些方法，编译时看父类，其运行结果要看子类
 * <p>
 * 静态成员：  都看父类
 */
public class Demo9 {
    public static void main(String[] args) {
        Parent1 parent1 = new Child1();
        System.out.println("num->" + parent1.num); //成员变量的结果：在编译和运行都看父类//num->20

        parent1.say();//运行哪一个方法，编译时看父类，运行时看子类//Child1 say()

        parent1.fun();//运行哪一个方法：(静态)编译和运行时都看父类//Parent1 static fun()


        Child1 child1 = (Child1) parent1;
        System.out.println("num->" + child1.num);//num->50
        child1.say();//Child1 say()
        child1.fun();//Child1 static fun()
    }
}

class Parent1 {
    int num = 20;

    public void say() {
        System.out.println("Parent1 say()");
    }

    public static void fun() {
        System.out.println("Parent1 static fun()");
    }

}

class Child1 extends Parent1 {
    int num = 50;

    public void say() {
        System.out.println("Child1 say()");
    }

    public static void fun() {
        System.out.println("Child1 static fun()");
    }

}