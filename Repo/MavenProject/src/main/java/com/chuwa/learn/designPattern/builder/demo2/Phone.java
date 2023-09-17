package com.chuwa.learn.designPattern.builder.demo2;

public class Phone {
    private String cpu;
    private String screen;
    private String memory;

    private Phone(Builder builder) {
        this.cpu = Builder.cpu;
        this.screen = Builder.screen;
        this.memory = Builder.memory;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "cpu='" + cpu + '\'' +
                ", screen='" + screen + '\'' +
                ", memory='" + memory + '\'' +
                '}';
    }

    public static final class Builder{
        private static String cpu;
        private static String screen;
        private static String memory;

        public Builder cpu(String cpu){
            this.cpu  = cpu;
            return this;
        }
        public Builder screen(String screen){
            this.screen  = screen;
            return this;
        }
        public Builder memory(String memory){
            this.memory  = memory;
            return this;
        }
        public Phone build(){
            return new Phone(this);
        }
    }
}
