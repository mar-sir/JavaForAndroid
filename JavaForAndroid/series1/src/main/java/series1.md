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
###Demo2 (基本数据类型)
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
            //(2)声明变量语法：<类型>variable;
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
boolean(布尔型) byte(字节类型,1byte)  char(字符类型,2)  short(短整型,2) int(整形,4)  float(浮点类型,单精度,4) long(长整型,8) double(浮点型,双精度,8)
######Java默认整型是int类型,若要定义成float型,则要在数值后面加上f或F
######Java默认浮点型是double类型,若要定义成float型,则要在数值后面加上f或F
####基本数据类型自动装换
byte->short,char->int->long
float->double
int->float
long->double
小可转大，大要转小则损失精度
###Demo3  （转义字符，运算符）
    public class Demo3 {
    
        public static void main(String[] args) {
    
            //'\'转义
            zhuanYi();
    
            //运算符   算术、赋值、比较、逻辑、位运算、三目运算符
            yunSuanFu();
        }
    
        
        private static void yunSuanFu() {
            int a=18;
            int b=10;
    
            int c=a-b;
    
            //算术 + , - , *, /, %, ++,--
            ////////////////////////////////////////
            int d=++c; //先自加，后返回（表达式的结果）,因此d=9,c=9
    
            int e=c++; //先返回，后自加，e=9,c=10
    
            int f=a/b; //取整数，f=1
    
            int h=a%b; //取余数，h=8
    
            ///////////////////////////////////////
            //赋值：  = , +=,-=,/=, *=, %=
    
            //String.format(String ,Object ...) 格式化字符串，
            //将第一个参数中%位置的值用后面的参数替换,按先后顺序替换，
            //可用的%格式： %d 整数, %f,%.2f 带小数位的float/double,%s 字符串
            System.out.println(String.format("a=%d,b=%d,c=%d,d=%d,e=%d,f=%d,h=%d",a,b,c,d,e,f,h));//a=18,b=10,c=10,d=9,e=9,f=1,h=8
    
    
            h*=2; //h=h*2;
    
            byte b1=127;
    
            b1+=1; // -128
    
            //b1=127+1; //错误的，128已超出为byte类型大小
    
            System.out.println(b1);//-128
            ///////////////////////////////////////
    
            //比较:  >, >= ,  < ,  <= ,  ==, != ,表达式结果为boolean
    
            System.out.println("c>d="+(c>d)); //c>d=true
    
            boolean b2=c>d;
    
            System.out.println("a==c ->"+(a==c)); //a==c ->false
            ///////////////////////////////////////
    
            //逻辑：  &&， || ， ！， &，|
    
            // true && true  = true, true && false = false
            // true || false =true, false || true = true
            //  !true =false
            //  true & false :  false,
            // &与&&区别：   && 如果第一个是false则不再判断后面的值  & 两个都要判断
            // | 与|| 区别： || 如果第一个是true,则不再判断后面的值，| 两个都要判断
           ///////////////////////////////////////
    
            //位运算:  & 按位与，两个都为1时，则为1，否则为0 ，eg. 1&0=0，1&1=1
            //         | 按位或，两个中任一个是1时，则为1, eg.   1|0=1,1|1=1,0|0=0
            //         ^ 按位异或， 两个相同时，为0，不同时为1， eg. 1^0=1,0^0=0,1^1=0
    
            //          ~ 按位取反，如果取反之后为负数，则按负数的正数取反加1得出结果，eg. ~10=-11
    
            System.out.println(~10000);//-10001
            ///////////////////////////////////////
    
            //移位运算符：>> 向右移，相当于除于2^n  << 向左移，相当于乘于2^n    >>> 无符号移动
    
            // -10 >>2 ,与-10/4=-2 不同， 8>>3 ,  8/8=1;  -10>>>2, 无符号移动
    
    
            System.out.println(-10>>>2);//无符号移动，高位补0 //1073741821
        }
    
    
    
    
    
        //常用的转义字符   "\t" 制表 "\n" 换行
        private static void zhuanYi() {
    
            System.out.println("\t*\t*\t*");//	*	*	*
            //\t  制表符，\" , \\, \r\n (window 换行）,\n (linux 换行）
    
            System.out.println("name=\"小红\",\"age\":20");//name="小红","age":20
    
            System.out.println("name=\"小黑\",\n\"age\":20");//name="小黑",
            //"age":20
            System.out.println("\\5\\2\\");// \5\2\
    
        }
    }
