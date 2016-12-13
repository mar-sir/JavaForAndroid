package com.example;

/**
 * Created by huangcl on 2016/12/13.
 */

/**
 * 装饰者案例
 */
public class Demo6 {

    public static void main(String[] args) {
        System.out.println("=====================动物化妆========================");
        Animal animal = new Animal();
        animal.dressing();
        System.out.println("=====================男人化妆========================");
        Man man = new Man(animal);
        man.dressing();
        System.out.println("=====================女人化妆========================");
        Woman woman = new Woman(animal);
        woman.dressing();
        System.out.println("=====================人妖化妆========================");
        Woman woman1 = new Woman(man);
        woman1.dressing();
    }
}
