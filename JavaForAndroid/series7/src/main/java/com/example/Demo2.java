package com.example;

import java.util.ArrayList;


/**
 * Created by huangcl on 2016/12/8.
 */

public class Demo2 {

    public static void main(String[] args) {
        ObjectFun objectFun = new ObjectFun();
        objectFun.setData(20);//存放Integer
        System.out.println((Float) objectFun.getData());//取

        objectFun.setData("hahaha");//存放String
        System.out.println((String) objectFun.getData());//取

        objectFun.setData(3.14f);//存放Float
        System.out.println((Float) objectFun.getData());//取
    }
}
