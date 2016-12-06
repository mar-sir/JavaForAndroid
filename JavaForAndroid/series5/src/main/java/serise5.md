###Demo1(内部类)
    /**
     * 内部类： 定义在类的内部，内部类所在的类称之为外部类
     * class 外部类的名{
     * <p>
     * class 内部类的名{
     * <p>
     * <p>
     * }
     * }
     */
    public class Demo1 {
        public static void main(String[] args) {
            Outer outer = new Outer();
            outer.run();//Inner say()-->40
            //Inner say() Outer.this.num-->10
    
            //创建内部类的对象
            Outer.Inner inner = outer.new Inner();
            inner.say();//Inner say()-->40
            //Inner say() Outer.this.num-->10
    
            //创建静态成员的内部类对象
            Outer.Inner_2 inner2 = new Outer.Inner_2();
            inner2.say();//inner 2 say()
    
        }
    }
    
    class Outer {
        int num = 10; //外部类的成员变量
    
        //内部类作为外问部的成员，如果要访问内部类，需要通过类的对象访问
        class Inner {
            public static final int IP = 100;
    
            int num = 40;
    
            public void say() {
    
                System.out.println("Inner say()-->" + num);
    
                System.out.println("Inner say() Outer.this.num-->" + Outer.this.num);//在内部类中可以访问其所在外部类的成员
            }
        }
    
        public void run() {
            Inner inner = new Inner();
            inner.say();
        }
    
        //外部类的静态成员
        static class Inner_2 {
    
            public static void say() {
                System.out.println("inner 2 say()");
                //System.out.println("inner 2 say()"+num);//出错：静态内部类不能访问外部类的非静态成员
            }
        }
    }
###Demo2(匿名内部类)
    /**
     * 匿名内部类
     * 定义在类的成员方法中的内部类
     */
    public class Demo2 {
    
        public static void main(String[] args) {
            Outer1 outer = new Outer1();
            outer.fun();//fun->Inner say()100
        }
    }
    
    class Outer1 {
    
        public void fun() {
            final int num = 100; //注：在jdk 1.8之后，局部内部类访问的局部变量是有效的
    
            //声明局部内部类
            class Inner {
                public void say() {
                    //局部内部类中，如果要访问局变量时，则局部变量需要final修饰
                    System.out.println("fun->Inner say()" + num);
                }
            }
    
            Inner inner = new Inner();
            inner.say();
    
        }
    
    }
###Demo3(匿名内部类实现接口)
    /**
     * 匿名内部类实现接口
     * 使用场景:你叫舍友给你收一下衣服，收完之后给你说一声；
     * 建模: CallBack(收完衣服的结果) Sheyou(舍友)  You(你)
     * 接口回调
     */
    public class Demo3 {
        public static void main(String[] args) {
            You you = new You();//创建一个你
            Sheyou leifeng = new Sheyou("雷锋");  //创建一个雷锋同学
            you.requestShouyifu(leifeng);//委托雷锋舍友收衣服
        }
    }
    
    
    interface CallBack {
        void result(String msg);
    }
    
    class You  {
        /**
         * 请求舍友帮你收衣服(客气点)
         *
         * @param sheyou
         */
        public void requestShouyifu(Sheyou sheyou) {
            System.out.println(sheyou.name + "请帮我收一下衣服，要下雨了");
            sheyou.shouyifu(new CallBack() {
                @Override
                public void result(String msg) {
                    System.out.println("我知道" + msg);
                }
            });
        }
    
    }
    
    class Sheyou {
        String name;
    
        public Sheyou(String name) {
            this.name = name;
        }
    
        //收衣服
        public void shouyifu(CallBack callBack) {
            System.out.println(this.name + "收衣服中...");
            callBack.result("衣服已经收好了。" + "\t" + this.name + "收的.");
        }
    }
    
