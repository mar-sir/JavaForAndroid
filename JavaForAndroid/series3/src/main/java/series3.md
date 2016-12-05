###Demo1(冒泡，选择，插入排序)
    /**
     * 数组简单排序
     */
    public class Demo1 {
        private static final int[] arrs = {45, 12, 46, 20, 48, 33};
    
        public static void main(String[] args) {
            //冒泡排序
            //bubbleSort(arrs);
            //选择排序
            //selectSort(arrs);
            //简化版选择排序
            //betterSelectSort(arrs);
            //插入排序
            insertSort(arrs);
    
        }
    
    
        /**
         * 冒泡排序
         * 保证最大值在最后面
         *
         * @param arrs
         */
        static void bubbleSort(int[] arrs) {
            beforeSort(arrs);
            for (int i = 0; i < arrs.length; i++) {
                for (int j = 0; j < arrs.length - 1 - i; j++) {
                    if (arrs[j] > arrs[j + 1]) {
                        int temp = arrs[j];
                        arrs[j] = arrs[j + 1];
                        arrs[j + 1] = temp;
                    }
                    printHint(arrs, i, j);
                }
                System.out.println();
            }
        }
    
    
        /**
         * 选择排序
         * 保证最左边的最小
         *
         * @param arrs
         */
        private static void selectSort(int[] arrs) {
            beforeSort(arrs);
            for (int i = 0; i < arrs.length - 1; i++) {
                for (int j = i + 1; j < arrs.length; j++) {
                    if (arrs[i] > arrs[j]) {
                        int temp = arrs[j];
                        arrs[j] = arrs[i];
                        arrs[i] = temp;
                    }
                    printHint(arrs, i, j);
                }
                System.out.println();
            }
        }
    
        /**
         * 大大的减少数组变动次数
         *
         * @param arrs
         */
        private static void betterSelectSort(int[] arrs) {
            beforeSort(arrs);
            for (int i = 0; i < arrs.length - 1; i++) {
                int k = i;
                for (int j = i + 1; j < arrs.length; j++) {
                    if (arrs[k] > arrs[j]) k = j;
                }
                if (k != i) {
                    int temp = arrs[i];
                    arrs[i] = arrs[k];
                    arrs[k] = temp;
                }
                System.out.print("第" + (i + 1) + "次遍排序:" + "\t\t");
                for (int x : arrs) {
                    System.out.print(x + "\t");
                }
                System.out.println();
    
            }
        }
    
    
        /**
         * 插入排序,认为左边的数是有序数列
         *
         * @param arrs
         */
        private static void insertSort(int[] arrs) {
            beforeSort(arrs);
            int count = 0;
            for (int i = 1; i < arrs.length; i++) {
                for (int j = i; j > 0; j--) {
                    if (arrs[j] < arrs[j - 1]) {
                        int temp = arrs[j - 1];
                        arrs[j - 1] = arrs[j];
                        arrs[j] = temp;
                    } else {
                        break;
                    }
                    System.out.print("第" + ++count + "次遍排序:" + "\t\t");
                    for (int x : arrs) {
                        System.out.print(x + "\t");
                    }
                }
                System.out.println();
            }
    
        }
    
        /**
         * 这体现代码，复用
         *
         * @param arrs
         */
        private static void beforeSort(int[] arrs) {
            System.out.print("排序前:\t\t\t");
            for (int k : arrs) {
                System.out.print(k + "\t");
            }
            System.out.println();
        }
    
        /**
         * 这体现代码，复用
         * 同样你也可以把数组交换的代码抽做一个方法，
         *
         * @param arrs
         * @param i
         * @param j
         */
        private static void printHint(int[] arrs, int i, int j) {
            System.out.print("第" + (i + 1) + "次" + "第" + (j + 1) + "遍排序:" + "\t\t");
            for (int k : arrs) {
                System.out.print(k + "\t");
            }
        }
    
    }
