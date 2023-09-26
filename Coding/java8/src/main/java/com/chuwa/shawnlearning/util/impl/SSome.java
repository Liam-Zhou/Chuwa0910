package com.chuwa.shawnlearning.util.impl;

import com.chuwa.shawnlearning.util.SFunction;

public class SSome<T> implements SOptional<T>{
    private final T value;

    public SSome(T value) {
        this.value = value;
    }

    @Override
    public T get() {
        return value;
    }
}
