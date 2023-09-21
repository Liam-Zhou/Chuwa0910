package com.chuwa.shawnlearning.util.impl.streamops;

import com.chuwa.shawnlearning.util.SFunction;

public class MappedOperation<T, R> implements SFunction<T, R> {
    private final SFunction<? super T, ? extends R> f;

    public MappedOperation(SFunction<? super T, ? extends R> f) {
        this.f = f;
    }

    @Override
    public R apply(T t) {
        return f.apply(t);
    }
}
