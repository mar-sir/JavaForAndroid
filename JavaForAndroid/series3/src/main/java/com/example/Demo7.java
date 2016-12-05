package com.example;

/**
 * Created by huangcl on 2016/12/5.
 */

/**
 * static 修饰的成员
 * <p>
 * 1、 静态成员变量
 * <p>
 * 特点：
 * 1、 随着类的加载，会在方法区的静态区中开辟内存空间，初始化数据
 * 2、 可以通过类名直接访问，格式：类名.静态成员变量
 * 3、 一般用于存储所有类的共享数据
 * 2、 静态成员方法
 * 特点：
 * 1、静态方法中只能访问静态成员（不能使用this引用）
 * 2、非静态方法中可以访问静态成员（都能访问）
 * <p>
 * 3、静态成员变量与非静态成员变量的区别：
 * <p>
 * 1、 生命周期
 * <p>
 * 静态成员变量随着类的加载，在方法区的静态区中初始化，在程序结束时而消失
 * 成员变量是随着对象的初始化，在堆中创建与初始化，在对象被垃圾回收时而消失
 * <p>
 * 2、存储的特点
 * 静态成员变量是所有对象共享存储的数据
 * 成员变量是某一对象存储的数据
 * <p>
 * 3、访问方式
 * 静态成员变量可以通过类名直接访问，也可以对象访问
 * 成员变量只能通过对象来访问
 */
public class Demo7 {

    public static void main(String[] args) {
        Student1.sex="男"; //直接通过类名来访问类中的静态成员变量

        Student1 s1= new Student1();
        s1.setAge(30);
        s1.say();//hello,女,30

        s1.sex="不男不女"; //也可以通过类的对象访问类中的静态成员变量
        s1.say();//hello,女,30

        Student1 s2=new Student1();
        s2.setAge(25);
        s2.say();//hello,女,25
    }
}

class Student1{
    static String sex="男"; //静态成员变量

    private int age;

    public void setAge(int age){
        this.age=age;
    }

    public static void setSex(String sex){//静态成员方法
        Student1.sex=sex;//将方法中的局部变量的值 赋给静态成员变量

        //age=30; //在静态方法中不能访问非静态成员
    }

    public void say(){ //在成员方法中，是否可以访问静态成员变量

        setSex("女"); //在非静态方法中可以访问静态方法

        System.out.println("hello,"+sex+","+age);

    }
}
