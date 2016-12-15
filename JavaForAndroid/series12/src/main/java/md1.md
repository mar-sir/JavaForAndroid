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
* String getName();文件名
* String getPath()文件路径
* String getAbsolutePath() 绝对路径
* String getParent();所在目录
* long lastModified()文件最后修改时间
#####案例
    
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