#####冒泡排序
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series3/src/main/java/images/step1.png?raw=true)
####选择排序
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series3/src/main/java/images/step2.png?raw=true)
####优化选择排序
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series3/src/main/java/images/step3.png?raw=true)
####插入排序
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series3/src/main/java/images/step4.png?raw=true)
###Demo2(二分法查找)
    /**
     * 二分法查找
     * <p>
     * 前提：必须是有序数组
     */
    public class Demo2 {
        private static final int[] arrs = {45, 12, 46, 20, 48, 33};
    
        private static final int[] arrs1 = {45, 12, 46, 20, 48, 33};
    
        public static void main(String[] args) {
            //首先排序数组
            insertSort(arrs);
            sop(arrs);
            //查找
            int index = binaryFind(arrs, 20);
    
            int index2 = binaryFind(arrs, 90);
    
            sop(index, 20);
            sop(index2, 90);
            System.out.println("================系统自带的Arrays类=================");
            Arrays.sort(arrs1);
            System.out.println(Arrays.toString(arrs1));
            System.out.println("20查找的位置：" + Arrays.binarySearch(arrs1, 20));
            System.out.println("90查找的位置：" + Arrays.binarySearch(arrs1, 90));
    
        }
    
        private static void sop(int index, int key) {
            System.out.println();
            if (index != -1) {
                System.out.println(key + "的位置为:" + index);
            } else {
                System.out.println("没有找到" + key + "的位置");
            }
        }
    
        private static int binaryFind(int[] arrs, int key) {
            //数组操作 下标是关键
            //定义下标
            int min = 0;//最小值下标
            int max = arrs.length - 1;//最大值下标
            int mid = arrs.length / 2;//中间值下标
            while (min < max) {//查找的终止条件
                if (arrs[mid] > key) {//表明key在数组前部分
                    max = mid - 1;
                } else if (arrs[mid] < key) {//表明key在数组后半部分
                    min = mid + 1;
                } else {
                    return mid;//找到下标
                }
                mid = (min + max) / 2;//中间下标也要改变
            }
            return -1;
        }
    
    
        private static void sop(int[] arrs) {
            System.out.println("排序后:");
            for (int k : arrs) {
                System.out.print(k + "\t");
            }
        }
    
        private static void insertSort(int[] arrs) {
            for (int i = 1; i < arrs.length; i++) {
                for (int j = i; j > 0; j--) {
                    if (arrs[j] < arrs[j - 1]) {
                        int temp = arrs[j - 1];
                        arrs[j - 1] = arrs[j];
                        arrs[j] = temp;
                    } else {
                        break;
                    }
                }
            }
        }
    }
####运行结果:
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series3/src/main/java/images/step5.png?raw=true)
###Demo3（类定义）
    /**
     * 类的定义格式：
     * class 类名{
     * <p>
     * 声明成员变量；
     * 声明成员方法；
     * }
     * <p>
     * 类的命名规范：
     * 1、第一个字母要大写;
     * 2、“见名知意”，名字有一定的意义,Student、Person、Car
     * 3、名字中具有一定功能性的描述，如OrderService,StudentManager
     */
    public class Demo3 {
        public static void main(String[] args) {
            People people = new People();
            people.name = "楼主";
            people.eat();//楼主正在吃
        }
    
    }
    
    //这也说明一个.java文件能有多个类
    class People {
        String name;
    
        public void eat() {
            System.out.println(this.name + "正在吃");
        }
    }
####图解
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series3/src/main/java/images/step6.png?raw=true)
###Demo4
    /**
     * 局部变量与成员变量的区别
     * <p>
     * 局部变量： 随着方法入栈初始化，随着方法出栈而消失
     * 成员变量： 随着对象的初始化创建，随着对象的回收而消失
     */
    public class Demo4 {
        public static void main(String[] args) {
            Student student = new Student();
            student.name = "萌萌";
            student.age = 18;
    
            student.say();//1今年萌萌18岁
    
            student = null;//person指向的堆内存会被垃圾回收器（GC）回收
        }
    }
    
    class Student {
        String name;
        int age;
    
        public void say() {
            int id = 1;
            System.out.println(id + "今年" + name  + age+"岁");
        }
    }
###Demo5(java 访问权限)
    /**
     * Java面向对象的三大特征： 封装、继承、多态
     * <p>
     * 封装：向外部提供有用的成员（属性、方法）
     * <p>
     * 成员的四个访问权限：
     * private   私有的，只能在类的内部访问
     * [default] 默认的，可以在同一个包下访问
     * protected 受保护的，可以在类的内部和子类中访问
     * public    公有的，可以在任一地方访问
     * <p>
     * <p>
     * this:  指向当前类对象，当出现局部变量与成员变量重命名时，
     * 需要使用this来访问成员变量
     */
    
    public class Demo5 {
    
        public static void main(String[] args) {
    
            Person person=new Person(); //调用了默认的构造方法（无参的）
            //stu.name="张三";  //私有的成员是不能通过对象访问
            person.setName("张三");
            person.setAge(30);
    
            person.sex="女";
    
            System.out.println("Person: "+person.toString());//Person: [name=张三,age=30,sex=女]
        }
    }
    
    class Person {  //数据实体类
    
        private String name;  //默认值为null
        private int age;   //默认值为0
    
        String sex = "男";
    
        //方法名的命名方式为驼峰命名方法（setXxx,getXxx）
        public void setName(String name) {
            this.name = name; //this.name代表的是成员变量
        }
    
        public String getName() {
            return name;
        }
    
        public void setAge(int age) {
            this.age = age;
        }
    
        public int getAge() {
            return age;
        }
    
        //实现将对象转成字符串的方法
        public String toString() {
            return "[name=" + name + ",age=" + age + ",sex=" + sex + "]";
        }
    }
