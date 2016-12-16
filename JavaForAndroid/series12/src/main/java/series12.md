####Java关于文件操作模块(File)
#####File类对文件的操作
File的方法结构.
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series12/src/main/java/images/step1.png?raw=true)
看名字就大概知道方法的意思了。
##### 构造方法（文件的创建方式）
以下案例自己在main函数里运行就可以了。
#####创建方式一 new File(String filePath)

        /**
         * @param filePath 系统磁盘的根节点到当前文件所在的目录和文件名
         */
        static void createFileway1(String filePath) {
            File file = new File(filePath);
            // 如：c:/user/src/Demo1.java
            // 如：/Volumes/huang/hello.txt
            //file.getAbsolutePath() 文件的绝对路径
            System.out.println(file.getAbsolutePath() + "," + file.length());
            //但是上面语句并不会在磁盘上创建文件，还需一句话
            try {
                file.createNewFile();//创建文件
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
##### 创建方式二 new File(String filePath,String fileName)//第一个参数，文件路径，第二个参数，文件名 
第一个参数必须是已存在的文件名。

        /**
             * @param filePath 已存在的文件路径
             * @param fileName 文件名
             */
            private static void createFileWay2(String filePath, String fileName) {
                File file = new File(filePath, fileName);
                if (!file.exists()) {
                    //判断文件是否存在
                    System.out.println("指定文件不存在");
                    //创建
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return;
                }
                System.out.println(file.getAbsolutePath() + "," + file.length());
            }
##### 创建方式三 new File(File dir,String fileName)//文件，文件名 


        /**
         * @param filePath 文件路径
         * @param fileName 文件名
         */
        static void createWay3(String filePath, String fileName) {
            //构造文件目录对象
            File dir = new File(filePath);
            //判断是否为文件目录
            if (!dir.isDirectory()) {
                throw new RuntimeException("指定的目录不存在");
            }
            //构造最终的文件对象
            File file = new File(dir, fileName);
            if (!file.exists()) {
                try {
                    //创建
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(file.getAbsolutePath() + "," + file.length());
            }
        }
#####File 其他常用方法
* boolean exits()判断文件是否存在
    
        static void exists(File file) {
                if (!file.exists()) {
                    throw new RuntimeException("目录不存在");
                }
            }
* boolean mkdir()//只能创建单个目录（基本不用）、boolean mkdirs()//能创建多级目录

    
        static void mkdirs(File file) {// 判断+创建多级目录
            if (file.exists()) {
                throw new RuntimeException("目录已存在");
            }
            //file.mkdir();//创建一级目录
            file.mkdirs();// 能创建多级目录
        }
* boolean isFile() 判断是否是文件

        if (file.isFile()) {
        	System.out.println("是文件");
        }
* boolean delete()删除文件

        // 判断是否为文件
         if (file.isFile()||file.listFiles().length==0) {
         
             file.delete();
             System.out.println(file.getAbsolutePath()+"删除成功");
             
             }else if(file.listFiles().length!=0){ 
                throw new RuntimeException("非空目录不能直接删除");
          }
* File[] listRoots();读取系统的跟目录
    
        static void listRoot(){//读取系统文件的根目录
                File[] root=File.listRoots();
                for(File f:root){
                    System.out.println(f);
                }
            }
        
* String getName();文件名
* String getPath()文件路径
* String getAbsolutePath() 绝对路径
* String getParent();所在目录
* long lastModified()文件最后修改时间
#####案例一
    
        public class Demo2 {
            //绝对路径
            public static final String PATH = "/Volumes/huang/1/1.txt";
        
            public static void main(String[] args) {
                File file=new File(PATH);
                //判断是否存在，并且不是目录
                if(!file.exists() || !file.isFile()){
                    throw new RuntimeException("文件不存在或是目录");
                }
                //获取日期格式化对象
                DateFormat df=DateFormat.getDateTimeInstance();
                Date mDate=new Date(file.lastModified());
                System.out.println("文件名："+file.getName());
                System.out.println("文件路径："+file.getPath());
                System.out.println("绝对路径："+file.getAbsolutePath());
                System.out.println("所在目录："+file.getParent());
                System.out.println("文件大小："+file.length()+"字节");
                System.out.println("文件最后修改时间："+df.format(mDate));
            }
        }
#####结果
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series12/src/main/java/images/step2.png?raw=true)
#####案例二

            //我的盘，
            public static final String PATH = "/Volumes";
            //你的盘，
            //public static final String PATH = "D:/";
            public static DateFormat format=DateFormat.getDateTimeInstance();
        
            public static void main(String[] args) {
                showFiles(new File(PATH));//显示C盘目录下的所有文件及子目录信息
            }
        
            private static void showFiles(File file) {
                for (File file1 : file.listFiles()) {
                  System.out.println(file1.getName()+"---->"+file1.length()+"B"+
                          "["+format.format(new Date(file1.lastModified()))+"]");
                }
            }
######一个文件夹里面有很多不同后缀名的文件，我们怎么获取到同一类型的文件呢？眼尖的肯定在第一张图看到 File[] listFiles(FileFilter fileFilter)这个方法了。我们用的就是它。
####文件过滤 FileFilter
    
    public interface FileFilter {
        boolean accept(File var1);
    }
一个接口，如果是指定类型的文件，则返回true。还有一个FilenameFilter。

####文件过滤 FilenameFilter
    
    public interface FilenameFilter {
        boolean accept(File var1, String var2);
    }
也是一个接口，如果是指定类型的文件，则返回true。
#####用法案例一 FileFilter

        /**
             * //FileFileter 显示指定目录下的.txt文件
             *
             * @param path 指定目录
             */
            private static void testFileFileter(String path) {
                File file = new File(path);
                if (!file.isDirectory()) {
                    throw new RuntimeException("不是一个有效的目录");
                }
                File[] files = file.listFiles(new FileFilter() {// 如果是指定类型的文件，则返回true
                    @Override
                    public boolean accept(File file) {
                        String fileName = file.getName();
                        //获取文件扩展名
                        String txt = fileName.substring(fileName.lastIndexOf(".") + 1);
                        if ("doc".equals(txt)) {
                            return true;
                        }
                        return false;
                    }
                });
        
                //打印所有文件
                for (File file1 : files) {
                    System.out.println(file1.getName());
                }
        
            }
#####用法案例二 FilenameFilter
 
         /**
             * FilenameFilter 显示指定目录下的.doc文件
             *
             * @param path
             */
            private static void testFilenameFilter(String path) {
                File file = new File(path);
                if (!file.isDirectory()) {
                    throw new RuntimeException("不是一个有效的目录");
                }
                File[] files = file.listFiles(new FilenameFilter() {
                    @Override
                    public boolean accept(File file, String s) {
                        //假如你不知道 s 是什么，那你就把它打印出来看一看
                        System.out.println(s);
                        if (s.endsWith(".doc")) return true;
                        return false;
                    }
                });
                System.out.println("================过滤后文件===========================");
                //打印所有文件
                for (File file1 : files) {
                    System.out.println(file1.getName());
                }
            }
* 递归打印指定目录所有文件及目录
    
        //我新建的测试文件
            public static final String PATH = "/Volumes/huang/Test";
            /**
             * 递归打印
             *
             * @param file
             */
            private static void printFiles(File file) {
                if (file.isDirectory()) {
                    for (File file1 : file.listFiles()) {
                        printFiles(file1);
                    }
                }
                //也是退出条件
                System.out.println(file);
            }
* 递归删除指定目录所有文件及目录
真的会删除文件，所以请你手动新建文件之后再删。

            //我新建的测试文件
             public static final String PATH = "/Volumes/huang/Test";
            // 实现递归方式删除文件目录及子目录中的文件
            private static void deleteFile(File file) {
                if (file.isDirectory()) {
                    for (File f : file.listFiles()) {
                        deleteFile(f);
                    }
                }
                file.delete();// 删除文件或空目录
                System.out.println(file + "已删除");
            }