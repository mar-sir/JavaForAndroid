package com.example;

/**
 * Created by huangcl on 2016/12/12.
 */

/**
 * 产品
 */
public class Egg {
    int id;

    public Egg(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "->" + id;
    }
}
