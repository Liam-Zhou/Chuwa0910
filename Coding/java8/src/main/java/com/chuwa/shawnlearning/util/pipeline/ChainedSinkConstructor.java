package com.chuwa.shawnlearning.util.pipeline;

public abstract class ChainedSinkConstructor<In, Out> implements OpSink<In> {
    OpSink<Out> downStream;
    protected ChainedSinkConstructor(OpSink<Out> nxt){
        this.downStream =  nxt;
    }
}
