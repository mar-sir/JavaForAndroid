package com.example;

/**
 * Created by huangcl on 2016/12/12.
 */

public class Demo2 {

    public static void main(String[] args) {
       /* SleepRunnable runnable = new SleepRunnable();
        Thread thread1 = new Thread(runnable, "线程1");
        Thread thread2 = new Thread(runnable, "线程2");
        thread1.start();
        thread2.start();*/
        ///////////////
        WaitRunnable waitRunnable = new WaitRunnable();
        Thread thread1 = new Thread(waitRunnable, "线程1");
        Thread thread2 = new Thread(waitRunnable, "线程2");
        thread1.start();
        thread2.start();
    }
}

class SleepRunnable implements Runnable {
    private Object object = new Object();

    @Override
    public void run() {
        synchronized (object) {
            while (true) {

                System.out.println(Thread.currentThread().getName() + "要睡觉了，但我不会放掉object的锁");
                try {
                    Thread.currentThread().sleep(5000);//睡5秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}


class WaitRunnable implements Runnable {
    private Object object = new Object();

    @Override
    public void run() {
        synchronized (object) {
            while (true) {
                System.out.println(Thread.currentThread().getName() + "将被等待阻塞");
                try {
                    object.wait(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}