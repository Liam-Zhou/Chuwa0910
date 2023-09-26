package com.chuwa.shawnlearning.features.lambda;

@FunctionalInterface
public interface Foo {
    String aMethod(String string);

    default String defaultBar(){
         return "defaultBar";
    }

    default String defaultCommon(){
         return "defaultCommon";
    }


}
