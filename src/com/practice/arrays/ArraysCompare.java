package com.practice.arrays;

import java.util.Arrays;

public class ArraysCompare {

    public static void main(String[] args) {
        int[] ia1 = { 0, 1, 4, 5};
        int[] ia2 = { 0, 1, 1, 5, 6};


        // At index 2: `4 > 1` Therefore, ia1 is greater than ia2 -> Positive 1
        int x = Arrays.compare(ia1, ia2);


        // The first mismatch is at index 2
        int y = Arrays.mismatch(ia1, ia2);
        System.out.println(x+" "+y);
        // 1 2
    }
}

// Another example
// char[] a = { 'h', 'e', 'l', 'l'};
// char[] b = { };

// int x = Arrays.compare(a, b);
// int y = Arrays.mismatch(a, b);
// System.out.println(x+" "+y);

// Prints: 4 0

// Since the second array is a proper prefix of the first array, compare() will return a
// positive number and the number will be the same as the difference in the number of
// elements in both the arrays i.e 4-0 = 4.

// Proper Prefix
// An array b is a prefix of array a if b contains the elements at the beginning of a
// a = { 'h', 'e', 'l', 'l' }
// b = { 'h', 'e' }


// Since the two arrays are differ at index 0, mismatch will return 0.

