package com.chuwa.shawnlearning.util.pipeline;

public interface OpSink<T>  {
    void accept(T t);

    default void begin(){}

    default void end(){}
}
