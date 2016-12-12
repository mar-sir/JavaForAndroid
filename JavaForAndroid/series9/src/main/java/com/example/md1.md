###线程模拟生产消费
####案例
* 产品类
           
        /**
         * 产品
         */
        public class Egg {
            int id;
        
            public Egg(int id) {
                this.id = id;
            }
        
            @Override
            public String toString() {
                return "->" + id;
            }
        }
* 生产者类

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
* 消费者类

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
* 运行类

        public class Demo1 {
            public static void main(String[] args) {
                LinkedList<Egg> eggs = new LinkedList<>();
                Prodcucer prodcucer = new Prodcucer(eggs);
                Coustomer coustomer = new Coustomer(eggs);
        
                new Thread(prodcucer, "公鸡A").start();
                new Thread(prodcucer, "母鸡B").start();
        
                new Thread(coustomer, "吃货").start();
            }
        }
####运行结果
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series9/src/main/java/images/step1.png?raw=true)
###sleep(),wait(),join(),yield(),interrupt()方法简介

* sleep()
是Thread类的一个静态方法,在指定时间内让当前正在执行的线程暂停执行，但不会释放“锁标志”。
#####案例 sleep

        class SleepRunnable implements Runnable {
            private Object object = new Object();
        
            @Override
            public void run() {
                while (true) {
                    synchronized (object) {
                        System.out.println(Thread.currentThread().getName() + "要睡觉了，但我不会放掉object的锁");
                        try {
                            Thread.sleep(5000);//睡5秒
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        
            }
        }
#####测试代码及结果
        
         public static void main(String[] args) {
                SleepRunnable runnable = new SleepRunnable();
                Thread thread1 = new Thread(runnable, "线程1");
                Thread thread2 = new Thread(runnable, "线程2");
                thread1.start();
                thread2.start();
            }
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series9/src/main/java/images/step2.png?raw=true)
