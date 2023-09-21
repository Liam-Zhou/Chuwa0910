package com.chuwa.shawnlearning.util.impl;

import com.chuwa.shawnlearning.util.SFunction;
import com.chuwa.shawnlearning.util.SFunctor;
import com.chuwa.shawnlearning.util.SMonad;

import java.util.ArrayList;
import java.util.List;

public class SList<T> extends ArrayList<T> implements SFunctor<SList<?>, T>, SMonad<SList<?>, T>  {



    @Override
    public <R> SList<R> flatMap(SFunction<? super T, ? extends SMonad<? super SList<?>, R>> f){
        List<R> result = new ArrayList<>();
        for(var v: this){
            SList<R> r = (SList<R>) f.apply(v);
            result.addAll(r);
        }
        return new SList<>(result);
    }



    public SList(List<T> value) {
        super(value);
    }

    @Override
    public <R> SList<R> map(SFunction<? super T, ? extends R> f) {
        List<R> result = new ArrayList<>();
        for(var v: this){
            result.add(f.apply(v));
        }
        return new SList<>(result);
    }
}