####逻辑运算符

* &(与)

         *
         *  true & true   true
         *  true & false  false
         *  false & true  false
         *  false & false false
         *  &符号就是你两边都是true才真,两边只要有一个false，就是false
   
* |(或)
               
         *  true | true   true
         *  true | false  true
         *  false | true  true
         *  false | false false
         *  只要就一个成立就可以，也就是返回true，只有当两个都是false才会返回false
       
* ^(异或)
               
         *  true | true   false
         *  true | false  true
         *  false | true  true
         *  false | false false
         *  相同为false，不同为真
  
* ！(非)
               
       不是.
* &&(短路与)
               
        功能同&，区别在于短路，就是只要发现一个为false,直接返回false，不在做第二个的判断，&必须判断两个
 
* ||(短路或)
               
        功能同|，区别在于短路，就是只要发现一个为true,直接返回true，不在做第二个的判断，|必须判断两个
####三目运算符
* 三目运算符  条件表达式？为真的值：为假的值
    
    	int max= a>b?a:b;
    
    	//使用if-else分支
    	if(a>b){
    	    //为真时
    	    max=a;  
    	}else{
                //为假时
    	    max=b;
            }
    
    	System.out.println("最大数为："+max);
###Demo4  (分支语句if else)
        /**
         * /*if分支语句
         * <p>
         * 格式：
         * if(条件) 单行语句; else 单行语句;
         * <p>
         * if(条件){ 多行语句; } else{ 多行语句; }
         * <p>
         * if(){} else if(){} else if(){} else{ },整体结构，只有一个分支会执行
         * <p>
         * if(){
         * <p>
         * if(){} else{}  //嵌套if-else语句
         * }
         */
        
        //要求： 输入两个数，输出最大的一个数
        public class Demo4 {
            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                System.out.println("输入两个数");
                int a = sc.nextInt();
                int b = sc.nextInt();
        
                int cc = 100;
                if (cc <= 100) {
                    cc += 50;
                    if (cc < 100) {
                        System.out.println("红包还不到100");
                    } else if (cc < 500) {
                        System.out.println("红包快到500了，再给点。。。^_^");
                    } else {
                        System.out.println("哈。。红包已超过500了");
                    }
                }
        
                //输入一个星期的数，并输出对应的星期名称，0-星期日，1-星期一，。。6-星期六
        
                System.out.println("输入一个星期的数,0-星期日，1-星期一,...,6-星期六: ");
        
                int wIndex = sc.nextInt();
        
                String wName = "星期";
                if (wIndex == 0) {
                    wName += "日";
                } else if (wIndex == 1) {
                    wName += "一";
                } else if (wIndex == 2) {
                    wName += "二";
                } else if (wIndex == 3) {
                    wName += "三";
                } else if (wIndex == 4) {
                    wName += "四";
                } else if (wIndex == 5) {
                    wName += "五";
                } else if (wIndex == 6) {
                    wName += "六";
                } else {
                    wName = "星期的编号出错！！！";
                }
                System.out.println(wName);
            }  
        }
