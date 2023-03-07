package com.codurance.isp;

public class Dog implements Animal {

    @Override
    public void run() {
        System.out.print("Dog is running");
    }

    @Override
    public void makeNoise() {
        System.out.print("Dog is barking");
    }
}
