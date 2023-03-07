package com.codurance.isp;

public class Bird implements FlyingAnimal {
    public void makeNoise() { System.out.println("Bird is chirping");}
    public void run() {
        System.out.print("Bird is running");
    }
    public void fly() {
        System.out.print("Bird is flying");
    }
}