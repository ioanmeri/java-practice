package com.practice.interfaces;


interface Eatable{
    int types = 10;
}
class Food implements Eatable {
    public static int types = 20;
    // This does not override the interface field.
    // Fields are hidden, not overridden.
}
public class Interfaces2 extends Food implements Eatable{  //LINE1

    public static void main(String[] args) {
        Food.types = 30; //LINE 2, if types = 30 causes compilation error because it is ambiguous

        System.out.println("Food.types: " + Food.types);
        System.out.println("Eatable.types: " + Eatable.types);
    }
}