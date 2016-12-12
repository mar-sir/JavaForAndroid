package com.example;

/**
 * Created by huangcl on 2016/12/12.
 */

public class Demo11 {

    public static void main(String[] args) {
        Message msg = new Message();

        //创建生产者对象
        Producer p = new Producer(msg);

        //创建消费者对象
        Consumer c = new Consumer(msg);

        //在Thread的构造方法中，可以指定线程的名字
        new Thread(p, "生产者").start(); //启动生产者线程
        new Thread(c, "消费者").start(); //启动消费线程

        //快速复制一行： ctrl+alt+向下方向键

    }
}

//产品--共享数据（资料）
class Message {
    String title;
    String content;
    boolean flag = true; //true :生产， false: 消费

    @Override
    public String toString() {
        return title + "-" + content;
    }
}

//生产线--生产者
class Producer implements Runnable {
    private Message msg;

    public Producer(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        while (true) {

            synchronized (msg) {

                //1. 判断是否为生产线
                while (!msg.flag) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " 等待消费");
                        msg.wait(); //不是生产线，等待消费者进行消费

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                //2. 生产产品
                int i = (int) (Math.random() * 50);
                if (i % 2 == 0) {
                    msg.title = "穷";
                    msg.content = "喝粥";
                } else {
                    msg.title = "富";
                    msg.content = "吃肉";
                }
                System.out.println(Thread.currentThread().getName() + " 生产了 " + msg);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //3. 唤醒消费者
                msg.notify();


                //4. 改变标识
                msg.flag = false; //要地进行消费
            }
        }
    }
}

//消费线--消费者
class Consumer implements Runnable {
    private Message msg;

    public Consumer(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (msg) {
                //1. 判断是否为消费线
                while (msg.flag) {
                    System.out.println("\t\t" + Thread.currentThread().getName() + " 等待生产。。。");
                    try {
                        msg.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                //2. 开始消费
                System.out.println("\t\t" + Thread.currentThread().getName() + " 消费了 " + msg);
                msg.title = null;
                msg.content = null;

                //3. 唤醒生产者，再生产
                msg.notify();

                //4. 修改标识为生产线
                msg.flag = true;
            }
        }
    }
}


