package com.practice.interfaces;

interface I1 {
    void m1() throws java.io.IOException;
}

interface I2 {
    void m1() throws java.sql.SQLException;
}

public class Interfaces5 implements I1, I2 {
    public static void main(String args[])  throws Exception {
        Interfaces5 tc = new Interfaces5();
        I1 i1 = (I1) tc; //This is valid.
        i1.m1();

        I2 i2 = (I2) tc; //This is valid too.
        i2.m1();

    }

    public void m1() {
        System.out.println("Hi there");
    }
}

// A class that implements a method of an interface (or that overrides a method of a super class), cannot include any new exceptions in its throws class.
// It is only allowed throw either the same exceptions or any subclass of those exceptions as declared by the interface method.
// **It is also allowed to not throw any exception at all.**

// When interfaces are involved, more than one method declaration may be implemented by a single method declaration.
// In this case, the overriding declaration must have a throws clause that is compatible with ALL the overridden declarations.
// The declaration public void m1(){} satisfies both the declarations