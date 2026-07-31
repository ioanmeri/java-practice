package com.practice.collections;

import java.util.ArrayList;
import java.util.SequencedCollection;

public class ArrayListSequencedCollection {

    public static void main(String[] args) {
        SequencedCollection<String> s1 = new ArrayList<>( );
        s1.addFirst("a");  // a
        s1.addFirst("b");  // b, a
        s1.addLast("c");   // b, a, c
        s1.add("a");         // b, a, c, a


        System.out.println(s1.removeFirst()+" "+s1.remove("a")+" "+s1.remove("x"));
        // a, c, a
        // c, a

        // Prints: b true false
    }
}

// add(): adds at the end (same as addLast()):
// removeFirst(): removes and returns the first element: b
// s1.remove("a"): It removes the first occurrence of "a".
//      true because an element was removed.
// s1.remove("x"):
//      false because nothing is removed

// java.util.SequencedCollection adds operations like:
// - addFirst()
// - addLast()
// - getFirst()
// - getLast()
// - removeFirst()
// - removeLast()
// - reversed()
