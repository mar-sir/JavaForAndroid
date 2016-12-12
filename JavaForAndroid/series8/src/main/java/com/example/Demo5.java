package com.example;

/**
 * Created by huangcl on 2016/12/12.
 */

public class Demo5 {
    static class MyTask implements Runnable {
        int nums = 10;

        @Override
        public void run() {
            while (true) {
                //增加同步代码块
                synchronized (this) {
                    if (nums > 0) {
                        try {
                            Thread.sleep(500);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + ":" + (nums--));
                    } else {
                        break;
                    }
                }

            }
        }
    }

    /**
     * 不出意外 应该是线程1首先获取到CPU资源，所以run执行完后，nums=0;t2刚开始运行就跳出了。
     * @param args
     */
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread t1 = new Thread(task);
        t1.start();

        Thread t2 = new Thread(task);
        t2.start();
    }

}
