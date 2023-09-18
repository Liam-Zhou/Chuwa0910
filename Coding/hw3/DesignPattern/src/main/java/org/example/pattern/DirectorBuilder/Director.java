package org.example.pattern.DirectorBuilder;

public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public PartAB build() {
        this.builder.BuildPartA();
        this.builder.BuildPartB();
        return this.builder.construct();
    }
}
