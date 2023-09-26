package com.chuwa.shawnlearning.util;

public interface SApplicative<C, T> {

    <R> C apply(SFunction<? super T, ? extends R> f);
}
