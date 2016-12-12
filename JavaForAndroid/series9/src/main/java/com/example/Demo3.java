package com.example;

/**
 * Created by huangcl on 2016/12/12.
 */

public class Demo3 {
    public static void main(String[] args) {
        Thread2 thread2 = new Thread2("线程2");
        Thread1 thread1 = new Thread1(thread2,"线程1");
        thread1.start();

    }
}

class Thread1 extends Thread {
    private Thread2 thread2;

    public Thread1(Thread2 thread2, String name) {
        super(name);
        this.thread2 = thread2;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + "打印" + i);
            if (i == 5) {
                try {
                    thread2.start();
                    thread2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


class Thread2 extends Thread {
    public Thread2(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + "打印" + i);
        }
    }
}
