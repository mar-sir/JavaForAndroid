package com.example;

/**
 * Created by huangcl on 2016/12/5.
 */

/**
 * java面向对象三大特性: 封装，继承，多态
 * <p>
 * 继承：extends
 * <p>
 * 特点： 通过继承，可以将父类的成员继承过来，使得两个存在父子关系
 */
public class Demo9 {

    public static void main(String[] args) {
        Person1 person1 = new Person1();
        person1.setName("小李子");
        person1.eat();//小李子,正在吃

        Student2 s2 = new Student2();
        s2.setName("贱人曾");
        s2.eat();//贱人曾,正在吃


        Worker worker = new Worker("xiaofeifei");
        worker.eat();//xiaofeifei,正在吃
    }
}

class Person1 {  //父类
    private String name;

    public Person1() {
    } //无参的构造方法

    public Person1(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(name + ",正在吃");
    }
}

class Student2 extends Person1 { //子类

}

class Worker extends Person1 {  //子类

    public Worker(String name) {
        super(name); //调用父类的构造方法，super()必须在第一行
    }
}