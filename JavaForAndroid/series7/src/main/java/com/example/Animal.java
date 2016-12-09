package com.example;

/**
 * Created by huangcl on 2016/12/9.
 */
public class Animal {
     int age;
     String name;

    public Animal(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "[" + this.name + "\t" + this.age + "]";
    }
}
