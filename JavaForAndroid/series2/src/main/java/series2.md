###Demo1（continue break补充）
    public class Demo1 {
    
        public static void main(String[] args) {
            int k = 1, count = 0;
            for (; k <= 100; k++) {
    
                if (k % 2 == 0) {
                    continue;  //结束本次循环，转到下一次循环
                    //后面代码同样不会执行
                }
                count++;//有多少个奇数
            }
            System.out.println(count);
            System.out.println("===================================");
            //
            int sum = 0;
            outer:
            for (int m = 0; m < 100; m++) {
                inner:
                for (int n = 0; n < 20; n++) {
                    sum += n;  //sum ++;
                    if (n == 5) break;//跳出了当前循环,但跳不出第二层循环
                    if (sum >= 100) {
                        break outer;//跳出outer
                    }
                }
    
            }
            System.out.println(sum);
        }
    }
###Demo2(方法)
    /**
     * 方法（函数）: 为了减少代码的重复性，可以被多次调用
     * <p>
     * 声明方法时：
     * 1、 方法是否有结果：有返回值
     * 2、 调用方法时，是否需要不确定数: 需要,则声明参数
     */
    
    public class Demo2 {
    
        public static void main(String[] args) {
            //输入两个数，求和
            sum();
        }
        //自定义方法，实现输入两个数并求和
        static void sum() {
            //输入两个数，求和
            Scanner sc = new Scanner(System.in);
            int sum = 0, num = 0;
            System.out.println("请输入第一个数：");
            num = sc.nextInt();
            sum += num;
            System.out.println("请输入第二个数：");
            num = sc.nextInt();
            sum += num;
            System.out.println("两个数的和：" + sum);
            sc.close();//关闭与I/O的连接，释放资源
        }
    }
###运行结果
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series2/src/main/java/images/step1.png?raw=true)
###Demo3(方法详解)
    /**
     * 方法（函数）: 为了减少代码的重复性，可以被多次调用
     * <p>
     * 声明方法时：
     * 1、 方法是否有结果：有返回值
     * 2、 调用方法时，是否需要不确定数: 需要,则声明参数
     * <p>
     * <p>
     * 注意：
     * 1、 声明的方法一般被main方法调用 ，main方法被 JVM
     * 2、 方法中需要的数据由main方法提供（调用者提供）
     * 3、 方法如果有返回结果，此结果返回给调用者
     * <p>
     * 方法定义的格式：
     * <p>
     * 返回数据类型  方法名（参数列表）{ }
     * <p>
     * 返回数据类型： 无返回类型 void ,有返回类型，是结果的数据类型
     * <p>
     * 在一个类中，可以出现多个重命的方法，
     * 但要求方法的参数不同：个数、类型、同个数但类型不同
     * 从而构成了方法的重载。
     */
    public class Demo3 {
    
        public static void main(String[] args) {
            int sum = sum(10, 9); //返回结果为19
    
            sop("sum->" + sum);//sum->19
    
            sop("10+19+8=" + sum(10, 19, 8));//10+19+8=37
    
            sop("10.5+19.25=" + sum(10.5, 19.25));//10.5+19.25=29.75
        }
    
        //有返回结果，有不确定的数
        static int sum(int a, int b) { //方法的重载
    
            if (a != 0 || b != 0)
                return a + b; //结果返回之后，后面的语句就不会执行
    
            //如果有返回结果，必须存在一个return语句
            return 0;
        }
    
        //功能：三个数相加，返回和
        static int sum(int a, int b, int c) { //方法的重载
            return sum(sum(a, b), c);
        }
    
        //功能：实现2个小数相加的和
        static double sum(double a, double b) { //方法的重载
            return a + b;
        }
    
        //功能：打印指定的消息，无返回结果，但有不确定的数据（有参）
        static void sop(String msg) {
            System.out.println(msg);
    
            //如果方法无返回数据，也可以使用return结束方法
            return;
    
            //return 之后的语句不能被执行--编译就不通过
            //System.out.print("<------->");
        }
    }
