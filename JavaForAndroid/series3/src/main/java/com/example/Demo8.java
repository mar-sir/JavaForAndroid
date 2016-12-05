package com.example;

/**
 * Created by huangcl on 2016/12/5.
 */

/**
 * 静态代码块： static{  } ,主要作用：初始化静态成员变量
 * <p>
 * 静态代码块： 随着类的加载而执行的，只执行一次
 * <p>
 * 构造代码块： {  },优先于构造方法执行，主要是来初始化成员变量
 * <p>
 * 构造代码块：随着对象的创建而执行，每次创建对象都会执行
 * <p>
 * static修饰符什么时候使用？
 * 1、 在多个类之间共享成员变量时，需要将其改为static静态成员变量
 * 2、 如果一个成员方法中没有访问本类的成员变量，则将其改为static静态成员方法
 * <p>
 * 注：
 * 在程序优化中，建议不要过多地使用static,因为它会长时间地保留在内存中（方法区的静态区）
 * <p>
 * 对象初始化过程：
 * 1、加载类的字节码文件到jvm的方法区中
 * 2、为静态成员变量在静态区开辟内存空间，并初始化默认值
 * 3、加载静态代码块，初始化静态成员变量
 * 4、在堆中开辟空间（根据成员变量的大小），并默认初始化成员变量
 * 5、加载构造代码块，显示初始化成员变量
 * 6、加载构造方法，显示初始化成员变量
 * 7、将堆内存空间的首地址赋给对象的引用
 */
public class Demo8 {
    public static int age;

    static {
        System.out.println("静态代码块age-->" + age);

        //初始化静态成员变量，在类加载时执行
        age = 20;

        System.out.println("静态代码块age-->" + age);
    }

    { //构造代码块,可以被看成是一个无参的构造方法
        age += 1;
        System.out.println("构造代码块-->" + age);
    }

    public Demo8() {
        age += 1;
        System.out.println("构造方法中： age-->" + age);
    }

    public static void main(String[] args) {
        new Demo8();
        new Demo8();
        new Demo8();
        new Demo8();
    }
}


