package com.practice.basics;

public class InnerClasses1 {
    public class A { }

    public static class B { }

    public void useClasses() {
        new InnerClasses1().new A();

        new InnerClasses1.B();

        new A();

        new InnerClasses1.A();

    }
}

// class A is not static inner class of TestClass. So it cannot exist without an outer instance of TestClass.
// class B is static inner class and can be instantiated without an outer instance of TestClass.
// Now, the method useClasses() is an instance method. So, it already has instance of outer class associated with it.
// So, new A(); is also valid. new TestClass.A(); is same as new A().
