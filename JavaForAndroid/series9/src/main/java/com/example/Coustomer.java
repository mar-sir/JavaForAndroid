package com.example;

import java.util.LinkedList;

/**
 * Created by huangcl on 2016/12/12.
 */

public class Coustomer implements Runnable {
    private LinkedList<Egg> eggs;

    public Coustomer(LinkedList<Egg> eggs) {
        this.eggs = eggs;
    }


    @Override
    public void run() {
        while (true) {
            synchronized (eggs) {
                //1. 判断篮子是否为空
                while (eggs.isEmpty()) {
                    System.out.println(Thread.currentThread().getName() + " 篮子空了 ");

                    try {
                        eggs.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //2. 消费产品--吃鸡蛋
                System.out.println("\t\t" + Thread.currentThread().getName() + " 消费了 " + eggs.pop());

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //唤醒等待线程
                eggs.notifyAll();
            }
        }
    }
}
