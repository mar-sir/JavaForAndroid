##系列1
###Demo1
    package com.example;
    //package com.example 包，包路径
    
    /**
     * public 访问控制符（public 代表公有，谁都可以访问）
     * class 类
     * Demo1 类名
     */
    public class Demo1 {
        //相当于C的main函数，程序的入口
    
        /**
         * public 访问控制符（public 代表公有，谁都可以访问）
         * static 静态的
         * void   标志没有返回值
         * main   方法名
         * String[] 参数类型
         *
         * @param args 参数
         */
        public static void main(String[] args) {
            //在控制台输出Hello Java!
            System.out.println("Hello Java!");
    
            //说明参数用途是接收的java运行参数
            for (String s : args) {
                System.out.println(s);
            }
        }
    }
[(args参数详解)](http://jingyan.baidu.com/article/86f4a73e63862a37d6526909.html)
###运行时你可能不知道的事
当程序启动时，JVM会将main方法压入栈中，当执行完后，则弹出栈。
###JVM简介
[参考地址](http://m.open-open.com/m/lib/view/1408453806147.html)
下面我就是无耻的C V了,详细的请移步参考地址.
####JVM生命周期
1.      JVM实例对应了一个独立运行的java程序它是进程级别

*    启动。启动一个Java程序时，一个JVM实例就产生了，任何一个拥有public static void main(String[] args)函数的class都可以作为JVM实例运行的起点
*    运行。main()作为该程序初始线程的起点，任何其他线程均由该线程启动。JVM内部有两种线程：守护线程和非守护线程，main()属于非守护线程，守护线程通常由JVM自己使用，java程序也可以标明自己创建的线程是守护线程
*     消亡。当程序中的所有非守护线程都终止时，JVM才退出；若安全管理器允许，程序也可以使用Runtime类或者System.exit()来退出

######JVM执行引擎实例则对应了属于用户运行程序的线程它是线程级别的

####JVM体系结构
1.       类装载器（ClassLoader）（用来装载.class文件）

2.       执行引擎（执行字节码，或者执行本地方法）

3.       运行时数据区（方法区、堆、java栈、PC寄存器、本地方法栈）

####JVM运行时数据区
第一块：PC寄存器

PC寄存器是用于存储每个线程下一步将执行的JVM指令，如该方法为native的，则PC寄存器中不存储任何信息。

第二块：JVM栈

JVM栈是线程私有的，每个线程创建的同时都会创建JVM栈，JVM栈中存放的为当前线程中局部基本类型的变量（java中定义的八种基本类型：boolean、char、byte、short、int、long、float、double）、部分的返回结果以及Stack Frame，非基本类型的对象在JVM栈上仅存放一个指向堆上的地址

第三块：堆（Heap）

它是JVM用来存储对象实例以及数组值的区域，可以认为Java中所有通过new创建的对象的内存都在此分配，Heap中的对象的内存需要等待GC进行回收。

（1）       堆是JVM中所有线程共享的，因此在其上进行对象内存的分配均需要进行加锁，这也导致了new对象的开销是比较大的

（2）       Sun Hotspot JVM为了提升对象内存分配的效率，对于所创建的线程都会分配一块独立的空间TLAB（Thread Local Allocation Buffer），其大小由JVM根据运行的情况计算而得，在TLAB上分配对象时不需要加锁，因此JVM在给线程的对象分配内存时会尽量的在TLAB上分配，在这种情况下JVM中分配对象内存的性能和C基本是一样高效的，但如果对象过大的话则仍然是直接使用堆空间分配

（3）       TLAB仅作用于新生代的Eden Space，因此在编写Java程序时，通常多个小的对象比大的对象分配起来更加高效。

第四块：方法区域（Method Area）

（1）在Sun JDK中这块区域对应的为PermanetGeneration，又称为持久代。

（2）方法区域存放了所加载的类的信息（名称、修饰符等）、类中的静态变量、类中定义为final类型的常量、类中的Field信息、类中的方法信息，当开发人员在程序中通过Class

对象中的getName、isInterface等方法来获取信息时，这些数据都来源于方法区域，同时方法区域也是全局共享的，在一定的条件下它也会被GC，当方法区域需要使用的内存超过其允许的大小时，会抛出OutOfMemory的错误信息。

第五块：运行时常量池（Runtime Constant Pool）

存放的为类中的固定的常量信息、方法和Field的引用信息等，其空间从方法区域中分配。

第六块：本地方法堆栈（Native Method Stacks）

JVM采用本地方法堆栈来支持native方法的执行，此区域用于存储每个native方法调用的状态。
###Demo2
    public class Demo2 {
    
    
        public static void main(String[] args) {
    
            //方法调用
            bianLiang();
    
            //基本数据类型
            //整型: byte short int long
            //浮点型: float double
            //逻辑型: boolean (false true)
            //字符型: char
            numberTypes();
    
        }
    
        private static void numberTypes() {
            byte b1 = 10; //-128~127
            //byte b2=200; //错误：超出最大值
    
            int i = b1; //合法，小的数据类型向大的数据类型自动转换
    
            //short s=i; //错误: 大的数据类型不能向小的数据类型转换
    
            short s2 = (short) i; //合法，强转将大的向小的转
    
            System.out.println(s2);
    
    
            byte b = 20;
            short s = 3000;
            int ii = 89;
            long l = 90;
    
            //float f=8.0;//非法，因为8.0默认为double类型，因此后面增加f或F
            float f = 8.0f;
    
            double dd = b + s + ii + l + f;//合法的,自动将小的向大的转型
    
    
            String tag = "Hello";
            boolean flag = true;
    
            System.out.println(flag);
            System.out.println(tag + "  java");//字符串可以通过+连接任一变量，最终生成新的字符串
    
            System.out.println(dd);
        }
    
    
        //命名规则:$ 、字母、下划线开头都行，后面的可以是数字、字母、下划线
        //命名区分大小写
        private static void bianLiang() {
            //变量 有数据类型的，且可以改变内容的标识符
            //(1)变量与常量的相同点是在声明之前都指定变量的数据类型，变量无final关键字声明。
            //（2）声明变量语法：<类型>variable;
            int a = 20;
            //常量 存储在常量池中
            // （1）常量表示的是在程序中不能被修改的数据。
            // （2）声明常量必须用final关键字。
            // （3）常量分为：整型，浮点型，字符型，布尔型，字符串型常量,null。例如，语法：final<类型>variable=值;
            final int b = 30;
    
            System.out.println(a);
    
            System.out.println(b);
        }
    }
####基本数据类型
boolean(布尔型,1/8Bytes) byte(字节类型,1)  char(字符类型,2)  short(短整型,2) int(整形,4)  float(浮点类型,单精度,4) long(长整型,8) double(浮点型,双精度,8)
######Java默认整型是int类型,若要定义成float型,则要在数值后面加上f或F
######Java默认浮点型是double类型,若要定义成float型,则要在数值后面加上f或F
####基本数据类型自动装换
byte->short,char->int->long
float->double
int->float
long->double
小可转大，大要转小则损失精度