package com.example;

/**
 * Created by huangcl on 2016/12/6.
 */

/**
 * 内部类： 定义在类的内部，内部类所在的类称之为外部类
 * class 外部类的名{
 * <p>
 * class 内部类的名{
 * <p>
 * <p>
 * }
 * }
 */
public class Demo1 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.run();//Inner say()-->40
        //Inner say() Outer.this.num-->10

        //创建内部类的对象
        Outer.Inner inner = outer.new Inner();
        inner.say();//Inner say()-->40
        //Inner say() Outer.this.num-->10

        //创建静态成员的内部类对象
        Outer.Inner_2 inner2 = new Outer.Inner_2();
        inner2.say();//inner 2 say()

    }
}

class Outer {
    int num = 10; //外部类的成员变量

    //内部类作为外问部的成员，如果要访问内部类，需要通过类的对象访问
    class Inner {
        public static final int IP = 100;

        int num = 40;

        public void say() {

            System.out.println("Inner say()-->" + num);

            System.out.println("Inner say() Outer.this.num-->" + Outer.this.num);//在内部类中可以访问其所在外部类的成员
        }
    }

    public void run() {
        Inner inner = new Inner();
        inner.say();
    }

    //外部类的静态成员
    static class Inner_2 {

        public static void say() {
            System.out.println("inner 2 say()");
            //System.out.println("inner 2 say()"+num);//出错：静态内部类不能访问外部类的非静态成员
        }
    }
}
