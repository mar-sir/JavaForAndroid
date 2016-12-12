###线程
###Demo1（线程的创建方式一）
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
####运行结果
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series8/src/main/java/images/step1.png?raw=true)
从运行结果我们可以看到，程序运行并不是顺序的，而是迸发的，还有就是你看不出线程的执行规律。
###Demo2(线程的创建方式二)
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
####运行结果
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series8/src/main/java/images/step2.png?raw=true)
###线程的运行状态
######线程分五大状态，新建、就绪、运行、阻塞（睡眠，等待、IO操作等导致）、死亡;
* 新建状态:
     当用new操作符创建一个线程时， 例如new Thread(r)，线程还没有开始运行，此时线程处在新建状态。 当一个线程处于新生状态时，程序还没有开始运行线程中的代码
* 就绪状态:
     一个新创建的线程并不自动开始运行，要执行线程，必须调用线程的start()方法。当线程对象调用start()方法即启动了线程，start()方法创建线程运行的系统资源，
   并调度线程运行run()方法。当start()方法返回后，线程就处于就绪状态。
       处于就绪状态的线程并不一定立即运行run()方法，线程还必须同其他线程竞争CPU时间，只有获得CPU时间才可以运行线程。因为在单CPU的计算机系统中，不可能同时运行多个线程，
       一个时刻仅有一个线程处于运行状态。因此此时可能有多个线程处于就绪状态。对多个处于就绪状态的线程是由Java运行时系统的线程调度程序(thread scheduler)来调度的。
* 运行状态
   当线程获得CPU时间后，它才进入运行状态，真正开始执行run()方法.
* 阻塞状态
     线程运行过程中，可能由于各种原因进入阻塞状态:
           1:线程通过调用sleep方法进入睡眠状态;
           2:调用wait方法，使线程处于等待状态;
           3:线程调用一个在I/O上被阻塞的操作，即该操作在输入输出操作完成之前不会返回到它的调用者;线程试图得到一个锁，而该锁正被其他线程持有;
            ....
      所谓阻塞状态是正在运行的线程没有运行结束，暂时让出CPU，这时其他处于就绪状态的线程就可以获得CPU时间，进入运行状态。
* 死亡状态
  1:run方法正常退出而自然死亡，
  2:一个未捕获的异常终止了run方法而使线程猝死。
          为了确定线程在当前是否存活着（就是要么是可运行的，要么是被阻塞了），需要使用isAlive方法。如果是可运行或被阻塞，这个方法返回true； 
          如果线程仍旧是new状态且不是可运行的， 或者线程死亡了，则返回false.
####图解线程运行状态
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series8/src/main/java/images/step3.png?raw=true)
####案例Demo3

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
###线程安全问题
######多个线程共享数据时，可以出现数据不一致性问题,由于操作共享数据的语句有多条，当线程执行中，由于Cpu被其它线程占用，使得操作停止，当再次获取Cpu时,
######数据可能已发生的变化，因此造成了数据不一致
###解决方式,加锁
 锁（对象锁）：Java对象中存一个标志("互斥锁")，保证对象在同一时刻，只能有一个线程去使用（访问）它 。
 
*  一个线程访问加锁的对象，其它线程只能等这个线程释放锁后 ，才能访问。
*  注： 加锁操作后，由于其它线程不停地判断锁是否释放（解锁），所以会影响执行效率
####加锁的方式
* 同步非静态方法：
  在方法声明时，增加synchronized修饰符，针对this对象加锁，如果一个线程访问了这个方法，其它线程在访问this对象的同步方法时，会进入等待状态，
  直到这方法执行完成后，才能访问。
* 同步静态方法：在静态方法声明时，增加synchronized修饰，针对.Class对象加锁，如果一个线程访问了这个方法，其它线程在访问这个类的同步静态方法时，
  会进入等待状态，直到这方法执行完成后，才能访问
* 同步代码块
####案例一Demo4(同步方法)
    
        public class Demo4 {
        
            //线程中访问的共享数据对象
            static class Test {
                static int nums = 10;
        
                //增加同步静态方法： 对Class类进行加锁，在同一时刻只有一个线程使用此方法
                static synchronized void sop() {
                    while (true) {
                        if (nums > 0) {
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println(Thread.currentThread().getName() + ":" + (nums--));
                        } else {
                            nums = new Random().nextInt(5);
                            break;
                        }
                    }
                }
        
                public void show() {
                    System.out.println(Thread.currentThread().getName() + ":" + (nums--));
                }
            }
        
            //定义线程的任务类
            static class MyRunnable implements Runnable {
        
                @Override
                public void run() {
                    Test.sop();
                }
            }
        
            public static void main(String[] args) {
                MyRunnable myRun = new MyRunnable();
                Thread t1 = new Thread(myRun);
                Thread t2 = new Thread(myRun);
                t1.start();
                t2.start();
        
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Test t = new Test();
                System.out.print("访问非同步的方法(main方法)：");
                t.show();
            }
        
        
        }
####运行结果
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series8/src/main/java/images/step4.png?raw=true)
####同步代码块
######存在同步代码区域，这个区域主要是共享数据的操作（多条语句）
####案例二Demo5(同步代码块)
    
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
####运行结果
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series8/src/main/java/images/step5.png?raw=true)
####案例三

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
####运行结果
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series8/src/main/java/images/step6.png?raw=true)