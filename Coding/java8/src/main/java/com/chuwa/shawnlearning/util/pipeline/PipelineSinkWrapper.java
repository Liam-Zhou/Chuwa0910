package com.chuwa.shawnlearning.util.pipeline;

public interface PipelineSinkWrapper<In, Out>  {
     OpSink<In> prepareSink(OpSink<Out> downStream);
}
