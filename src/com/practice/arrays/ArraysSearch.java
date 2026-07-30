package com.practice.arrays;

import java.util.Arrays;

public class ArraysSearch {
    static String[] sa = {"charlie", "bob", "andy", "dave"};

    public static void main(String[] args) {

        Arrays.sort(sa);
        int found = Arrays.binarySearch(sa, "charlie");

        System.out.println(found);

    }
}

// Remember that binarySearch method works ONLY if the collection or array being searched is already sorted.
// Further, the sort must have been done using the same Comparator that is being used to search otherwise search results will not be reliable.
// If no Comparator is used explicitly (either in sort or binarySearch method calls), elements are sorted by their natural order as determined by their Comparable interface implementation.