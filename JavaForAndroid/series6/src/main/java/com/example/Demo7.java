package com.example;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by huangcl on 2016/12/7.
 */

/**
 * 实现Comparable接口
 */
public class Demo7 {


    public static void main(String[] args) {
        //方法一
        TreeSet<Person> treeSet = new TreeSet();
        treeSet.add(new Person("111"));
        treeSet.add(new Person("444"));
        treeSet.add(new Person("111"));
        treeSet.add(new Person("222"));
        treeSet.add(new Person("333"));

        System.out.println(treeSet);//[111, 222, 333, 444]
        //////////////////////////
        //方法二
        TreeSet<Animal> treeSet1 = new TreeSet(new MyCompartor());
        treeSet1.add(new Animal(111));
        treeSet1.add(new Animal(444));
        treeSet1.add(new Animal(111));
        treeSet1.add(new Animal(222));
        treeSet1.add(new Animal(333));

        System.out.println(treeSet1);//[111, 222, 333, 444]
    }

    //方法一
    static class Person implements Comparable {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(Object o) {
            return this.name.compareTo(((Person) o).name);
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

    //方法二
    static class Animal {
        private int age;

        public Animal(int age) {
            this.age = age;
        }


        @Override
        public String toString() {
            return this.age + "";
        }
    }

    static class MyCompartor implements Comparator<Animal> {

        @Override
        public int compare(Animal animal, Animal t1) {
            return animal.age - t1.age;
        }
    }
}
