package com.example;

/**
 * Created by huangcl on 2016/12/6.
 */

/**
 * abstract:  抽象的，包含抽象方法的类叫抽象类
 * <p>
 * 说明： 抽象类也是一个类，只不过没有足够的信息来描述某一事物行为的方法
 * <p>
 * 特点：
 * <p>
 * 1、抽象类不能创建对象，因为其中包含了未实现的抽象方法
 * 2、继承抽象类的子类，如果没有实现抽象方法，则这个类也是抽象类
 * <p>
 * <p>
 * 思考：
 * 1、 抽象类一定是父类？ 一定是父类
 * 2、 抽象类是否有构造方法?  有构造方法，用于初始化类中的成员变量
 * <p>
 * 抽象类和普通类区别：
 * 相同点：  都是类，可以被继承
 * 不同点：
 * 抽象类不可以创建对象，普通类可以创建对象
 * 抽象类可以包含抽象方法，普通类不能包含抽象方法
 * <p>
 * abstract不能与以下关键字组合使用：
 * <p>
 * final: final修饰的类不能被继承，abstract类必须要被继承(不然没意义)
 * static:  静态方法可以直接通过类名被调用，抽象方法不能被调用
 * private: 私有方法不能被重写，抽象方法必须被重写
 */
public class Demo4 {

    public static void main(String[] args) {

       //Circle1 c=new Circle1(6); //不能创建抽象类的对象

        Rectangle r=new Rectangle(8,10);

        System.out.println(r.area());//80.0
    }
}
abstract class Shape{
    public abstract double area();
}

abstract class Circle1 extends Shape{
    public static final double PI=3.14;
    private int radius;

    public Circle1(){}
    public Circle1(int radius){ this.radius=radius;}

    public  abstract double area();
}

class Rectangle extends Shape{
    private int width;
    private int height;

    public Rectangle(int width,int height){
        this.width=width;
        this.height=height;
    }

    public double area(){ //实现抽象方法
        return width*height;
    }
}

abstract class  Test3{ //注：抽象类中可以不存在抽象方法

}

class C_Test3 extends Test3{

}