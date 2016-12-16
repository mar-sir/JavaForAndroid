package com.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 类对象的序列化和反序列化 1）序列化：将对象保存到流中 2）反序列化：将流中的对象读取到
 * <p>
 * 注：类必须实现Serializable接口
 *
 *
 */
public class Demo1 {

    public static void main(String[] args) throws Exception {
        //savePerson();
        readPerson();
    }

    static void savePerson() throws Exception {
        Person p = new Person("张三", 20, "小班");
        // 将对象保存到gp02.dat文件中
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
                "test.txt"));
        oos.writeObject(p);
        oos.write(100);
        oos.close();
    }

    static void readPerson() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.txt"));
        //读取数据的顺序必须和写入的顺序一致
        Person p = (Person) ois.readObject();
        System.out.println(p.getName() + "  " + p.getAge() + "  " + p.getClassName());
        int a = ois.read();
        System.out.println(a);
        ois.close();
    }
}

class Person implements Serializable {

    /**
     * 为了保证对象在反序列化过程中的一致性，需要申明一个serialVersionUID常量
     */
    private static final long serialVersionUID = 1l;

    private String name;
    private int age;
    private transient String className;//不序列化成员

    public String getName() {
        return name;
    }

    public Person(String name, int age, String className) {
        super();
        this.name = name;
        this.age = age;
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", className="
                + className + "]";
    }
}

