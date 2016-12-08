package com.example;

/**
 * Created by huangcl on 2016/12/8.
 */

public class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "[" + this.name + "\t" + this.age + "]";
    }
}
