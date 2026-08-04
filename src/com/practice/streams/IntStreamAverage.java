package com.practice.streams;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamAverage {
    static String s = "";

    public static void main(String[] args) {
        var nums = IntStream.range(1,5);



//        double average = nums.collect(Collectors.averagingInt(i->i));
          // Error averagingInt expect Integer not int

//        double average = nums.mapToObj(i->i).collect(Collectors.averagingInt(i->i));
          // Valid

//        double average1 = nums.average().getAsDouble();
          // Valid

//        double average = nums.parallelStream().mapToInt(i->i).average();
         // Error cannot resolve parallelStream in IntStream

        double average = nums.parallel().mapToDouble(i -> i).average().getAsDouble();
        // Valid

        System.out.println("average: " + average);



    }
}
