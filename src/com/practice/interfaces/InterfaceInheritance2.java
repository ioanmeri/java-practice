package com.practice.interfaces;

interface Device2 {
    public abstract void switchOn();
}

abstract class Router2 implements Device2 {
    public void switchOn(){    }

    public abstract void reset();
}

public class InterfaceInheritance2 extends Router2 implements Device2 {

    public static void main(String[] args) {

    }

    @Override
    public void reset(){ }
}
