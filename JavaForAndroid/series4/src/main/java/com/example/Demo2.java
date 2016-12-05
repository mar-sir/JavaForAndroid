package com.example;

/**
 * Created by huangcl on 2016/12/5.
 */

/**
 * 方法的重写：存在继承关系，方法名、参数、返回数据类型都与父类中方法名和参数相同，
 * 访问权限必须大于或等父类的访问权限
 * <p>
 * 注意：
 * 1. 父类的私有方法不能被重写
 * 2. 静态只能覆盖静态
 * <p>
 * this和super的使用：
 * <p>
 * this 代有当前类的引用，可以通过this.成员形式来访问成员变量和方法
 * 可以通过this() 来调用本类的其它构造方法，但必须在第一行
 * <p>
 * super:代表是父类的数据空间，并不是一个引用，因此没有对象可以指向
 * 可以通过 super.父类成员来访问父类的成员变量和成员方法
 * 也可以通过super()来调用父类的构造方法，如果父类不存在无参的构造方法，
 * 在子类中必须调用super(),来指明初始化父类成员变量的构造方法，而且必须在第一行
 * <p>
 * 注： super() 和 this()不能同时出现，this和super不能出现静态成员方法中
 */
public class Demo2 {
    public static void main(String[] args){
        Parent parent=new Child(); //多态
        parent.say("您好");//父类说...您好
                          //子类说...您好

        parent.print(); //父类打印...
    }
}

class Parent {

    public void say(String msg) {
        System.out.println("父类说..." + msg);
    }

    public static void print() {
        System.out.println("父类打印...");
    }

}


class Child extends Parent {

    //重写父类的方法可以扩展功能
    public void say(String msg) {
        super.say(msg); //调用父类的成员方法

        System.out.println("子类说..." + msg);
    }

    public static void print() { //重写父类的静态方法时，只能以静态的方式覆盖
        //super.print(); //this和super不能出现在静态成员方法中
        System.out.println("子类打印...");
    }

}

