package com.chuwa.shawnlearning.util.pipeline;


import com.chuwa.shawnlearning.util.SCollector;
import com.chuwa.shawnlearning.util.SFunction;
import com.chuwa.shawnlearning.util.SStream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class PipelineConstructor<In, Out> implements PipelineSinkWrapper<In, Out>, SStream<Out> {
    PipelineConstructor<?, ?> source;
    PipelineConstructor<?, ?> prev;
    PipelineConstructor<?, ?> next;
    protected PipelineConstructor(PipelineConstructor<?, ?> prev) {
        super();
        if(prev == null) {
            this.source = this;
        }
        this.prev = prev;
        if(prev != null) {
            prev.next = this;
            this.source = prev.source;
        }

    }




    @Override
    public <R> SStream<R> map(SFunction<? super Out, ? extends R> f) {
        return new PipelineConstructor<Out, R>(this) {
            @Override
            public OpSink<Out> prepareSink(OpSink<R> downStream) {
                return new ChainedSinkConstructor<>(downStream) {
                    @Override
                    public void accept(Out in) {
                        downStream.accept(f.apply(in));
                    }
                };
            }
        };
    }

    @Override
    public SStream<Out> filter(SFunction<? super Out, Boolean> f) {
        return new PipelineConstructor<Out, Out>(this) {
            @Override
            public OpSink<Out> prepareSink(OpSink<Out> downStream) {
                return new ChainedSinkConstructor<Out, Out>(downStream) {
                    @Override
                    public void accept(Out in) {
                        if (f.apply(in)) {
                            downStream.accept(in);
                        }
                    }
                };
            }
        };
    }

    void evaluate(){
        List<OpSink> copySinks = new ArrayList<>();
        PipelineConstructor<?, ?> cur = this;
        OpSink last = null;
        while(cur != null){
            OpSink<?> sink = cur.prepareSink(last);
            copySinks.add(sink);
            cur = cur.prev;
            last = sink;
        }
        Collections.reverse(copySinks);
        for(int i = copySinks.size() - 1; i >= 0; i--){
            copySinks.get(i).begin();
        }
        copySinks.get(0).accept(null);

        for(int i = copySinks.size() - 1; i >= 0; i--){
            copySinks.get(i).end();
        };
    }

    @Override
    public <R> R collect(SCollector<? super Out, ? extends R> collector) {

        var terminal = new PipelineConstructor<Out, Object>(this) {
            @Override
            public OpSink<Out> prepareSink(OpSink<Object> downStream) {
                return new ChainedSinkConstructor<>(downStream) {
                    @Override
                    public void accept(Out in) {
                        collector.accumulate(in);
                    }
                };
            }
        };
        terminal.evaluate();
        return collector.finish();

    }



}