####运行结果
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series4/src/main/java/images/step1.png?raw=true)
###Demo4(异常)
    /**
     * 异常： 在程序运行时发生了不正常的情况，此时由系统中断程序的运行
     * <p>
     * 异常类的由来： 当程序发生不正常情况时，Java中提供一个类描述这个不正常情况的信息，
     * 包含异常信息、异常类名、异常的位置
     * <p>
     * 异常分类：
     * Error 错误： 由系统原因造成的，一般是系统资源分配冲突时或系统崩溃等原因
     * 这一类Error错误，对于程序员来说是无法处理的
     * <p>
     * Exception： 由于程序原因造成的，一般是运算、I/O读取等原因
     * 这一类Exception异常，可以进行处理
     * <p>
     * Java中异常类的体系：
     * <p>
     * Throwable
     * Error:
     * Exception
     * RuntimeException :非受控异常（运行时异常）
     * <p>
     * 在Java中如何处理异常
     * <p>
     * 1、捕获异常处理
     * <p>
     * 格式1：
     * try{
     * 可能出现异常的语句;
     * }catch(异常类型 对象名){
     * 处理异常语句;
     * }
     * <p>
     * 2、抛出异常
     * <p>
     * 1) 声明方法时抛出异常
     * <p>
     * 方法名() throws 异常类名[,异常类名,异常类名] {}
     * <p>
     * 2）在方法中抛出异常
     */
    public class Demo4 {
    
        static int divide(int a, int b) throws ArithmeticException {
            int result = 0;
    
            result = a / b; //当发生异常时，向调用者抛出异常
    
            //当异常从某一位置抛出后，其下的语句不会被执行
            System.out.println("计算结果完成....");
    
            return result;
        }
    
    
        public static void main(String[] args) {
            //输入两个数
            Scanner scanner = new Scanner(System.in);
    
            //将数字字符串转成数值类型
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            scanner.close();
            try {
                int r = divide(a, b);
    
                System.out.println(r);
    
            } catch (Exception e) { //可以处理所有异常，即Exception类是所有异常的父类
                e.printStackTrace();
            }
    
    
        }
    }
####运行结果
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series5/src/main/java/images/step1.png?raw=true)
###Demo5
    /**
     * 处理多个异常的格式:
     * <p>
     * try{
     * <p>
     * }catch(异常类名 对象名){
     * <p>
     * }catch(...){
     * <p>
     * }catch(...){
     * <p>
     * }
     * <p>
     * 注意：处理多个异常类时，异常的子类所在的catch语句要放在最上面
     */
    public class Demo5 {
        static class Person {
            String name;
    
            public Person(String name) {
                this.name = name;
            }
    
            public String toString() {
                return "[name=" + name + "]";
            }
        }
    
        static void sub(int a, int b, int[] nums, Person p) {
    
            try {
                int r = a / b;//此行如果出现了异常，则下行代码不会执行
                r = nums[5] / 9;
                System.out.println(p);
            } catch (ArithmeticException e) {
                System.out.println("除数为0了...");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("数组的索引值越界了,数组的长度小于6...");
            } catch (NullPointerException e) {
                System.out.println("访问的对象是null");
            } catch (Exception e) {  //异常类的父类所处于的catch语句要放在最后
                e.printStackTrace();
            }
    
        }
    
        public static void main(String[] args) {
            int[] nums = {9, 10, 8, 66, 22, 109};
    
            sub(10, 2, nums, new Person("张三"));
    
            sub(10, 0, new int[3], null);
    
        }
    }
###Demo6
    /**
     * 抛出多个异常的格式:
     * <p>
     * 在方法声明的后边，使用 throws 异常类型列表 语句
     * <p>
     * <p>
     * 在方法中抛出异常：
     * <p>
     * throw new RuntimeException("异常信息");
     */
    public class Demo6 {
    
        static class Person {
            String name;
    
            public Person(String name) {
                this.name = name;
            }
    
            public String toString() {
                return "[name=" + name + "]";
            }
        }
    
        //抛出多个异常，抛给调用者处理
        static void sub(int a, int b, int[] nums, Person p)
                throws ArithmeticException, IndexOutOfBoundsException, NullPointerException {
    
            int r = a / b;//此行如果出现了异常，则下行代码不会执行
            r = nums[5] / 9;
            //System.out.println(p.toString());
    
        }
    
        static void div(int a, int b) {
            if (b == 0) {
                //抛出异常
                throw new RuntimeException("除数为0");
            }
        }
    
        public static void main(String[] args) {
            int[] nums = {9, 10, 8, 66, 22, 109};
    
            //sub(10,2,nums,new Person("张三"));
    
            try {
                sub(10, 4, new int[7], null);
    
                div(9, 0);
    
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("数组长度小于6");
            } catch (IndexOutOfBoundsException e) {  //父类的异常处理放在子类异常处理的下方
                System.out.println("索引越界。。。");
            } catch (Exception e) {
                e.printStackTrace();
            }
    
        }
    
    }
