package com.example;

/**
 * Created by huangcl on 2016/12/6.
 */

/**
 * interface: 接口
 * <p>
 * 定义格式：  interface 接口名{  全局常量; 抽象方法;  }
 * <p>
 * 特点：
 * 1、 接口可以实现多继承
 * 2、 接口主要用于被实现，接口中的所有方法，在子类中必须全部实现
 * <p>
 * 在定义接口实现类的时，使用implements关键字，而且可以多实现
 * <p>
 * 扩展：
 * 类和类是继承关系
 * 类和接口是实现关系
 * <p>
 * 通过继承可以得到继承体系统中基本功能
 * 通过实现可以得到除继承之外的额外功能
 * <p>
 * 注： 一个可以存在继承关系同时也可以存实现关系
 */
public class Demo5 {

    public static void main(String[] args) {
        System.out.println(AllAnimalListener.type); //可以通过接口名直接访问全局变量//动物

        //AllAnimalListener all=new AllAnimalListener(); //接口不能创建对象

        Listener listener = new Animal();
        listener.walk();//动物在走...

        AllAnimalListener animalListener = new Animal();
        animalListener.run();//最佳最近调用原则：多态性中体现//动物在跑...
    }
}

interface Listener {
    //声明全局常量

    void walk();
}

interface CatListener {
    void talk();
}

//接口的多继承,因为所有接口中方法都没有实现，不会存在调用的不确定性问题
interface AllAnimalListener extends CatListener, Listener {
    static final String type = "动物";

    void run();
}

class Animal implements AllAnimalListener, CatListener, Listener { //一个类可实现多个接口

    //必须要实现或重写接口的方法 CatListener
    @Override
    public void talk() {
        System.out.println(type + "在说话...");
    }

    //必须要实现或重写接口的方法 Listener
    @Override
    public void walk() {
        System.out.println(type + "在走...");
    }

    //必须要实现或重写接口的方法 AllAnimalListener
    @Override
    public void run() {
        System.out.println(type + "在跑...");
    }
}