package com.chuwa.shawnlearning.util.impl;

import com.chuwa.shawnlearning.util.SFunction;
import com.chuwa.shawnlearning.util.SFunctor;

public class SIdentity<T> implements SFunctor<SIdentity<?>, T> {

    private final T value;

    public SIdentity(T value) {
        this.value = value;
    }
    @Override
    public <R> SIdentity<R> map(SFunction<? super T, ? extends R> f) {
        return new SIdentity<>(f.apply(value));
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof SIdentity)) return false;
        SIdentity<?> other = (SIdentity<?>) o;
        return other.value.equals(this.value);
    }
}
