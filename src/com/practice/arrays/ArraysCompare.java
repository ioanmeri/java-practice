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
