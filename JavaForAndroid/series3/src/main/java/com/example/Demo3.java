package com.example;

/**
 * Created by huangcl on 2016/12/5.
 */

/**
 * 类的定义格式：
 * class 类名{
 * <p>
 * 声明成员变量；
 * 声明成员方法；
 * }
 * <p>
 * 类的命名规范：
 * 1、第一个字母要大写;
 * 2、“见名知意”，名字有一定的意义,Student、Person、Car
 * 3、名字中具有一定功能性的描述，如OrderService,StudentManager
 */
public class Demo3 {
    public static void main(String[] args) {
        People people = new People();
        people.name = "楼主";
        people.eat();//楼主正在吃
    }

}

//这也说明一个.java文件能有多个类,但只能有一个public修饰的类
class People {
    String name;

    public void eat() {
        System.out.println(this.name + "正在吃");
    }
}
