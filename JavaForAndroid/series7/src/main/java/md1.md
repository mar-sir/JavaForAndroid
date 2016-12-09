###让我们带着泛型的目光回顾 TreeSet中涉及Collections、Comparator、Comparable
我们说过TreeSet存储的元素是要支持可排序的，那他有两种方式，一是实现Comparable接口,二是在构造TreeSet实例的时候传一个Comparator实例。
我们先看源码：

* Comparable
   
       package java.lang;
       
       public interface Comparable<T> {//一个泛型接口
           int compareTo(T var1);
       }
这就是Comparable所有的代码，简单吧.


* Comparator代码巨多，我们也就只看一行
        
        public interface Comparator<T> {
            int compare(T var1, T var2);
            ...... 
         }
和Comparable很像;

* Collections集合工具类，代码巨多，我们也就只看几行
 
         public static <T extends Comparable<? super T>> void sort(List<T> var0) {
                 var0.sort((Comparator)null);
             }
         
       
         public static <T> void sort(List<T> var0, Comparator<? super T> var1) {
              var0.sort(var1);
            }
 当初也许你会很好奇，这个类凭什么帮你排序，现在你知道了吧，你所传的实例都被泛型限定好了，这里出现了一个以前没说过的"?"号，我们先忽略它。
 两个sort方法，要么实现Comparable，要么是Comparator，但有一点他们是统一的，就是都是用确定下限的泛型方式。加深印象!
 
####案例 Comparator泛型的确定下限
* Animal(基类)

        public class Animal {
             int age;
             String name;
        
            public Animal(int age, String name) {
                this.age = age;
                this.name = name;
            }
        
            @Override
            public String toString() {
                return "[" + this.name + "\t" + this.age + "]";
            }
        }
 
* Cat（子类）
 
        public class Cat extends Animal {
        
            public Cat(int age, String name) {
                super(age, name);
            }
        
            @Override
            public String toString() {
                return super.age + "";
            }
        }
* 运行 
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series7/src/main/java/images/step5.png?raw=true)
######还有一个?号等着去解决...



   