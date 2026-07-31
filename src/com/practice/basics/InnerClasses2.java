package com.practice.basics;


public class InnerClasses2 {
    int i = 10;


    class Inner {
        public void methodA() {
            System.out.println(i);
            System.out.println(InnerClasses2.this.i);

            // System.out.println(this.i);
            // - Here, this refers to the Inner instance, not the Outer.
            // - Since Inner has no field i, this is invalid.
        }
    }

}

// Inside a non‑static inner class:
// - The inner class has full access to all instance members of the outer class