package com.example;

/**
 * Created by huangcl on 2016/12/13.
 */

public class Person implements Behavior {
    private Behavior behavior;

    public Person(Behavior behavior) {
        this.behavior = behavior;
    }

    @Override
    public void dressing() {
        behavior.dressing();
    }
}
