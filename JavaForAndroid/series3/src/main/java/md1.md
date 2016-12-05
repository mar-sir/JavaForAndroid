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