####如图
|    修饰符      |   当前类     |  同包  |  子类   |  其他包    |
| ------------- |:-------------:|: -----:|:-----------:|-------:|
| public      | 可以 | 可以 | 可以       | 可以          |
| protected      | 可以      |   可以 | 可以     |  不可以          |
| 默认(friendly) | 可以     |   可以 | 不可以      |  不可以          |
| private       |   可以            | 不可以       |不可以      | 不可以         |
###Demo6(构造方法)
    /**
     * 构造方法： 初始化成员变量
     * <p>
     * 命名： 类名，且无返回值
     * <p>
     * 注意：
     * 1、 构造方法只能用于初始化对象，不能被对象调用和类的成员方法中调用
     * 2、 默认构造方法为无参的，也是隐式构造方法（无需提供）
     * 3、 可以提供有参的构造方法，但会覆盖默认的构造方法，
     * 在初始化时，必须显示使用构造方法
     * <p>
     * 4、 两个构造方法之间可以相互调用，使用this()方式调用，但必须在第一行。
     */
    public class Demo6 {
    
        public static void main(String[] args) {
    
            Teacher teacher = new Teacher();
            teacher.say();
    
            Teacher xiao = new Teacher("小小");
            xiao.say();
    
            //匿名对象：不存在一个引用指向这个对象
            new Teacher("shabi").say(); //当执行完成后，对象空间可以被垃圾回收器回收
        }
    }
    
    class Teacher {  //动物类
        private String name;
    
        public Teacher() { //无参的构造方法
            this("teacher"); //调用有参的构造方法，必须在第一行
    
            //name="teacher";
        }
    
        public Teacher(String name) { //带有参数的构造方法,默认情况下会覆盖无参的构造方法
            this.name = name;
        }
    
        public void say() {
    
            System.out.println("大家好，Teacher,我叫 " + name);
        }
    
    }
###Demo8(static)
    /**
     * static 修饰的成员
     * <p>
     * 1、 静态成员变量
     * <p>
     * 特点：
     * 1、 随着类的加载，会在方法区的静态区中开辟内存空间，初始化数据
     * 2、 可以通过类名直接访问，格式：类名.静态成员变量
     * 3、 一般用于存储所有类的共享数据
     * 2、 静态成员方法
     * 特点：
     * 1、静态方法中只能访问静态成员（不能使用this引用）
     * 2、非静态方法中可以访问静态成员（都能访问）
     * <p>
     * 3、静态成员变量与非静态成员变量的区别：
     * <p>
     * 1、 生命周期
     * <p>
     * 静态成员变量随着类的加载，在方法区的静态区中初始化，在程序结束时而消失
     * 成员变量是随着对象的初始化，在堆中创建与初始化，在对象被垃圾回收时而消失
     * <p>
     * 2、存储的特点
     * 静态成员变量是所有对象共享存储的数据
     * 成员变量是某一对象存储的数据
     * <p>
     * 3、访问方式
     * 静态成员变量可以通过类名直接访问，也可以对象访问
     * 成员变量只能通过对象来访问
     */
    public class Demo7 {
    
        public static void main(String[] args) {
            Student1.sex="男"; //直接通过类名来访问类中的静态成员变量
    
            Student1 s1= new Student1();
            s1.setAge(30);
            s1.say();//hello,女,30
    
            s1.sex="不男不女"; //也可以通过类的对象访问类中的静态成员变量
            s1.say();//hello,女,30
    
            Student1 s2=new Student1();
            s2.setAge(25);
            s2.say();//hello,女,25
        }
    }
    
    class Student1{
        static String sex="男"; //静态成员变量
    
        private int age;
    
        public void setAge(int age){
            this.age=age;
        }
    
        public static void setSex(String sex){//静态成员方法
            Student1.sex=sex;//将方法中的局部变量的值 赋给静态成员变量
    
            //age=30; //在静态方法中不能访问非静态成员
        }
    
        public void say(){ //在成员方法中，是否可以访问静态成员变量
    
            setSex("女"); //在非静态方法中可以访问静态方法
    
            System.out.println("hello,"+sex+","+age);
    
        }
    }