###Demo4（局部变量，及方法调用的背后）
    /**
     * 局部变量的作用域，只限于方法内部
     * <p>
     * 方法的调用:  入栈，分配内存空间，初始化局部变量
     * 方法的返回： 出栈，释放内存空间，在方法中定义的局部变量也就消失
     */
    public class Demo4 {
    
    
        public static void main(String[] args) {
            int a = 100;
            int b = 300;
    
            int sum = add(a, b); //调用方法，并获取其计算的结果
    
            sop("" + sum);
        }
    
    
        static int add(int a, int b) {
    
            //默认对每一个数增加相应的值
            a += 10;
            b += 20;
            int sum = a + b;
    
            return sum;
        }
    
        static void sop(String msg) {
            System.out.println(msg);
    
        }
    }
###图解
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series2/src/main/java/images/step2.png?raw=true)
###Demo5（数组简介）
    /**
     * 数组： 存储相同类型的一组数据，
     * 数组也是一种数据类型，是引用数据类型（数组、类、接口）
     * <p>
     * 定义格式：
     * 数据类型[] 数组名 =new 数据类型[数组的长度];
     * <p>
     * //new 是在内存中分配空间，空间的大小由数组的长度和数据类型决定。
     * //在数组的内存分配完成后，会将内存的首地址返回给数组名，
     * 因此数组名是指向内存空间首地址的引用
     * <p>
     * 数组定义的其它格式：
     * 格式1：
     * int[] ns=new int[]{8,1,2,3,5,6,7};
     * <p>
     * 在创建数组时，根据指定的初始化值列表，确定数组的长度，来分配内存空间
     * <p>
     * 格式2： int[] ns={9,1,4,6,9,10};
     * <p>
     * 格式2的增强版
     * <p>
     * 说明：格式1和2都是静态方式创建数组
     */
    public class Demo5 {
        public static void main(String[] args) {
            //定义一个可以存放5个整数的数组
            int[] nums = new int[5]; //根据数据类型和长度，在内存分配了20byte
            nums[0] = 1;
            nums[4] = 9;
            //nums[2]=? //数组在创建完成后，会初始化每个成员的值
            for (int i = 0; i < 5; i++) {
                //此时的数组的有效索引范围： 0~4
                System.out.println(i + ":" + nums[i]);
            }
            //nums[5]; //出错，会出现ArrayIndexOutOfBoundsException
    
            //声明数组的长度，必须在创建数组时指定，不能在声明时指定
            //char[10] cs=new char[]; //错误的，数组的长度必须在创建时指定
    
    
            //int[] nd=new int[5]{1,7,9,10,2}; //错误：数组的固定长度不能与初始化列表同时存在
            int[] ns=new int[]{1,7,9,10,2};
    
            for(int i=0;i<ns.length;i++){
                System.out.print(ns[i]+"\t");
            }
    
        }
    }
###图解
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series2/src/main/java/images/step3.png?raw=true)
###Demo6(重重点，值传递还是引用传递)
    /***
     * 基本数据类型与引用数据类型的区别
     */
       
    public class Demo6 {
    
        //显示一个数
        static void show(int a) {
            a += 5;//聪明的AndroidStudio 已经发现这里的a没用到，然而我说这句话并没什么卵用
        }
    
        static void show(int[] nums) {
            nums[0] += 5;
        }
   
        public static void main(String[] args) {
            int a = 10;
            show(a);
            System.out.println(a);//10  并不是15
            int[] nums = {9, 5, 2};
            show(nums); //将数组的首地址传给了方法中的数组引用
            System.out.println(nums[0]);//14 并不是9
           //////////////////////////////////
           //字符串的常量对象：  保存在常量池中
           String str = "hihi";
           String str2 = "hihi";
            System.out.println(str == str2);//结果：true
           show(str);//将str变量的内容“hihi”传给方法
            System.out.println(str);//输出：hihi
           String str3 = new String("hihi");
           String str4 = str3;
            str3 = "hehe"; //hehe在常量池不存在，则会在常量池中创建对象，str3就指向这个对象
             System.out.println(str4);//输出： hihi
        }
    }

