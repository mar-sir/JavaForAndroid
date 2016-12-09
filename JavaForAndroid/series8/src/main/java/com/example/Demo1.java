package com.example;


/**
 * 多线程 Thread
 * 创建线程的方式（一）：
 * 1、 创建Thread的子类，并重写run()方法，此时run()就是线程要执行的任务
 * 2、 创建Thread的子类对象，并调用其start()方法，启动线程
 * 注： start()方法之后，线程不一定马上启动，只是进入了Runnable状态（就绪或可运行）
 */
public class Demo1 {


    public static void main(String[] args) {
        //创建线程
        PersonThread personThread1=new PersonThread("personThread1");
        PersonThread personThread2=new PersonThread("personThread2");

        //启动线程
        //personThread1.run();//此方法不能启动线程，只是线程体（任务代码）
        personThread1.start();
        personThread2.start();

    }

}


class PersonThread extends Thread {

    private String name;

    public PersonThread(String name) {
        this.name = name;
    }
    //注：InterruptedException异常不能在run()方法声明时通过throws抛出
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 20; i++) {
            //获取当前任务所在线程的名字 ，Thread-编号,编号从0开始
            System.out.println(Thread.currentThread().getName() + "-" + name + "-" + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

