package com.example;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by huangcl on 2016/12/12.
 */

public class Demo5 {
    public static void main(String[] args) {
        //可以创建单线程池对象，同一时刻只有一个线程在执行
        ExecutorService service= Executors.newSingleThreadExecutor();

        //创建可以同时执行3个线程的线程池
        Executor executor=Executors.newFixedThreadPool(3);//固定线程池的大小

        //向线程池中提供线程任务，由线程池根据规则，创建线程并执行任务
        executor.execute(new PrintTask());
        executor.execute(new PrintTask());
        executor.execute(new PrintTask());
        executor.execute(new PrintTask());
        executor.execute(new PrintTask());
        executor.execute(new PrintTask());


    }

    static class PrintTask implements Runnable{
        @Override
        public void run() {
            for(int i=0;i<10;i++){
                System.out.println(Thread.currentThread().getName()+"--"+i);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
