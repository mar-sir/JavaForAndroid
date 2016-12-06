package com.example;

/**
 * Created by huangcl on 2016/12/6.
 * <p>
 * <p>
 * /**
 */

/**
 * 多态第三种体现方式
 * 转型：
 * 向上转型：  子类类型向父类类型转换（自动--多态的体现）
 * 向下转型：  当子类中扩展的方法被调用时，需要将对象转成子类类型对象
 * <p>
 * 注意： 为了减少错误，在强转之前，可以通过instanceof判断对象是否为某一种类型
 */
public class Demo7 {
    public static void main(String[] args) {


        Animal2 a1 = new Cat1(); //向上转换，子类对象转成父类对象

        eat(a1);//猫吃鱼
        //小猫正在吃。。。。
        // 猫抓老鼠

        Animal2 a2 = newAnimal(Animal2.TYPE_DOG);
        eat(a2);//狗吃骨头
        //小狗正在吃。。。。
        //看家

    }

    public static void eat(Animal2 animal) { //第二种方式体现多态性
        animal.eat(); //调用是Animal实际对象的方法，实际对象可能是Cat、Dog的类对象

        //通过instanceof关键字判断对象是哪一种类型的对象
        if (animal instanceof Cat1) {
            System.out.println("小猫正在吃。。。。");


            //需要调用Cat中扩展的方法
            Cat1 c = (Cat1) animal; //向下转型，父类对象向子类对象转型
            c.catchMouse();

        } else {
            System.out.println("小狗正在吃。。。。");

            Dog1 d = (Dog1) animal;
            d.kanjia();
        }

    }

    //第三种体现多态性，根据类型创建某一动物的对象
    public static Animal2 newAnimal(int type) {
        if (type == Animal2.TYPE_CAT) {
            return new Cat1();
        } else if (type == Animal2.TYPE_DOG) {
            return new Dog1();
        }

        return null;
    }

}

abstract class Animal2 {
    public static final int TYPE_CAT = 1;
    public static final int TYPE_DOG = 2;

    public abstract void eat(); //虚方法
}

class Cat1 extends Animal2 {
    public void eat() {
        System.out.println("猫吃鱼");
    }

    public void catchMouse() {
        System.out.println("猫抓老鼠");
    }
}

class Dog1 extends Animal2 {
    public void eat() {
        System.out.println("狗吃骨头");

    }

    public void kanjia() {
        System.out.println("看家");
    }
}
