package com.example;

/**
 * Created by huangcl on 2016/12/5.
 */

/**
 * Java面向对象的三大特征： 封装、继承、多态
 * <p>
 * 封装：向外部提供有用的成员（属性、方法）
 * <p>
 * 成员的四个访问权限：
 * private   私有的，只能在类的内部访问
 * [default] 默认的，可以在同一个包下访问
 * protected 受保护的，可以在类的内部和子类中访问
 * public    公有的，可以在任一地方访问
 * <p>
 * <p>
 * this:  指向当前类对象，当出现局部变量与成员变量重命名时，
 * 需要使用this来访问成员变量
 */

public class Demo5 {

    public static void main(String[] args) {

        Person person=new Person(); //调用了默认的构造方法（无参的）
        //stu.name="张三";  //私有的成员是不能通过对象访问
        person.setName("张三");
        person.setAge(30);

        person.sex="女";

        System.out.println("Person: "+person.toString());//Person: [name=张三,age=30,sex=女]
    }
}

class Person {  //数据实体类

    private String name;  //默认值为null
    private int age;   //默认值为0

    String sex = "男";

    //方法名的命名方式为驼峰命名方法（setXxx,getXxx）
    public void setName(String name) {
        this.name = name; //this.name代表的是成员变量
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    //实现将对象转成字符串的方法
    public String toString() {
        return "[name=" + name + ",age=" + age + ",sex=" + sex + "]";
    }
}
