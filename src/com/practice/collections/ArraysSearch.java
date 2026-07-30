package com.practice.collections;

import java.util.Arrays;

public class ArraysSearch {
    static String[] sa = {"charlie", "bob", "andy", "dave"};

    public static void main(String[] args) {

        Arrays.sort(sa);
        int found = Arrays.binarySearch(sa, "charlie");

        System.out.println(found);

    }
}
