package com.example;

/**
 * Created by huangcl on 2016/12/6.
 */

/**
 * 对象的多态性： 多种形态，父类类型的引用指向子类对象
 * <p>
 * 前提： 存在继承或实现关系
 * <p>
 * class 动物{
 * public void eat(){}
 * }
 * <p>
 * class 猫 extends 动物{
 * <p>
 * }
 * <p>
 * 常态：  猫看成是猫   猫 c=new 猫();
 * 多态：  猫是动物     动物 d=new 猫(); //第一种方式体现多态
 * <p>
 * <p>
 * void 方法名（动物 d){  //第二种方式体现多态
 * d.eat();
 * <p>
 * }
 * <p>
 * 动物 方法名(int type){ //第三种方式体现多态
 * if(type==1){
 * return new 猫();
 * }
 * <p>
 * return new 狗();
 * }
 * <p>
 * 多态的弊端： 只能使用父类中定义的方法，并且子类必须重写父类中的方法
 * <p>
 * 多态的好处： 提高程序的扩展性，前期定义的功能（方法）可以被后期事物实现（使用）
 * 1.有继承或者实现接口的关系
 * 2.重写或者实现父类（接口）的方法
 * 3.父类指针指向子类对象
 */
public class Demo6 {
    public static void main(String[] args) {
        Cat cat = new Cat();//常态
        cat.eat();//猫吃鱼
        cat.catchMouse();//猫抓老鼠

        Animal1 a1 = new Cat(); //多态，第一种方式
        //a1.eat();
        //a1.catchMouse();//出错，因为父类中没有声明此方法

        Animal1 a2 = new Dog();//多态
        //a2.eat();

        eat(a1);//猫吃鱼
                //小猫正在吃。。。。
        eat(a2);//狗吃骨头
                //小狗正在吃。。。。
    }

    public static void eat(Animal1 animal) { //第二种方式体现多态性
        animal.eat(); //调用是Animal实际对象的方法，实际对象可能是Cat、Dog的类对象

        //通过instanceof关键字判断对象是哪一种类型的对象
        if (animal instanceof Cat) {
            System.out.println("小猫正在吃。。。。");
        } else {
            System.out.println("小狗正在吃。。。。");
        }

    }
}


abstract class Animal1 {
    public abstract void eat(); //虚方法
}

class Cat extends Animal1 {
    public void eat() {
        System.out.println("猫吃鱼");
    }

    public void catchMouse() {
        System.out.println("猫抓老鼠");
    }
}

class Dog extends Animal1 {
    public void eat() {
        System.out.println("狗吃骨头");

    }

    public void kanjia() {
        System.out.println("看家");
    }
}