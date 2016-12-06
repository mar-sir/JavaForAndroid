package com.example;

/**
 * Created by huangcl on 2016/12/6.
 */

/**
 * 处理多个异常的格式:
 * <p>
 * try{
 * <p>
 * }catch(异常类名 对象名){
 * <p>
 * }catch(...){
 * <p>
 * }catch(...){
 * <p>
 * }
 * <p>
 * 注意：处理多个异常类时，异常的子类所在的catch语句要放在最上面
 */
public class Demo5 {
    static class Person {
        String name;

        public Person(String name) {
            this.name = name;
        }

        public String toString() {
            return "[name=" + name + "]";
        }
    }

    static void sub(int a, int b, int[] nums, Person p) {

        try {
            int r = a / b;//此行如果出现了异常，则下行代码不会执行
            r = nums[5] / 9;
            System.out.println(p);
        } catch (ArithmeticException e) {
            System.out.println("除数为0了...");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("数组的索引值越界了,数组的长度小于6...");
        } catch (NullPointerException e) {
            System.out.println("访问的对象是null");
        } catch (Exception e) {  //异常类的父类所处于的catch语句要放在最后
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        int[] nums = {9, 10, 8, 66, 22, 109};

        sub(10, 2, nums, new Person("张三"));

        sub(10, 0, new int[3], null);

    }
}
