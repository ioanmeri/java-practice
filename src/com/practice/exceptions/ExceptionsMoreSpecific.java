package com.practice.exceptions;

public class ExceptionsMoreSpecific {

    public void method(Object o){
        System.out.println("Object Version");
    }
    public void method(java.io.FileNotFoundException s){
        System.out.println("java.io.FileNotFoundException Version");
    }
    public void method(java.io.IOException s){
        System.out.println("IOException Version");
    }
    public static void main(String args[]){
        ExceptionsMoreSpecific tc = new ExceptionsMoreSpecific();
        tc.method(null);
    }

    // Prints java.io.FileNotFoundException Version
}

// The reason is quite simple, the most specific method depending upon the argument is called
// Here, null can be passed to all the 3 methods but
// - FileNotFoundException class is the subclass of
// -- IOException which in turn is the subclass of
// --- Object.
// So, FileNotFoundException class is the most specific class. So, this method is called