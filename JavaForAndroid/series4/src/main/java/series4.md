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