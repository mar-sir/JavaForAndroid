package com.example;

/**
 * Created by huangcl on 2016/12/6.
 */

/**
 * 接口中的多态
 * 接口与多态
 * <p>
 * 接口是一种引用数据类型，定义接口的引用指向到接口实现类对象， 则是接口体现多态的方式
 */
public class Demo8 {

    public static void main(String[] args) {
        Listen l1 = new Animal3(); //接口的多态

        l1.walk();//动物在走
        l1.music();//动物在唱歌

        Listen l2 = new Person();
        l2.walk();//人在走
        l2.music();// 人在唱歌
    }
}

interface Listen {
    void music();

    void walk();

}

class Animal3 implements Listen {


    @Override
    public void music() {
        System.out.println("动物在唱歌");
    }

    @Override
    public void walk() {
        System.out.println("动物在走");
    }
}

class Person implements Listen {

    @Override
    public void music() {
        System.out.println("人在唱歌");
    }

    @Override
    public void walk() {
        System.out.println("人在走");
    }
}