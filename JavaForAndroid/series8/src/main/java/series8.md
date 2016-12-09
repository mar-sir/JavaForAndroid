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