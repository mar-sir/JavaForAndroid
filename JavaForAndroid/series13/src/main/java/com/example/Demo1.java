package com.example;


import java.net.InetAddress;

public class Demo1 {

    public static void main(String[] args) {
        try {
            //获取本机IP信息
            InetAddress localIP = InetAddress.getLocalHost();
            //IP地址
            System.out.println(localIP.getHostAddress());

            //获取本机器的主机名
            System.out.println("host-->" + localIP.getHostName()); //localhost

            //获取百度的ip地址
            InetAddress baidu = InetAddress.getByName("www.baidu.com");
            System.out.println("baidu-ip-->" + baidu.getHostAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
