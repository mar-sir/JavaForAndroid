package com.example; /**
 * Created by huangcl on 2016/12/6.
 */

/**
 * 抛出多个异常的格式:
 * <p>
 * 在方法声明的后边，使用 throws 异常类型列表 语句
 * <p>
 * <p>
 * 在方法中抛出异常：
 * <p>
 * throw new RuntimeException("异常信息");
 */
public class Demo6 {

    static class Person {
        String name;

        public Person(String name) {
            this.name = name;
        }

        public String toString() {
            return "[name=" + name + "]";
        }
    }

    //抛出多个异常，抛给调用者处理
    static void sub(int a, int b, int[] nums, Person p)
            throws ArithmeticException, IndexOutOfBoundsException, NullPointerException {

        int r = a / b;//此行如果出现了异常，则下行代码不会执行
        r = nums[5] / 9;
        //System.out.println(p.toString());

    }

    static void div(int a, int b) {
        if (b == 0) {
            //抛出异常
            throw new RuntimeException("除数为0");
        }
    }

    public static void main(String[] args) {
        int[] nums = {9, 10, 8, 66, 22, 109};

        //sub(10,2,nums,new Person("张三"));

        try {
            sub(10, 4, new int[7], null);

            div(9, 0);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("数组长度小于6");
        } catch (IndexOutOfBoundsException e) {  //父类的异常处理放在子类异常处理的下方
            System.out.println("索引越界。。。");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
