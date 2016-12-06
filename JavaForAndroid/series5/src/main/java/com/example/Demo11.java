package com.example;

/**
 * Object 最原始的基类
 * <p>
 * 主要方法：
 * String toString()
 * boolean equals(Object obj)
 * int hashCode(); //返回对象的哈希码
 * notify();
 * notifyAll();
 */
public class Demo11 {
    public static void main(String[] args){
        Person p1=new Person("张三",23);
        Person p2=new Person("李四",23);

        System.out.println(p1);
        System.out.println(p2);

        System.out.println(p1.equals(p2));
        System.out.println(p1.isSampleAge(p2));

        System.out.println("王五".equals("王五"));

        System.out.println("王五".hashCode());

        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());

    }
}

class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean equals(Object obj) { //重写Object类的方法
        if (obj instanceof Person) {
            Person p = (Person) obj;

            return p == this;
        }

        return false;
    }

    //判断两个人是否同龄
    public boolean isSampleAge(Person person) {
        return person.age == this.age;
    }

    public String toString() { //重写Object类的方法
        return "[name=" + name + ",age=" + age + "]";
    }

    public int hashCode() {
        return 1;
    }
}