[面试必问，叫你还不点进来](https://www.zhihu.com/question/31203609)
#####我同意这个说法
在Java中，变量分为以下两类：
①对于基本数据类型变量（int、long、double、float、byte、boolean、char），Java是传值的副本。
②对于一切对象型变量，Java都是传引用的副本。其实传引用副本的实质就是复制指向地址的指针，只不过Java不像C++中有显著的*和&符号。
需要注意的是：String类型也是对象型变量，所以它必然是传引用副本。String类是final类型的，因此不可以继承和修改这个类。
不管Java参数的类型是什么，一律传递参数的副本。

作者：Jacky冠杰
链接：https://www.zhihu.com/question/31203609/answer/51056048
来源：知乎
著作权归作者所有，转载请联系作者获得授权。
####对于我个人提示
和他们的存储位置有关系
###Demo7(数据交换)
    /**
     * 数据交换
     */
    public class Demo7 {
        public static void main(String[] args) {
            int a = 10, b = 30;
            System.out.println(a + "," + b);
            swap(a, b);
    
            int[] nums = {100, 200};
            swap(nums);
        }
    
    
        //交换a和b的数值
        static void swap(int a, int b) {
            /*int c=a;
    		a=b;
    		b=c;
    		*/
            a = a + b;
            b = a - b;
            a = a - b;
            System.out.println(a + "," + b);
        }
    
    
        //方法参数： 引用类型
        static void swap(int[] nums) {
    
            swap(nums[0], nums[1]);
    
            System.out.println(nums[0] + "," + nums[1]); //此时数组中的数值不会改变
    
            int c = nums[0];
            nums[0] = nums[1];
            nums[1] = c;
    
            System.out.println(nums[0] + "," + nums[1]); //此时，两个数值已交换
        }
    }
###Demo9(增强for循环)
    /**
     * jdk 1.5中增强for循环
     * <p>
     * 格式：  for(数据类型 变量名：数组名){ 循环体  }
     * <p>
     * 过程： 将数组中数从0的位置依次读取
     * <p>
     * 不好之处： 在循环体中无法访问 当前读取的索引值
     */
    public class Demo9 {
        public static void main(String[] args) {
            //动态生成10个随机数(1~100)，并读取（打印）
            int[] nums = new int[10];
    
            for (int i = 0; i < nums.length; i++) {
                nums[i] = (int) (Math.random() * 100 + 1); //生成1~100之间的随机数
            }
    
            //打印
            for (int n : nums) {
                System.out.print(n + "\t");
            }
        }
    }
###Demo10（二维数组）
    /**
     * 二维数组
     * 定义格式：
     * <p>
     * 数据类型[][] 数组名 = new 数据类型[行大小][列大小];
     * <p>
     * 数据类型[][] 数组名 =new 数据类型[][]{{1,3,2},{2,3,4},{},{0,9,2}}
     * <p>
     * 数据类型[][] 数组名 ={{1,3,2},{2,3,4},{},{0,9,2}}
     */
    public class Demo10 {
    
        public static void main(String[] args) {
            int[][] scores = new int[][]{{90, 80, 100}, {92, 90, 100}, {91, 95, 96}, {95, 100, 100}, {97, 98, 100}};
    
    
            //循环一维数组：行
            for (int i = 0; i < scores.length; i++) {
    
                System.out.print("第 " + (i + 1) + " 人的成绩：");
    
                //循环二维数组： 列
                for (int j = 0; j < scores[i].length; j++) {
    
                    if (j != scores[i].length - 1)
                        System.out.print(scores[i][j] + ",");
                    else
                        System.out.print(scores[i][j] + "\n");
                }
            }
        }
    }
