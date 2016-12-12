package com.example;

import java.util.LinkedList;

/**
 * Created by huangcl on 2016/12/12.
 */

public class Prodcucer implements Runnable {
    private LinkedList<Egg> eggs;
    private int id = 1;//产品编号

    public Prodcucer(LinkedList<Egg> eggs) {
        this.eggs = eggs;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (eggs) {
                //1.判断篮子是否满了
                while (eggs.size() == 5) {
                    System.out.println(Thread.currentThread().getName() + "篮子已满..");
                    try {
                        eggs.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 2.生产
                eggs.push(new Egg(id++));
                System.out.println(Thread.currentThread().getName()+" 生产了鸡蛋 :"+eggs.peek());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //3. 唤醒消费者线程
                eggs.notifyAll();//唤醒所有等待线程，但这些线程只会转入就绪状态，并不确定哪一个线程获取cpu资源
            }
        }
    }


}
