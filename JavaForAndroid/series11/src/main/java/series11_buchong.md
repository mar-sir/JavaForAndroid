####IO中的其他读写流
#####RandomAccessFile
* 构造方法

        //var1 文件路径,var 文件的读写模式 "r"只读，"w"只写，"rw"读写
        public RandomAccessFile(String var1, String var2) throws FileNotFoundException {
                this(var1 != null?new File(var1):null, var2);
            }
        //传文件，和模式
        public RandomAccessFile(File var1, String var2) throws FileNotFoundException {
  
            }
* 其他常用方法
 
        public void close () 关闭操作
                        
        public int read ( byte[] b)将内容读取到一个byte数组之中
                        
        public final byte readByte () 读取一个字节
                        
        public final int readInt () 从文件中读取整型数据。
                
        public void seek ( long pos)设置读指针的位置。
                
        public final void writeBytes (String s)将一个字符串写入到文件之中，按字节的方式处理。
                
        public final void writeInt ( int v)将一个int型数据写入文件，长度为4位。
                
        public int skipBytes ( int n)指针跳过多少个字节。
##### RandomAccessFile 读写案例
* 文件路径
        
          //文件路径
            public static final String PATH = "/Volumes/huang/studyfromGitHub/JavaForAndroid/JavaForAndroid/series11/src/main/java/files/testRAF.txt";
* 写
         
           /**
                *
                */
               private static void testWrite() {
                   RandomAccessFile accessFile = null;
                   try {
                       //读写模式创建实例
                       accessFile = new RandomAccessFile(PATH, "rw");
                       //读取文件长度
                       System.out.println(accessFile.length() + " B");//0B
           
                       //将文件指针移动中间位置
                       accessFile.seek(accessFile.length() / 2);
                       String name = null;
                       int age = 0;// int 的长度为4
                       float money = 1.2f;// float 的长度为4
                       //double长度为8
           
                       name = "name1";// 长度为5de字符串
                       age = 20;
                       money = 23.5f;
                       accessFile.writeBytes(name);
                       //读取文件长度
                       System.out.println(accessFile.length() + "B");//5B
                       accessFile.writeInt(age);
                       System.out.println(accessFile.length() + "B");//9B
                       accessFile.writeFloat(money);
                       System.out.println(accessFile.length() + "B");//13B
                       System.out.println("================================");
           
                       name = "name2";// 长度为5de字符串
                       age = 21;
                       money = 24.5f;
                       accessFile.writeBytes(name);
                       System.out.println(accessFile.length() + "B");//18B
                       accessFile.writeInt(age);
                       System.out.println(accessFile.length() + "B");//22B
                       accessFile.writeFloat(money);
                       System.out.println(accessFile.length() + "B");//26B
           
                       //accessFile.writeUTF("hello，你好！");
                       //注：从中间写入的数据是覆盖后面的内容，因此在写数据时，尽量追加在内容之后
                   } catch (Exception e) {
                       e.printStackTrace();
                   } finally {
                       try {
                           accessFile.close();
                       } catch (IOException e) {
                           e.printStackTrace();
                       }
                   }
               }
