package com.practice.basics;

class Baap {
    public int h = 4;

    public int getH() {
        System.out.println("Baap " + h);
        return h;
    }
}


public class RuntimeDispatch extends Baap {
    public int h = 44;

    public int getH() {
        System.out.println("RuntimeDispatch " + h);
        return h;
    }

    public static void main(String[] args) {
        Baap b = new RuntimeDispatch();
        System.out.println(b.h + " " + b.getH());

        RuntimeDispatch bb = (RuntimeDispatch) b;
        System.out.println(bb.h + " " + bb.getH());
    }
}

// Instance Method => Class Runtime Object (Overridden)

// Instance Fields and Static methods => Class of the variable (Hidden)
