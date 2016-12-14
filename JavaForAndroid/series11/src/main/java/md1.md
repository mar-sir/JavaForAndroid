####字节流
* InputStream 输入字节流
* OutputStream 输出字节流

####输入字节流----InputStream
InputStream 是所有的输入字节流的父类，它是一个抽象类。同样的来看它的子类。
####FileInputStream 继承自InputStream
######构造方法：

     //传一个文件路径（字符串）
     public FileInputStream(String var1) throws FileNotFoundException {
            this(var1 != null?new File(var1):null);
        }//如：FileInputStream in=new FileInputStream(String path);
        
      //传一个文件
     public FileInputStream(File var1) throws FileNotFoundException {
        ....
        }//如：FileInputStream in=new FileInputStream(new File(String path));
    
      //不常用
     public FileInputStream(FileDescriptor var1) {
         ...
        }
######主要方法
* int read();//返回值int,若返回值为-1，则代表已经读完，是不是和字符流很像，但每次读一个字节，并打印,如果存在中文，可能会乱码

* int read(byte[] bytes);//每次读bytes字节,
####代码演示:
    
    
        /**
         * 需求：控制台输出本文件内容
         */
        public class Demo1 {
            //文件地址
            public static final String PATH = "/Volumes/huang/studyfromGitHub/JavaForAndroid/JavaForAndroid/series11/src/main/java/com/example/Demo1.java";
            //文件名
            public static final String NAME = "copyTest1.java";
        
            public static void main(String[] args) {
                //  read();//测试InputStream 的read()方法
                reads();
            }
        
            /**
             * 测试read(byte[] bytes)
             * 可以控制字符集
             */
            private static void reads() {
                FileInputStream inputStream = null;
                try {
                    inputStream = new FileInputStream(PATH);
                    byte[] bytes = new byte[inputStream.available()];//inputStream.available()获取文件长度
                    //读取的字节长度
                    int len = inputStream.read(bytes);//将数据一次性读取到字节数组中
                    System.out.println("读取长度" + len + "\n" + new String(bytes, "utf-8"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
        
            }
        
            /**
             * 测试read()
             * 每次读一个字节，并打印,如果存在中文，可能会乱码
             */
            private static void read() {
                FileInputStream inputStream = null;
                try {
                    inputStream = new FileInputStream(PATH);
                    int len = 0;
                    while ((len = inputStream.read()) != -1) {
                        System.out.print((char) len);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
####结果----read()，出现了乱码.
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series11/src/main/java/images/step1.png?raw=true)
####结果----read(byte[]bytes)，设置了字符集，没出现乱码.
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series11/src/main/java/images/step2.png?raw=true)
有没有觉得都差不多.
####输出字节流----OutputStream
OutputStream 是所有的输入字节流的父类，它是一个抽象类。同样的来看它的子类。
####FileOutStream 继承自OutputStream
######构造方法：

        
        //是不是和FileWriter很像，第一个参数目的是创建一个向指定 File 对象表示的文件中写入数据的文件输出流。如果第二个参数为 true，则将字节写入文件末尾处，而不是写入文件开始处。
        public FileOutputStream(String var1) throws FileNotFoundException {
                ....
            }
        
        public FileOutputStream(String var1, boolean var2) throws FileNotFoundException {
                .....
            }
        
        public FileOutputStream(File var1) throws FileNotFoundException {
                this(var1, false);
            }
        
        public FileOutputStream(File var1, boolean var2) throws FileNotFoundException {
              ......
            }
        
        public FileOutputStream(FileDescriptor var1) {
              .....
            }
######主要方法
* void write(byte[]bytes);//写字节数组
####写纯文本文件-----案例
* Config类代码:

        public class Config {
            public static final String PATH="/Volumes/huang/studyfromGitHub/JavaForAndroid/JavaForAndroid/series11/src/main/java/files";
        }
* 主要代码
        
               private static final String fileName = "testOutput.java";
           /**
             * 
             */
            private static void write() {
                FileOutputStream outputStream = null;
                try {
                    outputStream = new FileOutputStream(Config.PATH + fileName);
                    outputStream.write("你好啊，美女".getBytes());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        
