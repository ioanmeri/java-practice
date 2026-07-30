package com.practice.interfaces;

interface Device {
    public abstract void switchOn();
}

abstract class Router {
    public void switchOn(){    }

    public abstract void reset();
}

public class InterfaceInheritance1 extends Router implements Device{

    public static void main(String[] args) {

    }

    public void reset(){ }
}


