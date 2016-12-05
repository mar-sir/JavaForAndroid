package com.example;

/**
 * Created by huangcl on 2016/12/5.
 */

/**
 * final(C++ const)： 最终的，修饰类、成员方法、成员变量、局部变量
 * <p>
 * 注意：
 * 1、final修饰的类，不能被继承
 * 2、final修饰的方法，不能被重写
 * 3、final修饰的成员变量（局部变量），不能被修改
 * 4.String类就是final 修饰的类
 */
public class Demo3 {

    public static void main(String[] args) {
        Circle c = new Circle(5);
        System.out.println(String.format("%.2f", c.area()));
    }
}

final class Test1 { //这是一个最终的类

}

/*
class C_Test extends Test1{ //不能继承final类

}
*/

class Test2 {

    public final void area() { //final修饰的方法不能被子类重写

    }
}

class B_Test2 extends Test2 {
    final int a = 10;

    public void area(final int w, final int h) {
        //a=90;//变量不能被修改
        //w=w*h;

        final Test2 t2 = new Test2();

        //final 修饰的引用不能再指向其它对象
        //t2=new Test2();  //出错
    }
}

//求圆的面积 s=PI*r*r
class Circle {
    public static final double PI = 3.1415;

    private int radius; //半径


    public Circle(int radius) {
        this.radius = radius;
    }

    public double area() {
        return PI * radius * radius;
    }

}
