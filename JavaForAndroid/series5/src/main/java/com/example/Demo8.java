package com.example;

/**
 * Created by huangcl on 2016/12/6.
 */

/**
 * 自定义异常类：
 * <p>
 * 1、创建类，并继承Exception
 * 2、提供构造方法，可以调用父类的构造方法
 * <p>
 * 使用自定义的类：
 * <p>
 * 在方法中，根据条件判断的结果，再通过throw关键向方法的调用者抛出异常
 * eg.
 * <p>
 * void method(int a){
 * if(a<0){
 * throw new 自定义异常类型("异常信息");
 * }
 * <p>
 * }
 * <p>
 * 注意：对于抛出的自定义的Exception异常，必须要处理
 * <p>
 * 为什么运行时异常可以不处理？
 * 因为运行时异常，在发生时，JVM默认会中断程序，当然也可以进行捕获。
 * <p>
 * 一般情况下，由于用户数据不合理的原因，而造成了运行时异常。
 */
public class Demo8 {
    static class MyException extends Exception {
        public MyException() {
            super("自定义异常");
        }

        public MyException(String msg) {
            super(msg);
        }
    }

    static void isZero(int n) throws MyException {
        if (n < 0) {
            //抛出数值不能小于0的异常
            throw new MyException("数值不能小于0！！"); //抛出的一般性异常必须要处理：捕获或抛出
        }

        System.out.println("大于0的值--》" + n);
    }

    public static void main(String[] args) {

        try {
            isZero(-1);
        } catch (MyException e) {
            e.printStackTrace();
        }

    }
}
