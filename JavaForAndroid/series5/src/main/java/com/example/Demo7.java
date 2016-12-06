package com.example;

/**
 * Created by huangcl on 2016/12/6.
 */

/**
 * 处理异常的格式3：
 * <p>
 * try{
 * //资源分配的语句
 * <p>
 * }catch(...){
 * <p>
 * }finally{
 * //肯定执行的语句，一般是释放资源的语句，
 * //注： 如果try语句中包含return 语句，finally语句在return之前执行
 * }
 */
public class Demo7 {


    static class Student{
        private String name;
        public Student(String name){
            this.name=name;
        }

        public int div(int a,int b){
            return a/b;
        }

        public String toString(){
            return name;
        }
    }

    public static void main(String[] args){
        Student s=new Student("张三");

        try{
            s.div(10,0);

            return ;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println(s.toString());

            s=null;//s所指向的堆内存变是垃圾了，可以被gc回收

            System.out.println("回收资源...");
        }



    }
}
