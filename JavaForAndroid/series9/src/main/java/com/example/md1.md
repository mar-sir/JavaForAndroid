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
                synchronized (object) {
                    while (true) {
        
                        System.out.println(Thread.currentThread().getName() + "要睡觉了，但我不会放掉object的锁");
                        try {
                            Thread.currentThread().sleep(50);//睡5秒
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
                thread1.start();//不一定就是线程1先执行,只是让它处于就绪状态.
                thread2.start();
            }
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series9/src/main/java/images/step2.png?raw=true)
等了两分钟，也没执行线程2，说明sleep不会释放锁.
* wait（）
对象的方法,在其他线程调用对象的notify或notifyAll方法前，导致当前线程等待。线程会释放掉它所占有的“锁标志”，从而使别的线程有机会抢占该锁。
      当前线程必须拥有当前对象锁。如果当前线程不是此锁的拥有者，会抛出IllegalMonitorStateException异常。
      唤醒当前对象锁的等待线程使用notify或notifyAll方法，也必须拥有相同的对象锁，否则也会抛出IllegalMonitorStateException异常。
      waite()和notify()必须在synchronized函数或synchronized　block中进行调用。如果在non-synchronized函数或non-synchronized　block中进行调用，
      虽然能编译通过，但在运行时会发生IllegalMonitorStateException的异常。
#####案例 wait()

        class WaitRunnable implements Runnable {
            private Object object = new Object();
        
            @Override
            public void run() {
                synchronized (object) {
                    while (true) {
                        System.out.println(Thread.currentThread().getName() + "将被等待阻塞");
                        try {
                            object.wait(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        
            }
        }
#####测试代码及结果
        
         WaitRunnable waitRunnable = new WaitRunnable();
         Thread thread1 = new Thread(waitRunnable, "线程1");
         Thread thread2 = new Thread(waitRunnable, "线程2");
         thread1.start();
         thread2.start();
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series9/src/main/java/images/step3.png?raw=true)
线程1 2 都能被调度,wait（）会释放锁.
* join（） 也好理解
举例：正当你排队买票的时候，突然有人插队到你前面了（而且不犯法），售票员只能先接待完插队者的所有需求，才轮到你。
#####案例join()
        
        public class Demo3 {
            public static void main(String[] args) {
                Thread2 thread2 = new Thread2("线程2");
                Thread1 thread1 = new Thread1(thread2,"线程1");
                thread1.start();
        
            }
        }
        
        class Thread1 extends Thread {
            private Thread2 thread2;
        
            public Thread1(Thread2 thread2, String name) {
                super(name);
                this.thread2 = thread2;
            }
        
            @Override
            public void run() {
                for (int i = 0; i <= 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "打印" + i);
                    if (i == 5) {
                        try {
                            thread2.start();
                            thread2.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        
        
        class Thread2 extends Thread {
            public Thread2(String name) {
                super(name);
            }
        
            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "打印" + i);
                }
            }
        }
#####结果
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series9/src/main/java/images/step4.png?raw=true)         
