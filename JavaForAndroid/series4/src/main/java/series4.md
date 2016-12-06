###Demo1(单例定义，写法)
    /**
     * 单例模式： 在程序运行其间，保存类对象只会创建一次（确保只有一个实例）
     * <p>
     * 实现过程：
     * <p>
     * 1. 私有化构造方法
     * <p>
     * 2. 提供本类的实例对象（好多种）
     * <p>
     * 3. 向类的外部提供一个方法，获取类的对象
     * 为什么使用单例：1.能避免实例重复创建 2.应用于避免存在多个实例引起程序逻辑错误的场合3.较节约内存
     */
    public class Demo1 {
        public static void main(String[] args) {
    
            Singleton tv1 = Singleton.getInstance2("张三");
            Singleton tv2 = Singleton.getInstance2("李四");
    
            System.out.println(tv1 == tv2);//true//比较的是内存地址
            tv2.speak();//张三
        }
    }
    
    
    class Singleton {
        String name;
    
        //1.私有化构造方法
        private Singleton(String name) {
            this.name = name;
        }
    
        //2.提供本类的对象
        private static Singleton singleton1;
    
        /*
            //写法一:同步懒汉式,3.向外部提供可访问的方法，并返回当前类的对象
            public synchronized Singleton getInstance1(String name) {
                if (singleton1 == null) {
                    singleton1 = new Singleton(name);
                }
                return singleton1;
            }*/
        //写法二：优化后的懒汉式,方法一中的同步冗余,3.向外部提供可访问的方法，并返回当前类的对象
        public static Singleton getInstance2(String name) {
            if (singleton1 == null) {
                synchronized (Singleton.class) {
                    if (singleton1 == null) {
                        singleton1 = new Singleton(name);
                    }
                }
            }
            return singleton1;
        }
    
        ////////////////////////////////////////////
        //写法三:饿汉式2.提供本类的对象
        private static Singleton singleton3 = new Singleton("default");
    
        //3.向外部提供可访问的方法，并返回当前类的对象
        public static Singleton getInstance3() {
            return singleton3;
        }
    
        ////////////////////////////////////////////
        //写法四：内部类
    
        /**
         * 类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例没有绑定关系，
         * 而且只有被调用到才会装载，从而实现了延迟加载
         */
        private static class SingletonHolder {
            //2.提供本类的对象
            private static final Singleton instance = new Singleton("default");
        }
    
        //3.向外部提供可访问的方法，并返回当前类的对象
        public static Singleton getInstance4() {
            return SingletonHolder.instance;
        }
    
    
        ////////////////////////////////////////////
        public void speak() {
            System.out.println(name);
        }
    
    }
###Demo2(super 、this)
    /**
     * 方法的重写：存在继承关系，方法名、参数、返回数据类型都与父类中方法名和参数相同，
     * 访问权限必须大于或等父类的访问权限
     * <p>
     * 注意：
     * 1. 父类的私有方法不能被重写
     * 2. 静态只能覆盖静态
     * <p>
     * this和super的使用：
     * <p>
     * this 代有当前类的引用，可以通过this.成员形式来访问成员变量和方法
     * 可以通过this() 来调用本类的其它构造方法，但必须在第一行
     * <p>
     * super:代表是父类的数据空间，并不是一个引用，因此没有对象可以指向
     * 可以通过 super.父类成员来访问父类的成员变量和成员方法
     * 也可以通过super()来调用父类的构造方法，如果父类不存在无参的构造方法，
     * 在子类中必须调用super(),来指明初始化父类成员变量的构造方法，而且必须在第一行
     * <p>
     * 注： super() 和 this()不能同时出现，this和super不能出现静态成员方法中
     */
    public class Demo2 {
        public static void main(String[] args){
            Parent parent=new Child(); //多态
            parent.say("您好");//父类说...您好
                              //子类说...您好
    
            parent.print(); //父类打印...
        }
    }
    
    class Parent {
    
        public void say(String msg) {
            System.out.println("父类说..." + msg);
        }
    
        public static void print() {
            System.out.println("父类打印...");
        }
    
    }
    
    
    class Child extends Parent {
    
        //重写父类的方法可以扩展功能
        public void say(String msg) {
            super.say(msg); //调用父类的成员方法
    
            System.out.println("子类说..." + msg);
        }
    
        public static void print() { //重写父类的静态方法时，只能以静态的方式覆盖
            //super.print(); //this和super不能出现在静态成员方法中
            System.out.println("子类打印...");
        }
    
    }
