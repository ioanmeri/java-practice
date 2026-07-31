package com.practice.interfaces;

// If you want to provide an implementation in the interface, you must use the default keyword.
interface House{
    public default String getAddress(){
        return "101 Main Str";
    }
}

interface Bungalow extends House{
    public default String getAddress(){
        return "101 Smart Str";
    }
}

// A class implementing Bungalow inherits this implementation unless it overrides it.
class MyHouse implements Bungalow, House{

}

public class Interfaces4 {

    public static void main(String[] args) {
        House ci = new MyHouse();
        // The inherited method is the most specific one—the one from Bungalow
        System.out.println(ci.getAddress());
    }
}


// A subinterface can override a default method from its parent interface.
// A class implementing the subinterface inherits the most specific default implementation