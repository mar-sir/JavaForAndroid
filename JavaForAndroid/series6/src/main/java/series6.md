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
* HashMap、LinkedHashMap、TreeMap
###Collection（因为确定大小的数组不能满足动态改变内存分配大小的问题，所以有集合）
####Collection
        boolean add(E e) //向集合中添加一个元素，若添加元素后集合发生了变化就返回true，若没有发生变化，就返回false。
        boolean addAll(Collection<? extends E> c) //添加给定集合c中的所有元素到该集合中
        void clear() //(optional operation).
        boolean contains(Object o) //判断该集合中是否包含指定对象
        boolean containsAll(Collection<?> c)
        boolean equals(Object o)
        int hashCode()
        boolean isEmpty()
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
####List
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

    
