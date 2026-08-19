package com.practice.arrays;

public class ArraysClone {

    public static void main(String[] args) {
        int[][] orig = { { 1, 2, 3} , { 4, 5, 6, 7}};
        int[][] dup = orig.clone();
        int[] copy = dup[0].clone();

        // false because dup is a clone of orig and therefore, they will point to two different array objects
        // Their elements, however, will point to the same objects.
        System.out.println(orig == dup); // false


        // false because equals method of all array classes simply check
        // whether the two references point to the same object or not.
        // equals method of array classes returns the same result as ==
        System.out.println(orig.equals(dup)); // false

        // true because, as explained above, a clone creates a shallow copy,
        // which means, elements of orig and dup point to the same objects.
        System.out.println(orig[0] == dup[0]); // true


        // false because of the same reason as described above.
        System.out.println(dup[0] == copy); // false
        System.out.println(dup[0].equals(copy)); // false
    }
}
