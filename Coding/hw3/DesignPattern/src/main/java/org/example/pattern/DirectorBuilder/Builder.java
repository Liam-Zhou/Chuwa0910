package org.example.pattern.DirectorBuilder;

public abstract class Builder {
    public abstract void BuildPartA();

    public abstract void BuildPartB();

    public abstract PartAB construct();
}
