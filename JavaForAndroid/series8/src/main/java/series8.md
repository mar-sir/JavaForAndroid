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
