package com.example;

/**
 * Created by huangcl on 2016/12/8.
 */

/**
 * 格式:接口名后面跟 <T>
 *
 * @param <T>
 */
public interface IManager<T> {
    void add(T data);

    T get(int index);//抽象方法的返回值为泛型

    void sop();
}
