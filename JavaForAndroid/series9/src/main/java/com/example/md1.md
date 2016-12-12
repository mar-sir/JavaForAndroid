###Lock 锁
######做着和synchronized同样的事.
####案例 synchronized和Lock对比

    public class Demo4 {
        public static void main(String[] args) {
    
            Lock lock = new ReentrantLock();
    
            MyTask2 task = new MyTask2(lock);
            Thread t1 = new Thread(task, "售票点1");
            Thread t2 = new Thread(task, "售票点2");
    
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
                        System.out.println(Thread.currentThread().getName() + " 卖出第 " + (nums--) + "张票");
                    } else {
                        break;
                    }
    
                    try {
                        Thread.sleep(500);
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
                    System.out.println(Thread.currentThread().getName() + " 卖出第 " + (nums--) + "张票");
                } else {
                    lock.unlock(); //线程执行完成后，必须解锁
                    break;
                }
    
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        }
    }
####结果
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series9/src/main/java/images/step5.png?raw=true)
线程2是有机会运行的，这里它不运行我也没办法。
###线程池
####线程池的创建方式
* newFixedThreadPool（int n）创建一个指定工作线程数量的线程池，每当提交一个任务就创建一个工作线程，如果工作线程数量达到线程池初始的最大数，则将提交的任务存入到池队列中。

* 2、newCachedThreadPool 创建一个可缓存的线程池。这种类型的线程池特点是： 
          1).工作线程的创建数量几乎没有限制(其实也有限制的,数目为Interger. MAX_VALUE), 这样可灵活的往线程池中添加线程。 
          2).如果长时间没有往线程池中提交任务，即如果工作线程空闲了指定的时间(默认为1分钟)，则该工作线程将自动终止。终止后，如果你又提交了新的任务，则线程池重新创建一个工作线程。
          
*    3、newSingleThreadExecutor创建一个单线程化的Executor，即只创建唯一的工作者线程来执行任务，如果这个线程异常结束，会有另一个取代它，保证顺序执行(我觉得这点是它的特色)。
单工作线程最大的特点是可保证顺序地执行各个任务，并且在任意给定的时间不会有多个线程是活动的 

*    4、newScheduleThreadPool创建一个定长的线程池，而且支持定时的以及周期性的任务执行，类似于Timer。

####案例
    
    public class Demo5 {
        public static void main(String[] args) {
            //可以创建单线程池对象，同一时刻只有一个线程在执行
            ExecutorService service= Executors.newSingleThreadExecutor();
    
            //创建可以同时执行3个线程的线程池
            Executor executor=Executors.newFixedThreadPool(10);//固定线程池的大小
    
            //向线程池中提供线程任务，由线程池根据规则，创建线程并执行任务
            // 存放任务，而不是Thread
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
