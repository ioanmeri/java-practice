package com.practice.basics;

class Overload1 {
    void probe(Object x) { System.out.println("In Object"); } //3

    void probe(Number x) { System.out.println("In Number"); } //2

    void probe(Integer x) { System.out.println("In Integer"); } //2

    void probe(Long x) { System.out.println("In Long"); } //4

    public static void main(String[] args){
        double a = 10;
        new Overload1().probe(a);
    }
}

// Here, we have four overloaded probe methods but there is no probe method that takes a double parameter.
// However, a double will be boxed into a Double and class Double extends Number.
// Therefore, a Double can be passed to the method that takes Number.
// A Double can also be passed to a method that takes Object, but Number is more specific than Object therefore probe(Number ) will be called.
