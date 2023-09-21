package com.chuwa.shawnlearning.util;

public interface SMonad<C, T> {


    <R> C flatMap(SFunction<? super T, ? extends SMonad<? super C, R>> f);
}