###Demo8(静态代码块，构造代码块)
    /**
     * 静态代码块： static{  } ,主要作用：初始化静态成员变量
     * <p>
     * 静态代码块： 随着类的加载而执行的，只执行一次
     * <p>
     * 构造代码块： {  },优先于构造方法执行，主要是来初始化成员变量
     * <p>
     * 构造代码块：随着对象的创建而执行，每次创建对象都会执行
     * <p>
     * static修饰符什么时候使用？
     * 1、 在多个类之间共享成员变量时，需要将其改为static静态成员变量
     * 2、 如果一个成员方法中没有访问本类的成员变量，则将其改为static静态成员方法
     * <p>
     * 注：
     * 在程序优化中，建议不要过多地使用static,因为它会长时间地保留在内存中（方法区的静态区）
     * <p>
     * 对象初始化过程：
     * 1、加载类的字节码文件到jvm的方法区中
     * 2、为静态成员变量在静态区开辟内存空间，并初始化默认值
     * 3、加载静态代码块，初始化静态成员变量
     * 4、在堆中开辟空间（根据成员变量的大小），并默认初始化成员变量
     * 5、加载构造代码块，显示初始化成员变量
     * 6、加载构造方法，显示初始化成员变量
     * 7、将堆内存空间的首地址赋给对象的引用
     */
    public class Demo8 {
        public static int age;
    
        static {
            System.out.println("静态代码块age-->" + age);
    
            //初始化静态成员变量，在类加载时执行
            age = 20;
    
            System.out.println("静态代码块age-->" + age);
        }
    
        { //构造代码块,可以被看成是一个无参的构造方法
            age += 1;
            System.out.println("构造代码块-->" + age);
        }
    
        public Demo8() {
            age += 1;
            System.out.println("构造方法中： age-->" + age);
        }
    
        public static void main(String[] args) {
            new Demo8();
            new Demo8();
            new Demo8();
            new Demo8();
        }
    }
####运行结果
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series3/src/main/java/images/step7.png?raw=true)
###Demo9(继承)
    /**
     * java面向对象三大特性: 封装，继承，多态
     * <p>
     * 继承：extends
     * <p>
     * 特点： 通过继承，可以将父类的成员继承过来，使得两个存在父子关系
     */
    public class Demo9 {
    
        public static void main(String[] args) {
            Person1 person1 = new Person1();
            person1.setName("小李子");
            person1.eat();//小李子,正在吃
    
            Student2 s2 = new Student2();
            s2.setName("贱人曾");
            s2.eat();//贱人曾,正在吃
    
    
            Worker worker = new Worker("xiaofeifei");
            worker.eat();//xiaofeifei,正在吃
        }
    }
    
    class Person1 {  //父类
        private String name;
    
        public Person1() {
        } //无参的构造方法
    
        public Person1(String name) {
            this.name = name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public void eat() {
            System.out.println(name + ",正在吃");
        }
    }
    
    class Student2 extends Person1 { //子类
    
    }
    
    class Worker extends Person1 {  //子类
    
        public Worker(String name) {
            super(name); //调用父类的构造方法，super()必须在第一行
        }
    }
###Demo10(继承中的构造、静态代码块)
    /**
     * 继承中的类成员特点：
     * <p>
     * 1、父类的私有成员不能被访问
     * 2、如果子类中存在成员与父类的成员重名，则使用super来访问父类中同名成员，
     * super是代表父类的数据空间，并不是一个对象
     * 3
     * <p>
     * 子类对象的初始化过程：
     * <p>
     * 1、父类的静态代码块
     * <p>
     * 2、子类的静态代码块
     * <p>
     * 3、父类的构造代码块。。
     * <p>
     * 4、父类构造方法-->初始化父类的成员变量
     * <p>
     * 5、子类的构造代码块。。
     * <p>
     * 6、子类构造方法-->初始化子类的成员变量
     */
    
    public class Demo10 {
    
        public static void main(String[] args) {
            Child c1 = new Child();
            c1.say();
        }
    }
    
    class Parent {
        private String name;
    
        public int age;
    
        static {
            System.out.println("父类的静态代码块。。");
        }
    
        {
            System.out.println("父类的构造代码块。。");
        }
    
        public Parent() {
            System.out.println("父类构造方法-->初始化父类的成员变量");
        }
    
        private void setName(String name) {
    
        }
    
        public void talk() {
            System.out.println("父类 age：" + age);
        }
    }
    
    
    class Child extends Parent { //子类，继承父类的所有成员
        private int age;
    
        static {
            System.out.println("子类的静态代码块。。");
        }
    
        {
            System.out.println("子类的构造代码块。。");
        }
    
        public Child() {
            System.out.println("子类构造方法-->初始化子类的成员变量");
        }
    
    
        public void say() {
            //name="张三";//出错，父类的私有成员不能被访问
            //setName("张三");//同上
    
            super.age = 100; //访问父类的成员变量
            age = 90;        //访问子类的成员变量
    
            System.out.println("子类 age：" + age);
            talk(); //非私有成员方法都能访问
        }
    }
####运行结果
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series3/src/main/java/images/step8.png?raw=true)