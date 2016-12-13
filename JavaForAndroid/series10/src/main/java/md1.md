###IO流
看着字少，内容着实不少，这里开始就给诸君推荐一篇大神的博客，总结的思路清晰，鬼斧神工，哈哈，总之总结的很好。见地址:
[Java IO流学习总结](http://www.cnblogs.com/oubo/archive/2012/01/06/2394638.html)，也是很好的入坑引言。
[Java IO流学习总结](http://www.cnblogs.com/oubo/archive/2012/01/06/2394638.html)
[Java IO流学习总结](http://www.cnblogs.com/oubo/archive/2012/01/06/2394638.html)
[Java IO流学习总结](http://www.cnblogs.com/oubo/archive/2012/01/06/2394638.html)
写三次应该有人会传送过去的吧。
####IO分类
* 按数据类型分为字符流，字节流。
* 按数据流向分为输入流，输出流。

####输入字节流(InputStrem)     输出字节流(OutputStrem)     字符输入流(Reader)      字符输出流（Writer）
我们先看字符输出流Writer。
####字符输出流----Writer
要了解它，它却很抽象，孤僻，难以交流，那我们就从它子子孙孙开始。首先我们看它孙子FileWriler。
#####FileWriter 继承自OutputStreamWriter
构造方法:
        
         //创建字符输出流类对象和已存在的文件相关联。文件不存在的话，并创建。
         public FileWriter(String var1) throws IOException {
                super(new FileOutputStream(var1));
            }//如:FileWriter fw=new FileWriler("D:files.txt");
            
          //创建字符输出流类对象和已存在的文件相关联,并设置该该流对文件的操作是否为续写。
         public FileWriter(String var1, boolean var2) throws IOException {
                super(new FileOutputStream(var1, var2));
            }//如:FileWriter fw=new FileWriler("D:files.txt",true);//true表示再次写入字符的时候为追加，false表示再次写入字符时，先擦除，在写入（覆盖）
        
          //类似构造方法一
         public FileWriter(File var1) throws IOException {
                super(new FileOutputStream(var1));
            }//如:FileWriter fw=new FileWriter(new File("D:files.txt"));
        
          //类似构造方法二
         public FileWriter(File var1, boolean var2) throws IOException {
                super(new FileOutputStream(var1, var2));
            }//如:FileWriter fw=new FileWriter(new File("D:files.txt")，flase);//覆盖写入
        
          //不常用
          public FileWriter(FileDescriptor var1) {
                super(new FileOutputStream(var1));
            }//如:
可见构造方法都抛异常的，忘了告诉你，上面的已经是FileWriter所有的代码了。
######主要方法:
* void write(String str)写入字符串。当执行完此方法后，字符数据还并没有写入到目的文件中去。此时字符数据会保存在缓冲区中。
                         此时在使用刷新方法就可以使数据保存到目的文件中去。

* void flush() 刷新该流中的缓冲。将缓冲区中的字符数据保存到目的文件中。

* void close() 关闭此流。在关闭前会先刷新此流的缓冲区。在关闭后，再写入或者刷新的话，会抛IOException异常。
#####案例

        /**
         * IO流代码很难看，主要是因为异常处理过多
         */
        public class Demo1 {
            public static void main(String[] args) {
                FileWriter writer = null;
                FileWriter writer1 = null;
        
                FileWriter writer2 = null;
                FileWriter writer3 = null;
                try {
                    //1. 创建FileWriter对象，并在构造方法中指定文件路径
                    writer = new FileWriter(Config.PATH + "testFileWriter1.txt");//此文件是在当前工程目录下
                    //2.向文件字符中写入一串文本数据
                    writer.write("hello");
                    writer.flush();//3、在关闭流之前，先执行刷新//刷一次代表写入一次
        
                    //构造方法的第二个参数，表示是否追加内容
                    writer1 = new FileWriter(Config.PATH + "testFileWriter1.txt");//写入的新的内容会在原内容的后面增加
                    writer1.write("你好-->1");
                    writer1.flush();
        
                    //构造方法的第二个参数，表示是否追加内容
                    writer2 = new FileWriter(Config.PATH + "testFileWriter2.txt");
                    writer2.write("你好-->2");
                    writer2.flush();
        
                    //构造方法的第二个参数，表示是否追加内容 true 追加 false 覆盖
                    writer3 = new FileWriter(Config.PATH + "testFileWriter2.txt", false);//写入的新的内容会覆盖原内容
                    writer3.write("你好-->");
                    writer3.flush();
                    writer3.write("猪");
                    writer3.flush();
        
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        writer.close(); //关闭流
                        writer1.close();
                        writer2.close();
                        writer3.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
* Config中的代码

        public static final String PATH = "/Volumes/huang/studyfromGitHub/JavaForAndroid/JavaForAndroid/series10/src/main/java/files/";
#####结果
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series10/src/main/java/images/step1.png?raw=true)
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series10/src/main/java/images/step2.png?raw=true)
######说明默认写入模式为覆盖。
####字符输入流----Reader
同样的看他孙子类。
#####FileReader 继承自InputStreamReader
构造方法，也是所有源码

        //使用带有指定文件的String参数的构造方法。创建该输入流对象。并关联源文件。
        public FileReader(String var1) throws FileNotFoundException {
                super(new FileInputStream(var1));
            }//如:FileReader fr = new FileReader(String file);
        //基本同构造方法一，因为构造方法一传的String 目的也是创建一个文件
        public FileReader(File var1) throws FileNotFoundException {
                super(new FileInputStream(var1));
            }//如:FileReader fr = new FileReader(new File(str));//str为String类型
        
        //不常用
        public FileReader(FileDescriptor var1) {
                super(new FileInputStream(var1));
            }//如:
######主要方法:
* void read()读取单个字符。返回作为整数读取的字符，如果已达到流末尾，则返回 -1。

* void read(char[]char) 将字符读入数组。返回读取的字符数。如果已经到达尾部，则返回-1。

* void close() 关闭此流对象。释放与之关联的所有资源
#####案例----我们把上一个案例的testFileWriter2.txt文件内容读出来

        public class Demo2 {
            public static void main(String[] args) {
                //1.声明FileReader对象
                FileReader fileReader = null;
                try {
                    //2. 实例化FileReader对象
                    fileReader = new FileReader(Config.PATH + "testFileWriter2.txt");//可能会抛出FileNotFoundException异常
                    //3.文本读取
                    int num = 0;
                    while ((num = fileReader.read()) != -1) {//每次读一个字符，如果为-1表示已到文件结束位置
                        System.out.print((char) num);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        fileReader.close();//关闭流
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
#####结果
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series10/src/main/java/images/step3.png?raw=true)