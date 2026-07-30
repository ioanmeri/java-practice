package com.practice.basics;

class A{
    A() {
        print();
    }

    void print() {
        System.out.print("A");
    }
}

public class Polymorphism1 extends A {
    int i =   4;

    public static void main(String[] args){
        A a = new Polymorphism1();
        a.print();
    }

    void print() {
        System.out.print(i+" ");
    }
}

// method print() is overridden in class B
// Due to polymorphism, the method to be executed is selected depending on the class of the actual object.
// when an object of class B is created, first B's default constructor is called
// (which is not visible in the code but is automatically provided by the compiler because B does not define any constructor explicitly)
// The first line of this constructor is a call to super(), which invokes A's constructor.
// A's constructor in turn calls print().
// Now, print is a non-private instance method and is therefore polymorphic,
// which means, the selection of the method to be executed depends on the class of actual object on which it is invoked.
// *** Here, since the class of actual object is B, B's print is selected instead of A's print. ***
// At this point of time, variable i has not been initialized (because we are still in the middle of initializing A), so its default value i.e. 0 is printed.
// Prints 0, 4