###Demo7
    /**
     * 处理异常的格式3：
     * <p>
     * try{
     * //资源分配的语句
     * <p>
     * }catch(...){
     * <p>
     * }finally{
     * //肯定执行的语句，一般是释放资源的语句，
     * //注： 如果try语句中包含return 语句，finally语句在return之前执行
     * }
     */
    public class Demo7 {
    
    
        static class Student{
            private String name;
            public Student(String name){
                this.name=name;
            }
    
            public int div(int a,int b){
                return a/b;
            }
    
            public String toString(){
                return name;
            }
        }
    
        public static void main(String[] args){
            Student s=new Student("张三");
    
            try{
                s.div(10,0);
    
                return ;
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                System.out.println(s.toString());
    
                s=null;//s所指向的堆内存变是垃圾了，可以被gc回收
    
                System.out.println("回收资源...");
            }
        }
    }
###Demo8(自定义异常)
    /**
     * 自定义异常类：
     * <p>
     * 1、创建类，并继承Exception
     * 2、提供构造方法，可以调用父类的构造方法
     * <p>
     * 使用自定义的类：
     * <p>
     * 在方法中，根据条件判断的结果，再通过throw关键向方法的调用者抛出异常
     * eg.
     * <p>
     * void method(int a){
     * if(a<0){
     * throw new 自定义异常类型("异常信息");
     * }
     * <p>
     * }
     * <p>
     * 注意：对于抛出的自定义的Exception异常，必须要处理
     * <p>
     * 为什么运行时异常可以不处理？
     * 因为运行时异常，在发生时，JVM默认会中断程序，当然也可以进行捕获。
     * <p>
     * 一般情况下，由于用户数据不合理的原因，而造成了运行时异常。
     */
    public class Demo8 {
        static class MyException extends Exception {
            public MyException() {
                super("自定义异常");
            }
    
            public MyException(String msg) {
                super(msg);
            }
        }
    
        static void isZero(int n) throws MyException {
            if (n < 0) {
                //抛出数值不能小于0的异常
                throw new MyException("数值不能小于0！！"); //抛出的一般性异常必须要处理：捕获或抛出
            }
    
            System.out.println("大于0的值--》" + n);
        }
    
        public static void main(String[] args) {
    
            try {
                isZero(-1);
            } catch (MyException e) {
                e.printStackTrace();
            }
    
        }
    }
###Demo9(String 类)
    /**
     * String 简介 final修饰的类
     */
    public class Demo9 {
        public static void main(String[] args) {
    
            String s1 = "abc";
            String s2 = "abc";
    
            System.out.println(s1 == s2);//内存地址的比较//true
    
            int len = s1.length();
            for (int i = 0; i < len; i++) {
    
                //charAt(int index)获取指定位置的字符
                System.out.println(s1.charAt(i));//a//b//c
            }
    
            String s3 = "http://www.baidu.com/images/logdgre/dgo.gif";
            if (s3 != null && s3.length() > 0) {
    
                //从字符串中截取文件名（后部分数据）
                String fileName = s3.substring(s3.lastIndexOf("/") + 1);
    
                //提示快捷键：alt+/
                System.out.println(fileName);//dgo.gif
    
                //截取前部分数据
                String prefix = s3.substring(0, s3.indexOf(":"));
                System.out.println(prefix);//http
            }
    
            //比较
            String s4 = "acdaaa";
            String s5 = "cd";
    
            //进行内容比较
            System.out.println(s4.equalsIgnoreCase(s5));//false
    
            //判断 是否包含子字符串
            System.out.println(s4.contains(s5));//true
    
            //将字符串转为字节数组
            String name = "张三";
            //默认编码为unicode, 可选的有utf-8,gbk,gb2312,iso8859-1
    
            byte[] bytes;
            try {
                bytes = name.getBytes("gb2312");//gbk和gb2312编码中，每一个汉字点2个字节
                System.out.println(bytes.length);//4
    
                //注意： 编码和解码必须保持一致
                System.out.println(new String(bytes, "gb2312"));//张三
    
                //基本数据类型转成字符串
                String s6 = String.valueOf(100);
                s6 = String.valueOf(78.85);
    
                //查看字符串的hashCode()
                System.out.println("张三".hashCode() + "," + name.hashCode());
    
                //比较字符中，如果两个字符串完全相等，则返回0
                System.out.println("abd".compareTo("abddddddd"));//-6
    
            } catch (UnsupportedEncodingException e) {
                //ctrl+d 快速删除整行
                e.printStackTrace();
            }
    
    
        }
    }
