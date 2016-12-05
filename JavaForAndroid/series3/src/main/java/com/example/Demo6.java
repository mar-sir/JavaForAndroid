package com.example;

/**
 * Created by huangcl on 2016/12/5.
 */

/**
 * 构造方法： 初始化成员变量
 * <p>
 * 命名： 类名，且无返回值
 * <p>
 * 注意：
 * 1、 构造方法只能用于初始化对象，不能被对象调用和类的成员方法中调用
 * 2、 默认构造方法为无参的，也是隐式构造方法（无需提供）
 * 3、 可以提供有参的构造方法，但会覆盖默认的构造方法，
 * 在初始化时，必须显示使用构造方法
 * <p>
 * 4、 两个构造方法之间可以相互调用，使用this()方式调用，但必须在第一行。
 */
public class Demo6 {

    public static void main(String[] args) {

        Teacher teacher = new Teacher();
        teacher.say();

        Teacher xiao = new Teacher("小小");
        xiao.say();

        //匿名对象：不存在一个引用指向这个对象
        new Teacher("shabi").say(); //当执行完成后，对象空间可以被垃圾回收器回收
    }
}

class Teacher {  //动物类
    private String name;

    public Teacher() { //无参的构造方法
        this("teacher"); //调用有参的构造方法，必须在第一行

        //name="teacher";
    }

    public Teacher(String name) { //带有参数的构造方法,默认情况下会覆盖无参的构造方法
        this.name = name;
    }

    public void say() {

        System.out.println("大家好，Teacher,我叫 " + name);
    }

}
