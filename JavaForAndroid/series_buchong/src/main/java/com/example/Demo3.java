package com.example;

/**
 * Created by huangcl on 2016/12/21.
 */

public class Demo3 {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder("?bdsalbdgs");

        //构造器模式，链式编程风格
        sb.append("dasd").append("&psd=")
                .append("123123").append("&phone=")
                .append("3424341423542");

        String url = sb.toString();

        System.out.println(url);

        //在头部插入" ?offset=1&"
        sb.insert(url.indexOf("?") + 1, "offset=1&");

        System.out.println(sb.toString());


    }
}
