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
