package com.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by huangcl on 2016/12/12.
 */

public class Demo4 {
    public static void main(String[] args) {

        Lock lock = new ReentrantLock();

        MyTask2 task = new MyTask2(lock);
        Thread t1 = new Thread(task, "售票点1");
        Thread t2 = new Thread(task, "售票点2");
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();

    }
}


/**
 * synchronized
 */
class MyTask implements Runnable {
    private int nums = 20;

    @Override
    public void run() {
        while (true) {

            synchronized (this) {
                if (nums > 0) {
                    System.out.println(Thread.currentThread().getName() + " 卖出第" + (nums--) + "张票");
                } else {
                    break;
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}

/**
 * Lock
 */
class MyTask2 implements Runnable {
    private int nums = 20;

    private Lock lock;

    public MyTask2(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

        while (true) {

            lock.lock(); //替换了synchronized(this)
            if (nums > 0) {
                System.out.println(Thread.currentThread().getName() + " 卖出第" + (nums--) + "张票");
                Thread.yield();
            } else {
                lock.unlock(); //线程执行完成后，必须解锁
                break;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        }
    }
}
