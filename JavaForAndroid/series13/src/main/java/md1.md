####Java Socket相关
学习套接字Socket之前我们先来简单的了解一个类。InetAddress...。
#####InetAddress
    
     //获取本机IP信息
      InetAddress localIP = InetAddress.getLocalHost();
     //IP地址
     System.out.println(localIP.getHostAddress());
     //获取本机器的主机名
     System.out.println("host-->" + localIP.getHostName()); //localhost
  
     //获取百度的ip地址
     InetAddress baidu = InetAddress.getByName("www.baidu.com");
     System.out.println("baidu-ip-->" + baidu.getHostAddress());
 为了实现两程序之间的通信，采用了套接字Socket，就是两个程序之间约定好了的一套协议。它是基于TCP／IP的协议。下面我给出一张图。
 
 ![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series13/src/main/java/images/step1.png?raw=true)
 你对Socket初步了解了吗？要掌握它，还是要不停的写代码。不要停。。。
 
####Socket-----服务器，客户端链接
* 服务器端 

        /**
         * 服务端
         */
        public class Server {
            public static final int PORT=4584;
        
            public static void main(String[] args) {
                ServerSocket serverSocket = null;
                try {
                    // 创建SocketServer对象，并声明监听Socket连接的端口号
                    serverSocket = new ServerSocket(PORT);
                    while (true) {//永真一直监听客户端
                        //开始接收Socket连接
                        Socket accept = serverSocket.accept();//会阻塞，直到有客户端链接
                        //连接后打印客户端IP地址
                        System.out.println(accept.getInetAddress() + "客户端已连接");
                        //但至此客户端不知道是否自己已经连上服务器了，服务器端的告诉他
                        //给客户端发送消息
                        OutputStream outputStream = accept.getOutputStream();
                        outputStream.write("你已经链接成功".getBytes());
                        outputStream.flush();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        
        }
* 客户端

        /**
         * 客户端
         */
        public class Cilent {
            public static void main(String[] args) {
                Socket socket = null;
                StringBuilder sb = null;
                try {
                    //创建客户端的Socket对象，并指定连接ServerSocket的IP和端口
                    //此处用的是本机地址
                    socket = new Socket(InetAddress.getLocalHost().getHostAddress(), Server.PORT);
                    //接收服务器端的消息
                    InputStream inputStream = socket.getInputStream();
                    byte[] bytes = new byte[100];
                    int len = 0;
                    sb = new StringBuilder();
                    while ((len = inputStream.read(bytes)) != -1) {
                        sb.append(new String(bytes, 0, len));
                    }
                    System.out.println(sb.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
            }
        }
首先启动服务器端，然后启动客户端，两程序就连接上了。