###Demo3(final)
    /**
     * final(C++ const)： 最终的，修饰类、成员方法、成员变量、局部变量
     * <p>
     * 注意：
     * 1、final修饰的类，不能被继承
     * 2、final修饰的方法，不能被重写
     * 3、final修饰的成员变量（局部变量），不能被修改
     * 4.String类就是final 修饰的类
     */
    public class Demo3 {
    
        public static void main(String[] args) {
            Circle c = new Circle(5);
            System.out.println(String.format("%.2f", c.area()));
        }
    }
    
    final class Test1 { //这是一个最终的类
    
    }
    
    /*
    class C_Test extends Test1{ //不能继承final类
    
    }
    */
    
    class Test2 {
    
        public final void area() { //final修饰的方法不能被子类重写
    
        }
    }
    
    class B_Test2 extends Test2 {
        final int a = 10;
    
        public void area(final int w, final int h) {
            //a=90;//变量不能被修改
            //w=w*h;
    
            final Test2 t2 = new Test2();
    
            //final 修饰的引用不能再指向其它对象
            //t2=new Test2();  //出错
        }
    }
    
    //求圆的面积 s=PI*r*r
    class Circle {
        public static final double PI = 3.1415;
    
        private int radius; //半径
    
    
        public Circle(int radius) {
            this.radius = radius;
        }
    
        public double area() {
            return PI * radius * radius;
        }
    
    }
###Demo4(抽象类 abstract)
    /**
     * abstract:  抽象的，包含抽象方法的类叫抽象类
     * <p>
     * 说明： 抽象类也是一个类，只不过没有足够的信息来描述某一事物行为的方法
     * <p>
     * 特点：
     * <p>
     * 1、抽象类不能创建对象，因为其中包含了未实现的抽象方法
     * 2、继承抽象类的子类，如果没有实现抽象方法，则这个类也是抽象类
     * <p>
     * <p>
     * 思考：
     * 1、 抽象类一定是父类？ 一定是父类
     * 2、 抽象类是否有构造方法?  有构造方法，用于初始化类中的成员变量
     * <p>
     * 抽象类和普通类区别：
     * 相同点：  都是类，可以被继承
     * 不同点：
     * 抽象类不可以创建对象，普通类可以创建对象
     * 抽象类可以包含抽象方法，普通类不能包含抽象方法
     * <p>
     * abstract不能与以下关键字组合使用：
     * <p>
     * final: final修饰的类不能被继承，abstract类必须要被继承(不然没意义)
     * static:  静态方法可以直接通过类名被调用，抽象方法不能被调用
     * private: 私有方法不能被重写，抽象方法必须被重写
     */
    public class Demo4 {
    
        public static void main(String[] args) {
    
           //Circle1 c=new Circle1(6); //不能创建抽象类的对象
    
            Rectangle r=new Rectangle(8,10);
    
            System.out.println(r.area());//80.0
        }
    }
    abstract class Shape{
        public abstract double area();
    }
    
    abstract class Circle1 extends Shape{
        public static final double PI=3.14;
        private int radius;
    
        public Circle1(){}
        public Circle1(int radius){ this.radius=radius;}
    
        public  abstract double area();
    }
    
    class Rectangle extends Shape{
        private int width;
        private int height;
    
        public Rectangle(int width,int height){
            this.width=width;
            this.height=height;
        }
    
        public double area(){ //实现抽象方法
            return width*height;
        }
    }
    
    abstract class  Test3{ //注：抽象类中可以不存在抽象方法
    
    }
    
    class C_Test3 extends Test3{
    
    }
###Demo5(interface 接口)
    /**
     * interface: 接口
     * <p>
     * 定义格式：  interface 接口名{  全局常量; 抽象方法;  }
     * <p>
     * 特点：
     * 1、 接口可以实现多继承
     * 2、 接口主要用于被实现，接口中的所有方法，在子类中必须全部实现
     * <p>
     * 在定义接口实现类的时，使用implements关键字，而且可以多实现
     * <p>
     * 扩展：
     * 类和类是继承关系
     * 类和接口是实现关系
     * <p>
     * 通过继承可以得到继承体系统中基本功能
     * 通过实现可以得到除继承之外的额外功能
     * <p>
     * 注： 一个可以存在继承关系同时也可以存实现关系
     */
    public class Demo5 {
    
        public static void main(String[] args) {
            System.out.println(AllAnimalListener.type); //可以通过接口名直接访问全局变量//动物
    
            //AllAnimalListener all=new AllAnimalListener(); //接口不能创建对象
    
            Listener listener = new Animal();
            listener.walk();//动物在走...
    
            AllAnimalListener animalListener = new Animal();
            animalListener.run();//最佳最近调用原则：多态性中体现//动物在跑...
        }
    }
    
    interface Listener {
        //声明全局常量
    
        void walk();
    }
    
    interface CatListener {
        void talk();
    }
    
    //接口的多继承,因为所有接口中方法都没有实现，不会存在调用的不确定性问题
    interface AllAnimalListener extends CatListener, Listener {
        static final String type = "动物";
    
        void run();
    }
    
    class Animal implements AllAnimalListener, CatListener, Listener { //一个类可实现多个接口
    
        //必须要实现或重写接口的方法 CatListener
        @Override
        public void talk() {
            System.out.println(type + "在说话...");
        }
    
        //必须要实现或重写接口的方法 Listener
        @Override
        public void walk() {
            System.out.println(type + "在走...");
        }
    
        //必须要实现或重写接口的方法 AllAnimalListener
        @Override
        public void run() {
            System.out.println(type + "在跑...");
        }
    }
