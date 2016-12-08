package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangcl on 2016/12/8.
 */

/**
 * @param <T>
 */
public class Manager<T> implements IManager<T> {
    private List<T> datas;

    public Manager() {
        datas = new ArrayList<>();
    }

    @Override
    public void add(T data) {
        datas.add(data);
    }

    @Override
    public T get(int index) {
        return datas.get(index);
    }

    @Override
    public void sop() {
        for (T t : datas) {
            System.out.println(t);
        }
    }
}
