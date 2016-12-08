###Demo1(Date类)
    /**
     * Date类
     */
    public class Demo1 {
        public static void main(String[] args) {
    
            Date date = new Date();//获取当前的时间
    
            System.out.println(date.toString());
    
            long time = date.getTime();
    
            Date d2 = new Date(time);
    
            System.out.println(d2.toString()); //获取Long类型的时期值
    
            //使用定义好的日期格式化工具类
            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);//获取日期的格式化对象
            DateFormat dtf = DateFormat.getDateTimeInstance();//获取日期和时间格式化对象
    
            System.out.println(df.format(date));
            System.out.println(dtf.format(date));
    
            try {
                Date d3 = df.parse("17-07-19");
                System.out.println(d3.toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
    
            //自定义格式化日期或时间
            //注：月 MM,分钟：mm,ss: 秒,SSS:毫秒
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
            System.out.println(sdf.format(date));
    
    
        }
    }
####运行结果
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series6/src/main/java/images/step1.png?raw=true)
###java集合框架
![](http://static.open-open.com/lib/uploadImg/20160918/20160918105654_491.gif)
####Collection接口
* List接口
  ArrayList、LinkedList、Vector、Stack
* Set接口
  HashSet、LinkedHashSet、TreeSet
  
####Map接口
* HashMap、Hashtable、LinkedHashMap、TreeMap
###Collection（因为确定大小的数组不能满足动态改变内存分配大小的问题，所以有集合）
####Collection
        boolean add(E e) //向集合中添加一个元素，若添加元素后集合发生了变化就返回true，若没有发生变化，就返回false。
        boolean addAll(Collection<? extends E> c) //添加给定集合c中的所有元素到该集合中
        void clear() //(optional operation).
        boolean contains(Object o) //判断该集合中是否包含指定对象
        boolean containsAll(Collection<?> c)
        boolean equals(Object o)
        int hashCode()
        boolean isEmpty()//size==0?
        Iterator<E> iterator()
        boolean remove(Object o) //移除给定对象的一个实例（有的具体集合类型允许重复元素）
        boolean removeAll(Collection<?> c) //移除元素集合c
        boolean retainAll(Collection<?> c) //仅保留给定集合c中的元素
        int size()
        Object[] toArray()
        <T> T[] toArray(T[] a)
####代码列举Demo2
        public class Demo2 {
            public static void main(String[] args) {
                Collection datas = new LinkedList();//可以不像数组那样指定大小
                datas.add("aaa");//添加元素
                System.out.println(datas.add("bbb"));//true
                if (!datas.contains("ccc")) {
                    datas.add("ccc");
                }
                ///////////////////////////////////////////
                Collection datas1 = new ArrayList();
                datas1.add("aaa");
                datas1.add("bbb");
                //判断子集合中的所有对象是否存在
                if (datas.containsAll(datas1)) {//true
                    System.out.println("datas包含datas1");//输出
                }
                Collection datas3 = new ArrayList(10);
                datas3.add("eee");
                datas3.add("fff");
                datas3.add("ggg");
                datas.addAll(datas3);
                //////////////////////////////////////////
                System.out.println(datas);//[aaa, bbb, ccc, eee, fff, ggg]
                System.out.println(datas.size());//6   
                datas.remove("ccc");
                datas.retainAll(datas3);
                System.out.println(datas);//[eee, fff, ggg]
                datas.clear();
                System.out.println(datas.size());//0    
                Iterator iterator = datas1.iterator();//迭代器
                while (iterator.hasNext()) {
                    System.out.println(iterator.next());//输出datas1中所有元素
                }
            }
        }
####List(存储对象有序，可以包含重复元素)
* 方法相比Collection多了如下:
    
        E get(int var1);//返回指定下标的元素
    
        E set(int var1, E var2);//修改指定下标的值
    
        void add(int var1, E var2);//在指定位置添加元素
    
        int indexOf(Object var1);//返回指定元素的下标
    
        int lastIndexOf(Object var1);//返回指定元素的最后一个的下标
    
        ListIterator<E> listIterator();//迭代器
    
        List<E> subList(int var1, int var2);//链表截取
#####代码例举:
        /**
         * List
         */
        public class Demo3 {
            public static void main(String[] args) {
                List list1 = new ArrayList();
                list1.add("aaa");
                list1.add("bbb");
                list1.add("ccc");
                list1.add("ddd");
                list1.add("eee");
                list1.add("fff");
                list1.add("ggg");
                System.out.println(list1.get(4));//eee
                System.out.println(list1);//[aaa, bbb, ccc, ddd, eee, fff, ggg]
                list1.set(2, "eee");
                list1.add(3, "zzz");//指定位置添加元素
                System.out.println(list1);//[aaa, bbb, eee, zzz, ddd, eee, fff, ggg]
                System.out.println(list1.indexOf("eee"));//2
                System.out.println(list1.lastIndexOf("eee"));//5
                System.out.println(list1.subList(2, 4));//返回[2,4)左右开的元素//[eee, zzz]
            }
        }
####ArrayList（底层数组实现（查询快，增删慢））
* 当容量不够的时候添加的容量是当前的1.5倍
* Vector基本用法和ArrayList一样，区别是线程安全（基本不用）
* 底层数组实现（查询快，增删慢）

        /**
         * ArrayList 基本用法同Demo3 
         */
        public class Demo4 {
        
            public static void main(String[] args) {
                ArrayList<String> list1 = new ArrayList<String>();
                list1.add("aaa");
                list1.add("bbb");
                list1.add("ccc");
                list1.add("ddd");
                list1.add("eee");
                list1.add("fff");
                list1.add("ggg");
                //错误写法
                /*
                for (String s : list1) {
                    list1.remove(s);//Exception in thread "main" java.util.ConcurrentModificationException
                }*/
                Iterator<String> iterator = list1.iterator();
                //错误写法
               /* while (iterator.hasNext()) {
                    iterator.remove();//Exception in thread "main" java.lang.IllegalStateException
                }*/
                //正确写法
                while (iterator.hasNext()) {
                    iterator.next();
                    iterator.remove();
                }
                System.out.println(list1);
            }
        }
[ArrayList源码剖析](https://gold.xitu.io/post/581bdff18ac247004fe09b8e)
####LinkedList（用链表实现（增删快，查询慢））
        void addFirst(E element);
        void addLast(E element);
        E getFirst();
        E getLast();
        E removeFirst();
        E removeLast();
        boolean add(E e) //把元素e添加到链表末尾
        void add(int index, E element) //在指定索引处添加元素
都可以从字面上了解它的方法含义。
* 用链表实现（增删快，查询慢）
[LinkedList源码剖析](https://gold.xitu.io/post/58204cd2a0bb9f0058bd388f)
###Set(存储元素无序，不能有重复元素)
####HashSet
        /**
         * Set
         * 存储对象无序，并且唯一
         * 如何判断对象的唯一性：根据Object提供的 int hashCode()和boolean equals(Object obj)方法
         * 唯一性的过程：  先调用对象的hashCode()方法，如果哈希值不相同，则直接添加到集合中，
         * 若哈希值相同，则会调用eqauls()方法判断内容是否相同，若返回false，则表示内容不同，
         * 那么将其添加到集合中，反之，返回true时，则不添加到集合中
         */
        public class Demo5 {  
            public static void main(String[] args) {
                Set set = new HashSet();
                set.add("aaa");//添加的时候就判断唯一性
                set.add("bbb");
                set.add("ccc");
                set.add("aaa");
                set.add("ddd");
                set.add("aacca");
                set.add("aaa");
                System.out.println(set);//[aaa, ccc, bbb, ddd, aacca]
                Boolean b = false;
                //注：hashCode()相同时，并不一定代表是同一类型的对象
                System.out.println(b.hashCode() + "," + new Integer(1237).hashCode());
            }
        }
####TreeSet(比HashSet多了一个排序功能)
        /**
         * TreeSet:  数据结构是黑红二叉树，保存数据的唯一性同HashSet，同时增加的对象必须是可排序的
         * <p>
         * 排序方式：
         * 1、 增加的对象类，实现Comparable接口
         * 2、 创建比较器，需要创建类，并实现Comparator接口
         */
        public class Demo6 {
            public static void main(String[] args) {   
                TreeSet treeSet = new TreeSet();
                //添加对象时，先确保对象的唯一性，再调用String.compareTo(Object obj)比较大小
                //默认排序方式：从小到大排序（依字符的ASCII码值或字符串长度）
                treeSet.add("aaa");
                treeSet.add("ccc");
                treeSet.add("bbb");
                treeSet.add("aaa");
                treeSet.add("eee");
                Iterator iterator = treeSet.iterator();
                while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                }
                System.out.println(treeSet);//[aaa, bbb, ccc, eee]
            }
        }
####TreeSet添加的元素必须实现Comparable接口
        /**
         * 实现Comparable接口
         */
        public class Demo7 { 
            public static void main(String[] args) {
                //方法一
                TreeSet<Person> treeSet = new TreeSet();
                treeSet.add(new Person("111"));
                treeSet.add(new Person("444"));
                treeSet.add(new Person("111"));
                treeSet.add(new Person("222"));
                treeSet.add(new Person("333"));       
                System.out.println(treeSet);//[111, 222, 333, 444]
                //////////////////////////
                //方法二
                TreeSet<Animal> treeSet1 = new TreeSet(new MyCompartor());
                treeSet1.add(new Animal(111));
                treeSet1.add(new Animal(444));
                treeSet1.add(new Animal(111));
                treeSet1.add(new Animal(222));
                treeSet1.add(new Animal(333)); 
                System.out.println(treeSet1);//[111, 222, 333, 444]
            }
            //方法一
            static class Person implements Comparable {
                private String name; 
                public Person(String name) {
                    this.name = name;
                }  
                @Override
                public int compareTo(Object o) {
                    return this.name.compareTo(((Person) o).name);
                }
                @Override
                public String toString() {
                    return this.name;
                }
            }
            //方法二
            static class Animal {
                private int age;
                public Animal(int age) {
                    this.age = age;
                }
                @Override
                public String toString() {
                    return this.age + "";
                }
            }
            static class MyCompartor implements Comparator<Animal> {
                @Override
                public int compare(Animal animal, Animal t1) {
                    return animal.age - t1.age;
                }
            }
        }
###Map(映射，存储的是“键-值”映射表，“键”是不能重复的)
如果键重复，则相当于修改对应键的值。
####Map接口定义方法

        int size();//获取map大小
        
        boolean isEmpty();//size==0?
    
        boolean containsKey(Object var1);//查看是否包含某个键
    
        boolean containsValue(Object var1);//查看是否包含某个值
    
        V get(Object var1);//跟据key获取值
    
        V put(K var1, V var2);//Map接口有两个类型参数，K和V，分别表示键(Key)和值(Value)的类型,按Key值var1保存值var2,如果键重复，则相当于修改对应键的值。
    
        V remove(Object var1);//移除键对应的值
    
        void putAll(Map<? extends K, ? extends V> var1);//批量保存
    
        void clear();//清空map
    
        Set<K> keySet();//获取Map中键的集合
    
        Collection<V> values();//获取Map中值的集合
    
        Set<Map.Entry<K, V>> entrySet();//获取Map中值的键值对（遍历）
        
        public interface Entry<K, V> {
                K getKey();//键
        
                V getValue();//值
        
                V setValue(V var1);//修改键 
        
                boolean equals(Object var1);
        
                int hashCode();
       
            }
####方法使用简介（以HashMap实现类为例）
####HashMap 存储的数据是没有顺序的，键或值可以为null
        /**
         * Map
         */
        public class Demo8 {
        
            public static void main(String[] args) {
                //key   //value//Map<K,V>
                Map<Integer, String> map = new HashMap<>();
                map.put(1, "aaa");//添加元素
                map.put(2, "www");
                map.put(3, "assaa");
                map.put(4, "qqq");
                map.put(5, "ggg");
                map.put(1, "nnn");//修改元素
                map.put(6, "ooo");
                map.put(7, "232");
                map.put(12, "ffds");
                System.out.println(map.size() + "");//获取大小//8
                //////////////////////
                System.out.println(map.isEmpty());//size==0?//false
                //////////////////////
                System.out.println(map.containsKey(10));//查看是否包含某个键//false
                /////////////////////
                System.out.println(map.containsValue("ooo"));//查看是否包含某个值//true
                /////////////////////
                System.out.println(map.get(3));//跟据key获取值//assaa
                /////////////////////
                map.remove(12);//移除键对应的值
                System.out.println(map.containsKey(12));//false
                /////////////////////
                Map<Integer, String> map1 = new HashMap<>();
                map.put(100, "999");//添加元素
                map.put(110, "222");//添加元素
                map.put(120, "333");//添加元素
                map.putAll(map1);//批量保存
                Set<Integer> integers = map.keySet();//获取Map中键的集合
                System.out.println(integers);//[1, 2, 3, 4, 100, 5, 6, 7, 120, 110]
                ////////////////////////
                Collection<String> values = map.values();//获取Map中值的集合
                System.out.println(values);//[nnn, www, assaa, qqq, 999, ggg, ooo, 232, 333, 222]
                ////////////////////////
                Set<Map.Entry<Integer, String>> entries = map.entrySet();//迭代
                Iterator<Map.Entry<Integer, String>> iterator = entries.iterator();
                while (iterator.hasNext()) {
                    Map.Entry<Integer, String> mapNext = iterator.next();
                    System.out.print(mapNext.getKey() + "-->" + mapNext.getValue() + "\t");
                    //1-->nnn	2-->www	3-->assaa	4-->qqq	100-->999	5-->ggg	6-->ooo	7-->232	120-->333	110-->222	
                }
        
            }
        }
####Hashtable
#####Hashtable和HashMap的区别
* Hashtable里面的方法几乎都是同步的，线程安全，HashMap则没有，但效率高。（同ArrAyList和Vector）
* Hashtable不允许存放null值(键和值都不可以)，而HashMap可以
#####相同点
* 存放元素无序
####LinkedHashMap继承自HashMap
* LinkedHashMap 实现与 HashMap 的不同之处在于，LinkedHashMap 维护着一个运行于所有条目的双重链接列表。此链接列表定义了迭代顺序，
  该迭代顺序可以是插入顺序或者是访问顺序(参考以下代码理解)
* 不是线程安全
####Demo9
          /**
           * LinkedHashMap
           * LinkedHashMap和HashMap区别
           * LinkedHashMap 保存了记录的插入顺序
           * HashMap 则无序存放
           */
          public class Demo9 {
              public static void main(String[] args) {
                  //关注点一：看添加之后的输出结果对比
                  System.out.println("关注点一：LinkedHashMap输出:");
                  LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap();
                  linkedHashMap.put(1, "aaa");//添加元素
                  linkedHashMap.put(7, "www");
                  linkedHashMap.put(5, "ggg");
                  linkedHashMap.put(1, "nnn");//修改元素
                  linkedHashMap.put(6, "ooo");
                  linkedHashMap.put(7, "232");
                  linkedHashMap.put(12, "ffds"); 
                  Set<Map.Entry<Integer, String>> entries = linkedHashMap.entrySet();
                  Iterator<Map.Entry<Integer, String>> iterator = entries.iterator();
                  while (iterator.hasNext()) {
                      Map.Entry<Integer, String> next = iterator.next();
                      System.out.print(next.getKey() + "-->" + next.getValue() + "\t");
                      //1-->nnn	7-->232	5-->ggg	6-->ooo	12-->ffds
                  }
                  System.out.println();
                  System.out.println("关注点一：HashMap输出:");
                  Map<Integer, String> map = new HashMap<>();
                  map.put(1, "aaa");//添加元素
                  map.put(7, "www");
                  map.put(5, "ggg");
                  map.put(1, "nnn");//修改元素
                  map.put(6, "ooo");
                  map.put(7, "232");
                  map.put(12, "ffds");
                  Set<Map.Entry<Integer, String>> entries1 = map.entrySet();//迭代
                  Iterator<Map.Entry<Integer, String>> iterator1 = entries1.iterator();
                  while (iterator1.hasNext()) {
                      Map.Entry<Integer, String> mapNext = iterator1.next();
                      System.out.print(mapNext.getKey() + "-->" + mapNext.getValue() + "\t");
                      //1-->nnn	5-->ggg	6-->ooo	7-->232	12-->ffds
                  }
                  /////////////////////////////////////////////////////////////////
                  //关注点二：换一个构造方法
                  System.out.println();                                              //10 大小//0.75还不清楚//true代表使用访问顺序
                  LinkedHashMap<Integer, String> linkedHashMap1 = new LinkedHashMap<>(10, 0.75f, true);
                  linkedHashMap1.put(1, "aaa");//添加元素
                  linkedHashMap1.put(7, "www");
                  linkedHashMap1.put(5, "ggg");
                  linkedHashMap1.put(1, "nnn");//修改元素
                  linkedHashMap1.put(6, "ooo");
                  linkedHashMap1.put(7, "232");
                  linkedHashMap1.put(12, "ffds");
                  System.out.println("=======================================================");
                  System.out.println("更换构造方法后未使用元素之前输出");
                  Set<Map.Entry<Integer, String>> entries2 = linkedHashMap1.entrySet();
                  Iterator<Map.Entry<Integer, String>> iterator2 = entries2.iterator();
                  while (iterator2.hasNext()) {
                      Map.Entry<Integer, String> next = iterator2.next();
                      System.out.print(next.getKey() + "-->" + next.getValue() + "\t");
                      //5-->ggg	1-->nnn	6-->ooo	7-->232	12-->ffds
                  }
                  System.out.println();
                  //关键点来了
                  System.out.println(linkedHashMap1.get(6));//ooo
                  System.out.println(linkedHashMap1.get(12));//ffds
                  System.out.println("更换构造方法后未使用元素之后输出");
                  Set<Map.Entry<Integer, String>> entries3 = linkedHashMap1.entrySet();
                  Iterator<Map.Entry<Integer, String>> iterator3 = entries3.iterator();
                  while (iterator3.hasNext()) {
                      Map.Entry<Integer, String> next = iterator3.next();
                      System.out.print(next.getKey() + "-->" + next.getValue() + "\t");
                      //5-->ggg	1-->nnn	7-->232	6-->ooo	12-->ffds
                  }
              }
          }
####运行结果:
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series6/src/main/java/images/step2.png?raw=true)
####LinkedHashMap延伸（用途）
[最近最少使用LRUcache](http://wiki.jikexueyuan.com/project/java-collection/linkedhashmap-lrucache.html)
###TreeMap 
#####使用了二叉权的数据结构，key是有序，保存其唯一性用到了hashCode()、equals()以及比较器（唯一性判断,键排序同TreeSet）
#####案例一Demo10
        /**
         * TreeMap：
         * 使用了二叉权的数据结构，key是有序，保存其唯一性用到了hashCode()、equals()以及比较器（唯一性判断同HashSet）
         */
        public class Demo10 {
            public static void main(String[] args) {
                //来个稍微复杂点的：存放一个Student链表
                //TreeMap<K,V>K类必须实现Comparable<T>接口，用于比较排序
                TreeMap<String, List<Student>> map = new TreeMap<>();
                List<Student> students1 = new ArrayList<>();
                students1.add(new Student("小花", 23));
                students1.add(new Student("小黑", 20));
                students1.add(new Student("小鱼", 29));
                students1.add(new Student("小小", 23));
                map.put("小班", students1);
                List<Student> students2 = new ArrayList<>();
                students2.add(new Student("大花", 230));
                students2.add(new Student("大黑", 200));
                students2.add(new Student("大鱼", 290));
                students2.add(new Student("大大", 230));
                map.put("大班", students2);
                Set<Map.Entry<String, List<Student>>> entries = map.entrySet();
                for (Map.Entry<String, List<Student>> entry : entries) {
                    List<Student> s = entry.getValue();
                    System.out.println(entry.getKey() + ":" + s);
                }
            }
        }
        class Student {
            private String name;
            private int age;
            public Student(String name, int age) {
                this.age = age;
                this.name = name;
            }
            @Override
            public String toString() {
                return "[" + this.name + ":\t" + this.age + "]";
            }
        }
#####运行结果
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series6/src/main/java/images/step3.png?raw=true)
####案例二
        /**
         * TreeMap自定义比较器
         * <p>
         * 案例:按地区存放学校
         * 建模
         * //School
         * //Area
         */
        public class Demo11 {
            public static void main(String[] args) {
                List<School> schools1 = new ArrayList<School>();
                schools1.add(new School("10", "火星1"));
                schools1.add(new School("11", "火星2"));
                schools1.add(new School("12", "火星3"));
                List<School> schools2 = new ArrayList<School>();
                schools2.add(new School("20", "北京1"));
                schools2.add(new School("21", "北京2"));
                schools2.add(new School("22", "北京3"));  
                //如果TreeMap<K,V>的K是自定义类型 ，则此类必须实现Comparable<T>接口，用于比较排序
                Map<Area, List<School>> clsMap = new TreeMap<Area, List<School>>();
                clsMap.put(new Area("1004", "火星"), schools1);
                clsMap.put(new Area("1002", "北京"), schools2); 
                Set<Map.Entry<Area, List<School>>> entrySet = clsMap.entrySet();
                for (Map.Entry<Area, List<School>> cls : entrySet) {
                    List<School> s = cls.getValue();
                    System.out.println(cls.getKey().id+"\t" + cls.getKey().name + ":" + s);
                } 
            }
        }
        //
        class Area implements Comparable<Area> {
            //名字
            String name;
            //编号
            String id; 
            public Area(String id, String name) {
                this.id = id;
                this.name = name;
            }   
            @Override
            public int compareTo(Area o) {
                //先比较班级的名称，如果名称相同，再比较id(也可以先比较id再比较name)
                int r = this.name.compareTo(o.name);
                return r == 0 ? this.id.compareTo(o.id) : r;
            }
            @Override
            public String toString() {
                return this.name + "\t";
            }
        }
        class School {
            private String id;
            private String name; 
            public School(String id, String name) {
                this.id = id;
                this.name = name;
            }
            @Override
            public String toString() {
                return "School[id=" + id + ", name=" + name + "]";
            }
        }
#####运行结果
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series6/src/main/java/images/step4.png?raw=true)


                
