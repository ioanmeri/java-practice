package com.practice.interfaces;

interface IInt{
    int thevalue = 0;
}

// Here, the interface IInt defines thevalue and thus any class that implements this interface gets this field.
// Therefore, it can be accessed using s.thevalue or just thevalue inside the class.
// Also, since it is static, it can also be accessed using IInt.thevalue or Sample.thevalue.

public class Interface1 implements IInt {

    public static void main(String[] args) {
        Interface1 s = new Interface1();
        int j = s.thevalue;
        int k = IInt.thevalue;
        int l = thevalue;

        System.out.println("j: " + j);
        System.out.println("k: " + k);
        System.out.println("l: " + l);
    }
}