###Demo5(分支语句 switch)
        /**
         * switch分支语句
         * <p>
         * 格式：
         * <p>
         * switch(表达式1){ //表达式的数据类型： char,byte,short,int,long,enum(jdk 1.5),String(jdk 1.7)
         * <p>
         * case 数值1:
         * <p>
         * //当表达式1的值为当前位置的数值1时
         * <p>
         * 语句;
         * <p>
         * case 数值2：
         * <p>
         * 语句;
         * <p>
         * break;
         * default:
         * <p>
         * //上面case语句没有一个被执行或者在case语句中不存在break，则进入此处，进行默认行为的处理
         * <p>
         * 
         */
         public class Demo5 {
    
                public static void main(String[] args) {
                    switch (10) {
            
                        case 5:
                            System.out.println("表达式与5匹配");
                            break;
                        case 10:
                            System.out.println("表达式与10匹配");
                            break;
                        case 15:
                            System.out.println("表达式与15匹配");
                            break;
                        default:
                            System.out.println("表达式中不存在与10匹配的语句或没有出现break");
            
                    }
                    switch (5) {
            
                        case 5: {
                            int i = 5; //变量的作用域： 从声明位置开始到 右大括号结束
                            System.out.println(i);
                            //break;
                        }
                        case 10:
                            int i = 10;
                            System.out.println(i);
                            break;
                        case 15:
                            System.out.println("表达式与15匹配");
                            break;
                        default:
                            System.out.println("表达式中不存在与10匹配的语句或没有出现break");
            
                    }
                }
        }
###Demo6（循环语句 while do while）
        /**
         * 循环语句：
         * <p>
         * while循环： 先判断条件，如果条件为true则执行循环体，当循环体执行完后，再接着判断条件。。。
         * <p>
         * while(条件表达式){
         * <p>
         * 循环体; //执行某一重复使用的功能代码
         * <p>
         * 改变循环条件的值;
         * }
         * <p>
         * do-while循环： 先执行循环体，再判断条件
         * <p>
         * do{
         * <p>
         * }while(条件表达式)
         * <p>
         * while与do-while的区别：
         * <p>
         * while是先判断后执行（可能一次都不执行循环体），
         * do-while先执行，再判断（至少执行一次循环体）
         */
        public class Demo6 {
        
            public static void main(String[] args) {
                //要求： 求1~100之间数值的和
                int i = 1;
                int sum = 0;
        
                while (i <= 100) {
                    sum += i;
                    i++;
                }
        
                System.out.println("sum=" + sum);
                //重置变量
                i = 1;
                sum = 0;
                do {
                    sum += i;
                    i++;
                } while (i <= 100);
                System.out.println("sum=" + sum);
               //要求： 求5的阶乘
                int y = 5;
                int result = 1;
                do {
                    result *= i;
                    y--;
                } while (y > 1);
        
                System.out.println("5的阶乘为 " + result);
        
            }
        }
###Demo7
        /**
         * for循环：
         * <p>
         * 定义格式：
         * <p>
         * for(初始化表达式1;循环表达式2;循环条件变量变化表达式3){
         * <p>
         * //循环体
         * <p>
         * }
         * <p>
         * 表达式1： 定义循环中使用的变量和循环条件中的变量，其作用域仅限当前for循环中
         * 表达式2： 每次循环的条件表达式，只有条件为true时，才会执行循环体
         * <p>
         * 表达式3： 执行完循环体之后，执行的表达式，一般用于改变循环条件变量的值
         * <p>
         * <p>
         * //嵌套for：
         * <p>
         * for(;;){
         * for(;;){
         * <p>
         * }
         */public class Demo7 {
    
            public static void main(String[] args) {
        
                for (int i = 0; i < 100; i++) {
                    //循环100次
                }
        
                int i = 0;
                for (; i < 100; i++) {
                    //循环100次
                }
        
                System.out.println(i); //i的作用域只限于for循环体中，可以将初始化表达式的变量放在for循环外定义
        
               /* for (; ; ) { //死循环
        
                }*/
                //如果上面的死循环执行，就不会执行下面的调用方法
                toHex(1000);
            }
        
            private static void toHex(int num) {
                String result = "";
        
                while (num > 0) {
                    int ln = num & 15; //取低四位
                    if (ln >= 10) {
                        result = (char) (ln - 10 + 'a') + result;
                    } else {
                        result = ln + result;
                    }
        
                    num = num >> 4; //向右移动四位，即取高四位
        
                }
        
                System.out.println("0x" + result);
            }
         }
