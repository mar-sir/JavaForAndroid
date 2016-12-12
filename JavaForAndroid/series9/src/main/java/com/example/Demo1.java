package com.example;

import java.util.LinkedList;

public class Demo1 {
    public static void main(String[] args) {
        LinkedList<Egg> eggs = new LinkedList<>();
        Prodcucer prodcucer = new Prodcucer(eggs);
        Coustomer coustomer = new Coustomer(eggs);

        new Thread(prodcucer, "公鸡A").start();
        new Thread(prodcucer, "母鸡B").start();

        new Thread(coustomer, "吃货").start();
    }
}
