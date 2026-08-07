package com.practice.streams;

import java.util.stream.Stream;

record Person(String name, char gender){};

public class TakeWhileDropWhile {

    public static void main(String[] args) {

        Stream.of(
                        new Person("Bob", 'M'),
                        new Person("Rita", 'F'),
                        new Person("Mukesh", 'M'),
                        new Person("Amita", 'T'),
                        new Person("Sonya", 'F')
                )
                .takeWhile(p->p.gender()=='M' || p.gender()=='F') // Bob, Rita, Mukesh
                .sorted( (p1, p2) -> p2.name().compareTo(p1.name())) // Rita, Mukesh, Bob
                .dropWhile(p->p.name().length()<5) // Mukesh, Bob
                .forEach(p->System.out.print(p.name())); // Prints: MukeshBob
    }
}

// takeWhile() takes elements until the first element that does not match.

// The sorting is descending because the comparator compares p2 against p1:

// dropWhile() Drops from the start until condition is false