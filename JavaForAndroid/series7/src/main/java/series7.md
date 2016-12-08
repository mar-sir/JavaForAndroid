###Collcetios、Arrays
* Collections（集合工具类）
#####Collection是集合框架中的一个顶层接口，它里面定义了单列集合的共性方法。             
#####Collections是集合框架中的一个工具类。该类中的方法都是静态的,提供的方法中有可以对list集合进行排序，二分查找等方法。
#####通常常用的集合都是线程不安全的。如果多线程操作这些集合时，可以通过该工具类中的同步方法，将线程不安全的集合，转换成安全的以提高效率

        //根据元素自然顺序 对指定列表按升序排序。此方法内部调用了Comparable 的compareTo()方法。  
          public static <T extends Comparable<? super T>> void sort(List<T> list)  
           
          
        //根据元素的自然顺序，返回给定 collection 的最大元素  
           public <T extends Object &   Comparalbe<? super T>> T max(Collection<? extends T> col)   
          
        // 使用指定元素替换指定列表中的所有元素  
          public static <T> void fill(List<? super T> list,T obj)   
          
        //  使用另一个值替换列表中出现的所有某一指定值。  
          public static T replacAll(List<T>,T oldValue,T newValue)  
        //    反转指定列表中元素的顺序  
          public static void reverse(List<?> list)    
          
        // 返回一个比较器，它强行逆转实现了 Comparable 接口的对象 collection 的自然顺序  
          public static T Comparator<T> reverseOrder()  
          
        //返回一个比较器，它强行逆转指定比较器的顺序  
          public static T Comparator<T> reverseOrder(Comparator<T> cmp)  
          
         public static <T> List<T> synchronizedList(List<T> list)  
         public static void swap(List<T> list,int i,int j  
          
        //如果搜索键包含在列表中，则返回搜索键的索引；否则返回 (-(插入点) - 1)  
          
         public static <T> int binarySearch(List<? extends t> list,T key,Comparator<? extends T> c)   
* Arrays(数组工具类)（看Api文档）
####案例Demo1

        /**
         * Collections
         * <p>
         * Arrays
         */
        public class Demo1 {
            public static void main(String[] args) {
                List<String> list = new ArrayList<>();
                list.add("abc");
                list.add("aaa");
                list.add("adc");
                list.add("bcd");
                list.add("abb");
                System.out.println("\n排序前:");
                sop(list);
        
                //排序
                Collections.sort(list);
                System.out.println("\n排序后:");
                sop(list);
                Collections.reverse(list); //反转
                System.out.println("\n反转:");
                sop(list);
        
        
                //获取最大的值
                String maxStr = Collections.max(list);
                System.out.println("\n最大值:\r\n---->" + maxStr);
        
                String ss = "22 90 34 50 65";
                String[] nums = ss.split(" ");
                List<String> ln = new ArrayList<>();
                for (String n : nums) ln.add(n);
                /////////////////////////////////////////////////////
                //将数组转成集合
                List<String> lns = Arrays.asList(nums);
        
                String maxN = Collections.max(lns);
                System.out.println("\r\n---->" + maxN);
        
                //将集合转成数组： 可以固定集合大小，不允许再出现删除和增加操作
                String[] str = lns.toArray(new String[lns.size()]);
                System.out.println(str);
            }
        
            static void sop(List<String> list) {
                for (String s : list)
                    System.out.print(s + " ");
            }
        }
##泛型
泛型字面意思不知道是什么类型，但又好像什么类型都是。看前面用到的集合都有泛型的影子。

        public class ArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, Serializable {
        ... 
        }
以ArrayList为例,它为什么要写成ArrayList<E>这样.我也不知道他为什么要写成这样，但是我知道如果它不用泛型，那代码就乱了，那也别写代码了。

* ArrayList运用泛型可以这么写

          ArrayList<String> strings = new ArrayList<>();//可以存String
          ArrayList<Integer> integers = new ArrayList<>();//可以存Integer类型
          ArrayList<Object> objects = new ArrayList<>();//可以存对象
* ArrayList没用泛型之后:
如果要存放各种各样的样类型，是不是意味着写各种各样对象的链表，那开发者可以不用活了...咦，或者你可以可不用死了，你发现所有类都继承自Object类，那只要这么写一个 ![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series7/src/main/java/images/step1.png?raw=true)，
在取出元素的时候强转成对应的类型就可以了，是的，这样就可以不会被写代码累死了。但为什么源码没有这么写，因为它没泛型强大！让我们看下面代码了解泛型的由来。
######假如我要写一个类存放一个int类型的模型，那简单
        
           public class IntegerFun {
             private int data;
           
               public int getData() {
                   return data;
               }
           
               public void setData(int data) {
                   this.data = data;
               }
           } 
######满足你的需求，但需求变了，我还要一个存放String类型的，那你也忍了，再来一个

          public class StringFun {
          
              private String data;
          
              public String getData() {
                  return data;
              }
          
              public void setData(String data) {
                  this.data = data;
              }
          }
######需求又添加了一个，存放Long、Student、Math.....于是撕逼开始...结束之后，这次你聪明了，写了一个万能的，管它存放什么都行的类：

        public class ObjectFun {
            private Object data;
        
            public Object getData() {
                return data;
            }
        
            public void setData(Object data) {
                this.data = data;
            }
        }
这样总算解决了问题，看用法：![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series7/src/main/java/images/step2.png?raw=true)
你总觉得你写的前无故人，后无来者了，可是经理还是过来找你了，因为你的程序跑不起来了，你认真的看了一下，发现代码第十五行，存放的是Integer 结果你转成了Float出错了，那你可能会抱怨编译器
没有立即告诉你这里存在问题，接下来我们来看看运用泛型会怎么样。
    
        public class Fun<T> {
            private T data;
        
            public T getData() {
                return data;
            }
        
            public void setData(T data) {
                this.data = data;
            }
        }
######用法:![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series7/src/main/java/images/step3.png?raw=true)
######这就是使用泛型的原因.