* 读
   
        /**
             * 读
             */
            private static void testRead() {
                RandomAccessFile accessFile = null;
                //读写模式创建实例
                try {
                    accessFile = new RandomAccessFile(PATH, "r");//只读模式创建实例
                    String name = null;
                    int age = 0;
                    float money = 0.0f;
                    byte[] bytes = new byte[5];
                    //假如要先读第二个人的信息
                    accessFile.skipBytes(13);//则跳过前13字节
                    for (int i = 0; i < bytes.length; i++) {
                        bytes[i] = accessFile.readByte();//读取一个字节
                    }
                    name = new String(bytes);
                    age = accessFile.readInt();
                    money = accessFile.readFloat();
                    System.out.println("name2:-->" + name + "\t" + age + "\t" + money);
                    //读第一个
                    accessFile.seek(0);//指针回到0
                    //假如要先读第二个人的信息
                    for (int i = 0; i < bytes.length; i++) {
                        bytes[i] = accessFile.readByte();//读取一个字节
                    }
                    name = new String(bytes);
                    age = accessFile.readInt();
                    money = accessFile.readFloat();
                    System.out.println("name1:-->" + name + "\t" + age + "\t" + money);
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    try {
                        accessFile.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
* 读的运行结果
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series11/src/main/java/images/step9.png?raw=true)
#####DataOutputStream(数据输出流)、DataInputStream(数据输入流)
######DataOutputStream
构造方法

         //传入一个字节输出流
         public DataOutputStream(OutputStream var1) {
                super(var1);
            }
######用法案例
* 文件路径

            public static final String PATH = "/Volumes/huang/studyfromGitHub/JavaForAndroid/JavaForAndroid/series11/src/main/java/files/testOutput.txt";
* 写

            /**
                 * DataOutputStream 写
                 */
                private static void write() {
                    DataOutputStream outputStream = null;
                    try {
                        //传入字节流实例获取对象实例
                        outputStream = new DataOutputStream(new FileOutputStream(PATH));
                        //写入基本数据
                        outputStream.writeUTF("你好，Java"); //写入utf-8编码字符串
                        outputStream.writeInt(10);
                        outputStream.writeInt(34);
                        outputStream.writeChar('a');
                        outputStream.writeBoolean(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }finally {
                        try {
                            outputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
* 读
 
        /**
             *
             */
            private static void read() {
                DataInputStream inputStream=null;
                try {
                    inputStream=new DataInputStream(new FileInputStream(PATH));
                    //2. 读取数据
                    String txt=inputStream.readUTF();//读取utf-8编码的字符串
                    int a=inputStream.readInt();
                    int b=inputStream.readInt();
                    int num=inputStream.readChar();
                    boolean flag=inputStream.readBoolean();
        
                    System.out.println(txt+"\r\n"+a+" "+b+","+num+","+flag);
        
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    //关闭流
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
* 读结果
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series11/src/main/java/images/step10.png?raw=true)

#####ByteArrayInputStream、ByteArrayOutputStream很常用的两个类
######ByteArrayInputStream
构造方法
    
    
    //使用一个字节数组当中所有的数据做为数据源
    public ByteArrayInputStream(byte[] var1) {
            .....
        }
    //从数组当中的第offset开始，一直取出length个这个字节做为数据源。
    public ByteArrayInputStream(byte[] var1, int var2, int var3) {
          ....
        }
######ByteArrayOutputStream  
构造方法

    
    //创建一个32个字节的缓冲区
    public ByteArrayOutputStream() {
            this(32);
        }
    //根据参数指定大小创建缓冲区
    public ByteArrayOutputStream(int var1) {
            if(var1 < 0) {
                throw new IllegalArgumentException("Negative initial size: " + var1);
            } else {
                this.buf = new byte[var1];
            }
        }
这两个构造函数创建的缓冲区大小在数据过多的时候都会自动增长。
#####案例运用----拷贝文件

    /**
     * ByteArrayOutputStream拷贝本文件内容
     */
    public class Demo9 {
        //源文件路径
        public static final String sourcePath = "/Volumes/huang/studyfromGitHub/JavaForAndroid/JavaForAndroid/series11/src/main/java/com/example/Demo9.java";
        //目标路径
        public static final String targetPath = "/Volumes/huang/studyfromGitHub/JavaForAndroid/JavaForAndroid/series11/src/main/java/files";
    
        //文件名
        public static final String fileName = "test.java";
    
        public static void main(String[] args) {
            try {
                //得到字节流
                FileInputStream inputStream = new FileInputStream(sourcePath);
    
                //将字节流转成字符流
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
    
                //将字节流包装成一个缓冲字符流
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    
                //创建内存流对象--内存输出流
                ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream(inputStream.available());
    
                //将字节流转换成字符流
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(arrayOutputStream);
    
                //将字符流包装成缓冲字符流--BufferedWriter
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
    
                String msg = null;
                while ((msg = bufferedReader.readLine()) != null) {
                    bufferedWriter.write(msg);//向内存中写入数据
                    bufferedWriter.newLine();
                    bufferedWriter.flush();//将缓冲区的数据写入到内存流中使用的内存区中
                }
                byte[] bytes = arrayOutputStream.toByteArray();
                System.out.println(new String(bytes));
    
                //关闭流
                bufferedReader.close();
                bufferedWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
    
    
        }
    }

