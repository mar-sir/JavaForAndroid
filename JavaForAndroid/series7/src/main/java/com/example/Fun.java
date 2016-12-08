package com.example;

/**
 * Created by huangcl on 2016/12/8.
 */

/**
 * 泛型类
 *
 * @param <T>T
 * @param <V>V
 */
public class Fun<T, V> {
    private T data;
    private V data2;

    //泛型方法
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public V getData2() {
        return data2;
    }

    public void setData2(V data2) {
        this.data2 = data2;
    }
}
