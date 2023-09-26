package com.chuwa.shawnlearning.util;

public interface SFunctor<C,T> {
    <R> C map(SFunction<? super T, ? extends R> f);
}