####Demo6(多态)
    /**
     * 对象的多态性： 多种形态，父类类型的引用指向子类对象
     * <p>
     * 前提： 存在继承或实现关系
     * <p>
     * class 动物{
     * public void eat(){}
     * }
     * <p>
     * class 猫 extends 动物{
     * <p>
     * }
     * <p>
     * 常态：  猫看成是猫   猫 c=new 猫();
     * 多态：  猫是动物     动物 d=new 猫(); //第一种方式体现多态
     * <p>
     * <p>
     * void 方法名（动物 d){  //第二种方式体现多态
     * d.eat();
     * <p>
     * }
     * <p>
     * 动物 方法名(int type){ //第三种方式体现多态
     * if(type==1){
     * return new 猫();
     * }
     * <p>
     * return new 狗();
     * }
     * <p>
     * 多态的弊端： 只能使用父类中定义的方法，并且子类必须重写父类中的方法
     * <p>
     * 多态的好处： 提高程序的扩展性，前期定义的功能（方法）可以被后期事物实现（使用）
     * 1.有继承或者实现接口的关系
     * 2.重写或者实现父类（接口）的方法
     * 3.父类指针指向子类对象
     */
    public class Demo6 {
        public static void main(String[] args) {
            Cat cat = new Cat();//常态
            cat.eat();//猫吃鱼
            cat.catchMouse();//猫抓老鼠
    
            Animal1 a1 = new Cat(); //多态，第一种方式
            //a1.eat();
            //a1.catchMouse();//出错，因为父类中没有声明此方法
    
            Animal1 a2 = new Dog();//多态
            //a2.eat();
    
            eat(a1);//猫吃鱼
                    //小猫正在吃。。。。
            eat(a2);//狗吃骨头
                    //小狗正在吃。。。。
        }
    
        public static void eat(Animal1 animal) { //第二种方式体现多态性
            animal.eat(); //调用是Animal实际对象的方法，实际对象可能是Cat、Dog的类对象
    
            //通过instanceof关键字判断对象是哪一种类型的对象
            if (animal instanceof Cat) {
                System.out.println("小猫正在吃。。。。");
            } else {
                System.out.println("小狗正在吃。。。。");
            }
    
        }
    }
    
    
    abstract class Animal1 {
        public abstract void eat(); //虚方法
    }
    
    class Cat extends Animal1 {
        public void eat() {
            System.out.println("猫吃鱼");
        }
    
        public void catchMouse() {
            System.out.println("猫抓老鼠");
        }
    }
    
    class Dog extends Animal1 {
        public void eat() {
            System.out.println("狗吃骨头");
    
        }
    
        public void kanjia() {
            System.out.println("看家");
        }
    }
