package com.example;

/**
 * Created by huangcl on 2016/12/6.
 */

/**
 * 匿名内部类
 * 定义在类的成员方法中的内部类
 */
public class Demo2 {

    public static void main(String[] args) {
        Outer1 outer = new Outer1();
        outer.fun();//fun->Inner say()100
    }
}

class Outer1 {

    public void fun() {
        final int num = 100; //注：在jdk 1.8之后，局部内部类访问的局部变量是有效的

        //声明局部内部类
        class Inner {
            public void say() {
                //局部内部类中，如果要访问局变量时，则局部变量需要final修饰
                System.out.println("fun->Inner say()" + num);
            }
        }

        Inner inner = new Inner();
        inner.say();

    }

}