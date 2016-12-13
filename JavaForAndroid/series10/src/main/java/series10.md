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
#####案例----演示void read(char[]char) 用法

        public class Demo3 {
            public static void main(String[] args) {
                FileReader fileReader = null;
                try {
                    fileReader = new FileReader(Config.PATH + "testFileWriter2.txt");
                    char[] buffer = new char[4];//每次最多读4个字符
                    int n = 0;
                    while ((n = fileReader.read(buffer)) != -1) {//每次最多读4个字符，如果为-1表示已到文件结束位置
                        //打印本次读取的内容，从0位置开始，到本次读取的字符个数
                        System.out.println("读取 "+n+"个字符： "+new String(buffer,0,n));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    try {
                        fileReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
#####结果
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series10/src/main/java/images/step4.png?raw=true)
可见读取到的内容都是一样的。
####字符流(FileReader FileWriter)复制文件案例
    
        /**
         * 需求：copy拷贝 Demo1文件
         * 思路：肯定是边读边写
         */
        public class Demo4 {
            //源文件路径
            public static final String PATH = "/Volumes/huang/studyfromGitHub/JavaForAndroid/JavaForAndroid/series10/src/main/java/com/example/Demo1.java";
            public static final String FILENAME = "copyDemo1.java";
        
            public static void main(String[] args) {
                // 1. 声明文件字符的输入、输出流对象
                FileReader fileReader = null;
                FileWriter fileWriter = null;
        
                try {
                    // 2. 实例化流操作对象
                    fileReader = new FileReader(PATH);
                    fileWriter = new FileWriter(Config.PATH + FILENAME);//如果文件不存在，则会自动创建
                    char[] buffer = new char[6];
                    int len = 0;
                    while ((len = fileReader.read(buffer)) != -1) {//边读
                        fileWriter.write(buffer, 0, len);//边写,将本次读取的字符写入到复制的文件中
                    }
        
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    try {
                        //最后别忘了关闭流
                        fileReader.close();
                        fileWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
#####结果
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series10/src/main/java/images/step5.png?raw=true)
标红不是我的错，本来就该标红。
####字符输出流使用缓冲----FileWriter和BufferedWriter
* FileWriter      文件字符输出流
* BufferedWriter  缓冲字符输出流

#####BufferedWriter缓冲字符输出流，直接继承自Writer
构造方法

    public BufferedWriter(Writer var1) {
            this(var1, defaultCharBufferSize);
        }
    
    public BufferedWriter(Writer var1, int var2) {
            super(var1);
            if(var2 <= 0) {
                throw new IllegalArgumentException("Buffer size <= 0");
            } else {
                this.out = var1;
                this.cb = new char[var2];
                this.nChars = var2;
                this.nextChar = 0;
                this.lineSeparator = (String)AccessController.doPrivileged(new GetPropertyAction("line.separator"));
            }
        }
没看错的话是两个，要想得到BufferedWriter实例，必须给它传一个Writer实例。
#####运用举例

    public class Demo5 {
        public static final String NAME = "testDemo5.txt";
    
        public static void main(String[] args) {
            //1.变量声明
            FileWriter fileWriter = null;
            BufferedWriter bufferedWriter = null;
    
            try {
                //2.实例化变量
                fileWriter = new FileWriter(Config.PATH + NAME);
                bufferedWriter = new BufferedWriter(fileWriter);//装饰者模式，扩展现有功能（包装）,将节点流（文件字符流）对象作为构造参数使用
                //通过缓冲流对象向文本文件中写入数据
                bufferedWriter.write("哈哈，");
                bufferedWriter.newLine();//换行
                bufferedWriter.write("此处发现一个大傻逼。");
                //此处追加文本数据是向缓冲追加，而非是将内容追加到文件内
                bufferedWriter.append("追加内容")
                        .append("\r\n").append("这里也有一个傻逼。");
                //注：缓冲数据是将数据存入内存中，并没有写入到文件中，在关闭流之前必须要执行flush()方法
                bufferedWriter.flush();//将内存的数据写入到文件中
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                try {
                    bufferedWriter.close();//处理流关闭之后，节点流会自动关闭
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    
        }
    }
#####结果 
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series10/src/main/java/images/step6.png?raw=true)
注：缓冲数据是将数据存入内存中，并没有写入到文件中，在关闭流之前必须要执行flush()方法。
大家有没有发现FileWriter被BufferedWriter包装之后，功能变多了。。。让我们来稍微了解一下装饰者模式。
####装饰者模式
推荐博客
[Java设计模式学习09](http://blog.csdn.net/xu__cg/article/details/53024490)
[Java设计模式学习09](http://blog.csdn.net/xu__cg/article/details/53024490)
[Java设计模式学习09](http://blog.csdn.net/xu__cg/article/details/53024490)
######装饰者模式还是比较难懂的。。。。,我也说不了啥，下面案例是我仿照上面博客写的。
* Behaver 定义行为接口

        public interface  Behavior {
             void dressing();//化妆
        }
* Animal 不可否认人也是动物

        public class Animal implements Behavior {
            @Override
            public void dressing() {
                System.out.println("化妆。。。");
            }
        }
* 男人

        public class Man extends Person {
        
            public Man(Behavior behavior) {
                super(behavior);
            }
        
            @Override
            public void dressing() {
                super.dressing();
                System.out.println("化男人妆。。。");
            }
        }

* 女人
    
        public class Woman extends Person {
        
            public Woman(Behavior behavior) {
                super(behavior);
            }
        
            @Override
            public void dressing() {
                super.dressing();
                System.out.println("化女人妆。。。");
            }
        }
* 测试类

        /**
         * 装饰者案例
         */
        public class Demo6 {
        
            public static void main(String[] args) {
                System.out.println("=====================动物化妆========================");
                Animal animal = new Animal();
                animal.dressing();
                
                System.out.println("=====================男人化妆========================");
                Man man = new Man(animal);
                man.dressing();
                
                System.out.println("=====================女人化妆========================");
                Woman woman = new Woman(animal);
                woman.dressing();
                
                System.out.println("=====================人妖化妆========================");
                Woman woman1 = new Woman(man);
                woman1.dressing();
            }
        }
#####结果 
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series10/src/main/java/images/step7.png?raw=true)
我们可以看到，实例化女人1的时候换了一个实例组合，于是就出现了新的功能。。。
####字符输出流使用缓冲----FileReader和BufferedReader
* FileReader     文件字符输入流
* BufferedReader  缓冲字符输入出流

#####BufferedReaderr缓冲字符输出流，直接继承自Reader
构造方法
    
    public BufferedReader(Reader var1, int var2) {
            super(var1);
            this.markedChar = -1;
            this.readAheadLimit = 0;
            this.skipLF = false;
            this.markedSkipLF = false;
            if(var2 <= 0) {
                throw new IllegalArgumentException("Buffer size <= 0");
            } else {
                this.in = var1;
                this.cb = new char[var2];
                this.nextChar = this.nChars = 0;
            }
        }
    
        public BufferedReader(Reader var1) {
            this(var1, defaultCharBufferSize);
        }
同BufferWriter一样，两个构造方法。实例化的时候需要一个Reader实例。
#####运用案例

    /**
     * 读取Demo6.java的内容
     */
    public class Demo7 {
        public static final String PATH = "/Volumes/huang/studyfromGitHub/JavaForAndroid/JavaForAndroid/series10/src/main/java/com/example/Demo6.java";
    
        public static void main(String[] args) {
            //1.申明
            FileReader reader = null;
            BufferedReader bufferedReader = null;
            try {
                //2.实例化
                reader = new FileReader(PATH);
                bufferedReader = new BufferedReader(reader);
                //3.读取
                String msg=null;
                while ((msg=bufferedReader.readLine())!=null){//如果是null，则表示文件结束
                    System.out.println(msg);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    
        }
    }
#####结果 
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series10/src/main/java/images/step8.png?raw=true)
####装饰者模式再运用----自定义BufferReader
* 自定义BufferReader类
    
        class CoustomerBufferReader {
            private Reader in;
            //缓冲数组
            private char[] buffer=new char[1024];
            //每次读取的字符个数
            private int nChars;
            //缓冲数组的索引下标
            private int nextChar;
        
        
            public CoustomerBufferReader(Reader in) {
                this.in = in;
            }
        
            public int read() throws IOException {
                if (nChars == 0) {//表示缓冲中没有可读的字符
                    //读取节点流（字符流）中数据到缓冲数组中
                    nChars = in.read(buffer);
                    nextChar = 0;
                }
                if (nChars < 0) {//判断是否读取末尾
                    return -1;
                }
                int num = buffer[nextChar++];//从缓冲数组中获取一个字符
                nChars--;//读一轮，减一个
                return num;
            }
        
            public String readLine() throws IOException {
                int num = -1;
                StringBuilder builder = new StringBuilder();
                while ((num = read()) != -1) {
                    if (num == '\r') {
                        continue;
                    } else if (num == '\n') {
                        return builder.toString();
                    }
                    builder.append((char) num);//将读取的一个字符存放到变量中
                }
                //防止最后一行不存在换行符时，无法读取最后一行
                if (builder.length() > 0)
                    return builder.toString();
        
                return null;
            }
        
        }
* 测试类
    
        public class Demo8 {
        
            public static void main(String[] args) {
                try {
                    //读取Demo6中的内容
                    FileReader reader = new FileReader(Demo7.PATH);
                    //使用自己的CoustomerBufferReader
                    CoustomerBufferReader bufferReader=new CoustomerBufferReader(reader);
                    String line=null;
                    while ((line=bufferReader.readLine())!=null){
                        System.out.println(line);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
#####结果 
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series10/src/main/java/images/step8.png?raw=true)

####缓冲字符输入，输出流复制文件案例
讲道理正长是这样写

        public class Demo9 {
            //拷贝源文件
            public static final String PATH = "/Volumes/huang/studyfromGitHub/JavaForAndroid/JavaForAndroid/series10/src/main/java/com/example/Demo6.java";
            public static final String NAME = "testDemo9.java";
        
            public static void main(String[] args) {
                FileReader reader = null;
                BufferedReader bufferedReader = null;
        
                FileWriter fileWriter = null;
                BufferedWriter bufferedWriter = null;
        
                try {
                    reader = new FileReader(PATH);
                    bufferedReader = new BufferedReader(reader);
        
                    fileWriter = new FileWriter(Config.PATH + NAME);
                    bufferedWriter = new BufferedWriter(fileWriter);
                    String line = null;
                    while ((line = bufferedReader.readLine()) != null) {
                        //读一行，写一行
                        bufferedWriter.write(line);
                        bufferedWriter.flush();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        bufferedReader.close();
                        bufferedWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        
            }
        }
运行一看结果,傻眼了:
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series10/src/main/java/images/step9.png?raw=true)
它一行写到死。这可不行，我们看一下，除了没换行，其他都对，那我们控制它换行就可以了。

* 完美版 核心代码替换

            boolean isFirstLine=true;//刚开始绝B第一行
            while ((line = bufferedReader.readLine()) != null) {  //读一行，写一行
               if (isFirstLine){//第一行直接写
                   bufferedWriter.write(line);
                    isFirstLine=false;//写完之后绝B不是第一行了
                }else {
                    bufferedWriter.newLine();//插入换行
                   bufferedWriter.write(line);
                }
                  bufferedWriter.flush();
             }
* 运行结果
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series10/src/main/java/images/step10.png?raw=true)
