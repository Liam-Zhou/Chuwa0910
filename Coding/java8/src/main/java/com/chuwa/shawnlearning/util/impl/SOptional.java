package com.chuwa.shawnlearning.util.impl;

import com.chuwa.shawnlearning.util.SApplicative;
import com.chuwa.shawnlearning.util.SFunction;
import com.chuwa.shawnlearning.util.SFunctor;

import java.util.Objects;

import static com.chuwa.shawnlearning.util.impl.SNone.none;

public interface SOptional<T> extends SFunctor<SOptional<?>, T>, SApplicative<SOptional<?>, T> {

    static <T> SOptional<T> empty() {
        return none();
    }

    static <T> SOptional<T> of(T value) {
        Objects.requireNonNull(value);
        return new SSome<>(value);
    }

    static <T> SOptional<T> ofNullable(T value) {
        return value == null ? empty() : of(value);
    }

    default T get() {
        if(!isPresent()){
            throw new NullPointerException();
        } else {
            return ((SSome<T>) this).get();
        }
    }


    @Override
    default <R> SOptional<R> map(SFunction<? super T, ? extends R> f) {
        if(!isPresent()){
            return SOptional.empty();
        }
        return new SSome<>(f.apply(get()));
    }

    default T orElse(T other) {
        if(isPresent()){
            return get();
        } else {
            return other;
        }
    }

    public default boolean isPresent(){
        return this instanceof SSome;
    }

    @Override
    default <R> SOptional<R> apply(SFunction<? super T, ? extends R> f){
        if(!isPresent()){
            return SNone.none();
        }
        return new SSome<>(f.apply(get()));
    }
}
