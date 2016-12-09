package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by huangcl on 2016/12/9.
 */

public class Demo5 {
    public static void main(String[] args) {

       /* List<Animal> animals1 = new ArrayList<>();
        animals1.add(new Animal(111, "s1"));
        animals1.add(new Animal(444, "s2"));
        animals1.add(new Animal(-222, "s3"));
        Collections.sort(animals1, new Comparator<Cat>() {
            @Override
            public int compare(Cat animal, Cat t1) {
                return animal.age - t1.age;
            }
        });
        System.out.println(animals1);*/


        List<Cat> animals2 = new ArrayList<>();
        animals2.add(new Cat(111, "s1"));
        animals2.add(new Cat(444, "s2"));
        animals2.add(new Cat(-222, "s3"));
        Collections.sort(animals2, new Comparator<Cat>() {
            @Override
            public int compare(Cat cat, Cat t1) {
                return cat.age - t1.age;
            }
        });
        System.out.println(animals2);


        List<Cat> animals3 = new ArrayList<>();
        animals3.add(new Cat(111, "s1"));
        animals3.add(new Cat(444, "s2"));
        animals3.add(new Cat(-222, "s3"));
        Collections.sort(animals3, new Comparator<Animal>() {
            @Override
            public int compare(Animal cat, Animal t1) {
                return cat.age - t1.age;
            }
        });
        System.out.println(animals3);
    }
}
