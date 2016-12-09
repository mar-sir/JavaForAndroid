package com.example;

/**
 * Created by huangcl on 2016/12/9.
 */

/**
 * 第二种创建线程的方式：
 * 1、 创建Runnable接口的实现类，并实现run()方法
 * 2、 创建Runnable实现类的对象
 * 3、创建Thread类的对象，并将Runnable实现类的对象，作为Thread的构造方法参数使用
 * 4、 执行Thread类对象的start()方法，来启动线程
 * <p>
 * 这种方式的好处： 可以在多个线程之间共享数据
 */
public class Demo2 {
    public static void main(String[] args) {
        //第二步：创建Runnable接口实现类的对象
        Bank bank= new Bank();

        //第三步：创建线程对象，并将第一步创建的对象作为线程的构造方法的参数使用
        Thread t1=new Thread(bank);
        Thread t2=new Thread(bank);

        //此时，四个线程的任务都是同一个对象（Runnable），即任务代码相同

        t1.setName("小鱼");
        t1.start();//第四步：启动线程
        t1.setPriority(Thread.MAX_PRIORITY);//设置线程的优先级，使得线程调度器优先考虑分配CPU资源

        t2.setName("SF");
        t2.start();


    }

}
//1、 创建Runnable接口的实现类，并实现run()方法
class Bank implements Runnable {
    //钱
    int moneyCount = 20;//共享数据
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (moneyCount > 0) {
                System.out.println(Thread.currentThread().getName() + "查看剩余金额：" + moneyCount--);
            } else {
                break;
            }
        }
    }
}
