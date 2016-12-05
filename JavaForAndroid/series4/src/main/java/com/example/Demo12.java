package com.example;

/**
 * Created by huangcl on 2016/12/5.
 */

public class Demo12 {

    public static void main(String[] args) {

        BreadMachine bm = BreadMachine.getInstance();
        for (int i = 0; i < 10; i++) {
            bm.create();
        }

        BreadMachine bm2 = BreadMachine.getInstance();
        for (int i = 0; i < 10; i++) {
            bm2.create();
        }

    }

}

class BreadMachine {
    private static BreadMachine bm = null;

    private int counter; //默认为0

    private BreadMachine() {

    }

    //单例模式，获取当前类的对象
    public static BreadMachine getInstance() {
        if (bm == null) {
            bm = new BreadMachine();//创建对象
        }

        return bm;
    }

    public void create() {
        counter++;
        System.out.println(String.format("正在制作第%d个面包", counter));
    }

}