package com.example;

/**
 * Created by huangcl on 2016/12/12.
 */

public class Demo6 {
    // 数据类：资源
    static class Bank {
        private int money;

        public Bank(int money) {
            this.money = money;
        }

        // 为方法加同步锁,如果一个线程进入这个方法，则其它线程只有等到这个线程将方法执行完成之后，才能执行
        public synchronized void add(int money) {
            this.money += money;
            show();
        }

        // 取钱
        public synchronized void sub(int money) {
            if (this.money >= money) {
                this.money -= money;
                show();
            } else {
                System.out.println(Thread.currentThread().getName()
                        + "->当前的存款不足" + money);
            }
        }

        public void show() {
            System.out.println(Thread.currentThread().getName() + "->当前的存款："
                    + money);
        }
    }

    // 线程的任务类
    static class BankAddTask implements Runnable {
        private Bank bank;

        public BankAddTask(Bank bank) {
            this.bank = bank;
        }

        @Override
        public void run() {
            // 存入2000
            bank.add(2000);
        }
    }

    static class BankSubTask implements Runnable {
        private Bank bank;

        public BankSubTask(Bank bank) {
            this.bank = bank;
        }

        @Override
        public void run() {
            // 取出2000
            bank.sub(2000);
        }
    }

    public static void main(String[] args) {
        Bank bank = new Bank(1000);
        BankAddTask bankAddTask = new BankAddTask(bank); //存钱
        BankSubTask bankSubTask = new BankSubTask(bank); //取钱
        Thread t1 = new Thread(bankAddTask);
        t1.setName("存钱");
        t1.start();
        Thread t2 = new Thread(bankSubTask);
        t2.setName("取钱");
        t2.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bank.show();

    }


}
