package com.example;

/**
 * Created by huangcl on 2016/12/9.
 */

public class Demo11 {
    static class Student{
        private String name;
        public Student(String name){
            this.name=name;
        }

        @Override
        protected void finalize() throws Throwable {
            System.out.println(name+"内存空间即将回收--finalize--");
        }
    }

    public static void main(String[] args) {

        printMemery();
        new Student("aaa");

        new Student("aaa");

        new Student("aaa");

        new Student("aaa");
        printMemery();

        System.gc();//启动垃圾回收器的线程

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        printMemery();

    }

    //打印当前内存的大小（）
    static void printMemery(){
        Runtime runtime=Runtime.getRuntime();
        long max= runtime.maxMemory(); //单位：字节
        long free=runtime.freeMemory();
        System.out.println("当前内存的大小："+(max/1024)
                +" K字节, 可用大小："+(free/1024)+" K字节");
    }


}
