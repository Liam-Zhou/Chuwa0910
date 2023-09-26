package com.chuwa.shawnlearning.util.impl;

public class SNone<T> implements SOptional<T>{
    private static final SNone<?> INSTANCE = new SNone<>();
    public static <T> SNone<T> none() {
        return (SNone<T>) INSTANCE;
    }
}
