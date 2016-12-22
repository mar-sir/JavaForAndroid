### 分支语句if else
        /**
         * /*if分支语句
         * <p>
         * 格式：
         * if(条件) 单行语句; else 单行语句;
         * <p>
         * if(条件){ 多行语句; } else{ 多行语句; }
         * <p>
         * if(){} else if(){} else if(){} else{ },整体结构，只有一个分支会执行
         * <p>
         * if(){
         * <p>
         * if(){} else{}  //嵌套if-else语句
         * }
         */

        public class Demo4 {
            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);

                int cc = 100;
                if (cc <= 100) {
                    cc += 50;
                    if (cc < 100) {
                        System.out.println("小于100");
                    } else if (cc < 500) {
                        System.out.println("小于500");
                    } else {
                        System.out.println("大于500");
                    }
                }
                //输入一个星期的数，并输出对应的星期名称，0-星期日，1-星期一，。。6-星期六

                System.out.println("输入一个星期的数,0-星期日，1-星期一,...,6-星期六: ");

                int wIndex = sc.nextInt();

                String wName = "星期";
                if (wIndex == 0) {
                    wName += "日";
                } else if (wIndex == 1) {
                    wName += "一";
                } else if (wIndex == 2) {
                    wName += "二";
                } else if (wIndex == 3) {
                    wName += "三";
                } else if (wIndex == 4) {
                    wName += "四";
                } else if (wIndex == 5) {
                    wName += "五";
                } else if (wIndex == 6) {
                    wName += "六";
                } else {
                    wName = "星期的编号出错！！！";
                }
                System.out.println(wName);
            }  
        }
### 分支语句 switch
        /**
         * switch分支语句
         * <p>
         * 格式：
         * <p>
         * switch(表达式1){ //表达式的数据类型： char,byte,short,int,long,enum(jdk 1.5),String(jdk 1.7)
         * <p>
         * case 数值1:
         * <p>
         * //当表达式1的值为当前位置的数值1时
         * <p>
         * 语句;
         * <p>
         * case 数值2：
         * <p>
         * 语句;
         * <p>
         * break;
         * default:
         * <p>
         * //上面case语句没有一个被执行或者在case语句中不存在break，则进入此处，进行默认行为的处理
         * <p>
         *
         */
         public class Demo5 {

                public static void main(String[] args) {
                    switch (10) {

                        case 5:
                            System.out.println("表达式与5匹配");
                            break;
                        case 10:
                            System.out.println("表达式与10匹配");
                            break;
                        case 15:
                            System.out.println("表达式与15匹配");
                            break;
                        default:
                            System.out.println("表达式中不存在与10匹配的语句或没有出现break");

                    }
                    switch (5) {

                        case 5: {
                            int i = 5; //变量的作用域： 从声明位置开始到 右大括号结束
                            System.out.println(i);
                            //break;
                        }
                        case 10:
                            int i = 10;
                            System.out.println(i);
                            break;
                        case 15:
                            System.out.println("表达式与15匹配");
                            break;
                        default:
                            System.out.println("表达式中不存在与10匹配的语句或没有出现break");

                    }
                }
        }
### 循环语句 while do while
        /**
         * 循环语句：
         * <p>
         * while循环： 先判断条件，如果条件为true则执行循环体，当循环体执行完后，再接着判断条件。。。
         * <p>
         * while(条件表达式){
         * <p>
         * 循环体; //执行某一重复使用的功能代码
         * <p>
         * 改变循环条件的值;
         * }
         * <p>
         * do-while循环： 先执行循环体，再判断条件
         * <p>
         * do{
         * <p>
         * }while(条件表达式)
         * <p>
         * while与do-while的区别：
         * <p>
         * while是先判断后执行（可能一次都不执行循环体），
         * do-while先执行，再判断（至少执行一次循环体）
         */
        public class Demo6 {

            public static void main(String[] args) {
                //要求： 求1~100之间数值的和
                int i = 1;
                int sum = 0;

                while (i <= 100) {
                    sum += i;
                    i++;
                }

                System.out.println("sum=" + sum);
                //重置变量
                i = 1;
                sum = 0;
                do {
                    sum += i;
                    i++;
                } while (i <= 100);
                System.out.println("sum=" + sum);
               //要求： 求5的阶乘
                int y = 5;
                int result = 1;
                do {
                    result *= i;
                    y--;
                } while (y > 1);

                System.out.println("5的阶乘为 " + result);

            }
        }
### for循环
        /**
         * for循环：
         * <p>
         * 定义格式：
         * <p>
         * for(初始化表达式1;循环表达式2;循环条件变量变化表达式3){
         * <p>
         * //循环体
         * <p>
         * }
         * <p>
         * 表达式1： 定义循环中使用的变量和循环条件中的变量，其作用域仅限当前for循环中
         * 表达式2： 每次循环的条件表达式，只有条件为true时，才会执行循环体
         * <p>
         * 表达式3： 执行完循环体之后，执行的表达式，一般用于改变循环条件变量的值
         * <p>
         * <p>
         * //嵌套for：
         * <p>
         * for(;;){
         * for(;;){
         * <p>
         * }
         */public class Demo7 {

            public static void main(String[] args) {

                for (int i = 0; i < 100; i++) {
                    //循环100次
                    System.out.println(i+"");
                }

                int i = 0;
                for (; i < 100; i++) {
                    //循环100次
                }

                System.out.println(i); //i的作用域只限于for循环体中，可以将初始化表达式的变量放在for循环外定义

               /* for (; ; ) { //死循环

                }*/
                //如果上面的死循环执行，就不会执行下面的调用方法
                System.out.println("hello");
            }


         }
#### continue break 的区别
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series1/src/main/java/images/step_1.png?raw=true)
### continue break补充
    public class Demo1 {
    
        public static void main(String[] args) {
            int k = 1, count = 0;
            for (; k <= 100; k++) {
    
                if (k % 2 == 0) {
                    continue;  //结束本次循环，转到下一次循环
                    //后面代码同样不会执行
                }
                count++;//有多少个奇数
            }
            System.out.println(count);
            System.out.println("===================================");
            //
            int sum = 0;
            outer:
            for (int m = 0; m < 100; m++) {
                inner:
                for (int n = 0; n < 20; n++) {
                    sum += n;  //sum ++;
                    if (n == 5) break;//跳出了当前循环,但跳不出第二层循环
                    if (sum >= 100) {
                        break outer;//跳出outer
                    }
                }
    
            }
            System.out.println(sum);
        }
    }