package com.chuwa.shawnlearning.util;


public abstract class SCollector<S, R> {

    public abstract void accumulate(S s);

    public abstract R finish();
}
