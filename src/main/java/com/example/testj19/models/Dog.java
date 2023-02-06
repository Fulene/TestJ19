package com.example.testj19.models;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println("A dog eating...");
    }

}
