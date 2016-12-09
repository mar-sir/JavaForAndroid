package com.example;

/**
 * Created by huangcl on 2016/12/9.
 */

public class Fun1<T extends Person> {
    private T datas;

    public T getDatas() {
        return datas;
    }

    public void setDatas(T datas) {
        this.datas = datas;
    }
}
