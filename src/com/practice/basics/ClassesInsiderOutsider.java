package com.practice.basics;

class Outsider {
    public class Insider{ }
}

public class ClassesInsiderOutsider {

    public static void main(String[] args) {
        var os = new Outsider();

        Outsider.Insider in = os.new Insider();
        // Since Insider is not a static class, it must have an associated outer class instance.
    }
}
