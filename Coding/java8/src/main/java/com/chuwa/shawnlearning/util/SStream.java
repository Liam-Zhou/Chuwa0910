package com.chuwa.shawnlearning.util;


import com.chuwa.shawnlearning.util.pipeline.ChainedSinkConstructor;
import com.chuwa.shawnlearning.util.pipeline.PipelineConstructor;
import com.chuwa.shawnlearning.util.pipeline.OpSink;

import java.util.List;

public interface SStream<T> {
    <R> SStream<R> map(SFunction<? super T, ? extends R> f);

    SStream<T> filter(SFunction<? super T, Boolean> f);

    static <T> SStream<T> of(List<T> list) {
        return new PipelineConstructor<>(null) {
            @Override
            public OpSink<Object> prepareSink(OpSink<T> downStream) {
                return new ChainedSinkConstructor<>(downStream) {
                    @Override
                    public void accept(Object in) {
                        for (var i : list) {
                            downStream.accept(i);
                        }
                    }
                };
            }
        };
    }



    <R> R collect(SCollector<? super T, ? extends R> collector);
}


