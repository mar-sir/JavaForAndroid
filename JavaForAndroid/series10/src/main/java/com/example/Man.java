package com.example;

/**
 * Created by huangcl on 2016/12/13.
 */

public class Man extends Person {

    public Man(Behavior behavior) {
        super(behavior);
    }

    @Override
    public void dressing() {
        super.dressing();
        System.out.println("化男人妆。。。");
    }
}
