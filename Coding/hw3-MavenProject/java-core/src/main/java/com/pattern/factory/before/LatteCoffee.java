package com.pattern.factory.before;

import com.pattern.factory.simple_factory.Coffee;

public class LatteCoffee extends Coffee {
    @Override
    public String getName() {
        return "Latte Coffee";
    }
}
