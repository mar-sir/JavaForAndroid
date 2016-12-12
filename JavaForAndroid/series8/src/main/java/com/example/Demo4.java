package com.example;

import java.util.Random;

/**
 * Created by huangcl on 2016/12/12.
 */
public class Demo4 {

    //线程中访问的共享数据对象
    static class Test {
        static int nums = 10;

        //增加同步静态方法： 对Class类进行加锁，在同一时刻只有一个线程使用此方法
        static synchronized void sop() {
            while (true) {
                if (nums > 0) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + (nums--));
                } else {
                    nums = new Random().nextInt(5);
                    break;
                }
            }
        }

        public void show() {
            System.out.println(Thread.currentThread().getName() + ":" + (nums--));
        }
    }

    //定义线程的任务类
    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            Test.sop();
        }
    }

    public static void main(String[] args) {
        MyRunnable myRun = new MyRunnable();
        Thread t1 = new Thread(myRun);
        Thread t2 = new Thread(myRun);
        t1.start();
        t2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Test t = new Test();
        System.out.print("访问非同步的方法(main方法)：");
        t.show();
    }


}