###Demo7(向上，向下转型)
    /**
     * 多态第三种体现方式
     * 转型：
     * 向上转型：  子类类型向父类类型转换（自动--多态的体现）
     * 向下转型：  当子类中扩展的方法被调用时，需要将对象转成子类类型对象
     * <p>
     * 注意： 为了减少错误，在强转之前，可以通过instanceof判断对象是否为某一种类型
     */
    public class Demo7 {
        public static void main(String[] args) {
    
    
            Animal2 a1 = new Cat1(); //向上转换，子类对象转成父类对象
    
            eat(a1);//猫吃鱼
            //小猫正在吃。。。。
            // 猫抓老鼠
    
            Animal2 a2 = newAnimal(Animal2.TYPE_DOG);
            eat(a2);//狗吃骨头
            //小狗正在吃。。。。
            //看家
    
        }
    
        public static void eat(Animal2 animal) { //第二种方式体现多态性
            animal.eat(); //调用是Animal实际对象的方法，实际对象可能是Cat、Dog的类对象
    
            //通过instanceof关键字判断对象是哪一种类型的对象
            if (animal instanceof Cat1) {
                System.out.println("小猫正在吃。。。。");
    
    
                //需要调用Cat中扩展的方法
                Cat1 c = (Cat1) animal; //向下转型，父类对象向子类对象转型
                c.catchMouse();
    
            } else {
                System.out.println("小狗正在吃。。。。");
    
                Dog1 d = (Dog1) animal;
                d.kanjia();
            }
    
        }
    
        //第三种体现多态性，根据类型创建某一动物的对象
        public static Animal2 newAnimal(int type) {
            if (type == Animal2.TYPE_CAT) {
                return new Cat1();
            } else if (type == Animal2.TYPE_DOG) {
                return new Dog1();
            }
    
            return null;
        }
    
    }
    
    abstract class Animal2 {
        public static final int TYPE_CAT = 1;
        public static final int TYPE_DOG = 2;
    
        public abstract void eat(); //虚方法
    }
    
    class Cat1 extends Animal2 {
        public void eat() {
            System.out.println("猫吃鱼");
        }
    
        public void catchMouse() {
            System.out.println("猫抓老鼠");
        }
    }
    
    class Dog1 extends Animal2 {
        public void eat() {
            System.out.println("狗吃骨头");
    
        }
    
        public void kanjia() {
            System.out.println("看家");
        }
    }
###Demo8(接口的多态体现)
    /**
     * 接口中的多态
     * 接口与多态
     * <p>
     * 接口是一种引用数据类型，定义接口的引用指向到接口实现类对象， 则是接口体现多态的方式
     */
    public class Demo8 {
    
        public static void main(String[] args) {
            Listen l1 = new Animal3(); //接口的多态
    
            l1.walk();//动物在走
            l1.music();//动物在唱歌
    
            Listen l2 = new Person();
            l2.walk();//人在走
            l2.music();// 人在唱歌
        }
    }
    
    interface Listen {
        void music();
    
        void walk();
    
    }
    
    class Animal3 implements Listen {
    
    
        @Override
        public void music() {
            System.out.println("动物在唱歌");
        }
    
        @Override
        public void walk() {
            System.out.println("动物在走");
        }
    }
    
    class Person implements Listen {
    
        @Override
        public void music() {
            System.out.println("人在唱歌");
        }
    
        @Override
        public void walk() {
            System.out.println("人在走");
        }
    }
###Demo9(多态中的调用)
    /**
     * 多态中成员特点：
     * <p>
     * 成员变量： 能访问哪些成员变量，编译和运行时都看父类
     * 成员方法： 访问哪些方法，编译时看父类，其运行结果要看子类
     * <p>
     * 静态成员：  都看父类
     */
    public class Demo9 {
        public static void main(String[] args) {
            Parent1 parent1 = new Child1();
            System.out.println("num->" + parent1.num); //成员变量的结果：在编译和运行都看父类//num->20
    
            parent1.say();//运行哪一个方法，编译时看父类，运行时看子类//Child1 say()
    
            parent1.fun();//运行哪一个方法：(静态)编译和运行时都看父类//Parent1 static fun()
    
    
            Child1 child1 = (Child1) parent1;
            System.out.println("num->" + child1.num);//num->50
            child1.say();//Child1 say()
            child1.fun();//Child1 static fun()
        }
    }
    
    class Parent1 {
        int num = 20;
    
        public void say() {
            System.out.println("Parent1 say()");
        }
    
        public static void fun() {
            System.out.println("Parent1 static fun()");
        }
    
    }
    
    class Child1 extends Parent1 {
        int num = 50;
    
        public void say() {
            System.out.println("Child1 say()");
        }
    
        public static void fun() {
            System.out.println("Child1 static fun()");
        }
    
    }
###Demo12(接口运用场景、接口回调)
    /**
     * 接口有什么用
     * 使用场景:你叫舍友给你收一下衣服，收完之后给你说一声；
     * 建模: CallBack(收完衣服的结果) Sheyou(舍友)  You(你)
     * 接口回调
     */
    public class Demo10 {
        public static void main(String[] args) {
            You you = new You();//创建一个你
            Sheyou leifeng = new Sheyou("雷锋");  //创建一个雷锋同学
            you.requestShouyifu(leifeng);//委托雷锋舍友收衣服
        }
    }
    
    
    interface CallBack {
        void result(String msg);
    }
    
    class You implements CallBack {
        /**
         * 请求舍友帮你收衣服(客气点)
         *
         * @param sheyou
         */
        public void requestShouyifu(Sheyou sheyou) {
            System.out.println(sheyou.name + "请帮我收一下衣服，要下雨了");
            sheyou.shouyifu(this);
        }
    
        @Override
        public void result(String msg) {
            System.out.println("我知道" + msg);
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
![]()