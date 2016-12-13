package com.example;

/**
 * Created by huangcl on 2016/12/13.
 */

public class Woman extends Person {

    public Woman(Behavior behavior) {
        super(behavior);
    }

    @Override
    public void dressing() {
        super.dressing();
        System.out.println("化女人妆。。。");
    }
}
