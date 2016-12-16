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