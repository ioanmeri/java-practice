package com.practice.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamIntMax {

    public static void main(String[] args) {

        List<Integer> ls = Arrays.asList(10, 47, 33, 23);

        int max = ls.stream().max(Comparator.comparing(a -> a)).get();

        // another way of doing it
        int max2 = ls.stream().max(Integer::compare).get();
        // (a, b) -> Integer.compare(a, b) `Comparator<Integer>`

        System.out.println(max);
        System.out.println(max2);

        // Comparator.comparing method requires a Function that takes
        // an input and returns a Comparable.
    }

}

// The lambda expression a->a creates a Function that takes an Integer
// and returns an Integer (which is a Comparable). Here, the lambda expression
// does not do much but in situations where you have a class that doesn't
// implement Comparable and you want to compare objects of that class using a
// property of that class that is Comparable, this is very useful

// The call to get() is required because max(Comparator ) return an Optional object.