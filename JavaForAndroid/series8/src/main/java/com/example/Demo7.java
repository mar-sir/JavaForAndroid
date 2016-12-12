package com.example;

/**
 * Created by huangcl on 2016/12/12.
 */

/**
 * 死锁
 */
public class Demo7 {

    public static void main(String[] args) {
        MyRunnable myRunnable=new MyRunnable();
        Thread thread1=new Thread(myRunnable,"线程A");
        Thread thread2=new Thread(myRunnable,"线程B");
        thread1.start();;
        thread2.start();
    }

}


class MyRunnable implements Runnable {
    boolean flag = true;
    Object object1 = new Object();
    Object object2 = new Object();

    @Override
    public void run() {
        if (flag) {
            flag = false;
            synchronized (object1) {
                System.out.println(Thread.currentThread().getName() + "得到资源A");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //又想得到资源B
                synchronized (object2) {
                    System.out.println(Thread.currentThread().getName() + "想要得到B");
                }
            }
        } else {
            flag = true;
            synchronized (object2){
                System.out.println(Thread.currentThread().getName() + "得到资源B");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //又想得到资源A
                synchronized (object1) {
                    System.out.println(Thread.currentThread().getName() + "想要得到A");
                }
            }
        }
    }
}
