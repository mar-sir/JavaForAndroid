package com.example;

/**
 * Created by huangcl on 2016/12/9.
 */

public class Cat extends Animal {

    public Cat(int age, String name) {
        super(age, name);
    }

    @Override
    public String toString() {
        return super.age + "";
    }
}
