package com.example;

/**
 * Created by huangcl on 2016/12/9.
 */

/**
 * 线程的状态：
 * 1、 创建状态-NEW
 * 2、 就绪状态--Runnable
 * 3、 运行状态--Running
 * 4、 阻塞状态--BLOCK(WAITING，TIMED_WAITING,BLOCK)
 * 5、 结束状态--TERMINATED
 */
public class Demo3 {
    public static void main(String[] args) {
        //创建子线程并启动
        ChildThread childThread= new ChildThread();
        childThread.setName("自定义线程名");


        //显示当前方法所在的线程名
        System.out.println(Thread.currentThread().getName()
                +"-"+Thread.currentThread().getId());

        System.out.println("ChildThread-->"+childThread.isAlive());

        childThread.start();//注：start()方法只能执行一次

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //显示某一线程是否还“存活”：boolean isAlive()
        System.out.println("ChildThread-->"+childThread.isAlive());
    }
}

class ChildThread extends Thread {
    @Override
    public void run() {
        //获取 当前的线程
        Thread t = Thread.currentThread();

        for (int i = 0; i < 10; i++) {
            System.out.println(t.getId() + "-" + t.getName() + "-" + t.isAlive() + ":" + i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
