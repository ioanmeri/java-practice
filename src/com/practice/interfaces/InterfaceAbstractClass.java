package com.practice.interfaces;

import java.util.ArrayList;

abstract class Vehicle{ }

interface Drivable{ }

class Car extends Vehicle implements Drivable{ }

class SUV extends Car { }

public class InterfaceAbstractClass {
    public static void main(String[] args) {
        ArrayList<Vehicle> al1 = new ArrayList<>();
        al1.add(new SUV());

        ArrayList<Drivable> al2 = new ArrayList<>();
        al2.add(new Car());

        ArrayList<Drivable> al3 = new ArrayList<>();
        al3.add(new SUV());

        ArrayList<SUV> al4 = new ArrayList<>();
//        al4.add(new Car()); // "I accept only SUVs."
        // Car → SUV ❌


        ArrayList<Vehicle> al5 = new ArrayList<>();
        al5.add(new Car());

    }
}
