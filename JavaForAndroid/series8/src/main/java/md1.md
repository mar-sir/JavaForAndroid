###死锁
######一个线程拿到A资源对象锁后，还想要等着拿到B资源的对象锁，另一线程拿到B资源对象锁后，还想要等着拿到A资源的对象锁(吃着碗里的，看着锅里的)
####案例

        public class Demo7 {
        
            public static void main(String[] args) {
                MyRunnable myRunnable=new MyRunnable();
                Thread thread1=new Thread(myRunnable,"线程A");
                Thread thread2=new Thread(myRunnable,"线程B");
                thread1.start();;
                thread2.start();
            }
        
        }
        
        
        class MyRunnable implements Runnable {
            boolean flag = true;
            Object object1 = new Object();
            Object object2 = new Object();
        
            @Override
            public void run() {
                if (flag) {
                    flag = false;
                    synchronized (object1) {
                        System.out.println(Thread.currentThread().getName() + "得到资源A");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //又想得到资源B
                        synchronized (object2) {
                            System.out.println(Thread.currentThread().getName() + "想要得到B");
                        }
                    }
                } else {
                    flag = true;
                    synchronized (object2){
                        System.out.println(Thread.currentThread().getName() + "得到资源B");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //又想得到资源A
                        synchronized (object1) {
                            System.out.println(Thread.currentThread().getName() + "想要得到A");
                        }
                    }
                }
            }
        }
####运行结果
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series8/src/main/java/images/step7.png?raw=true)