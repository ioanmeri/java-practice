package com.practice.streams;

import java.util.Random;
import java.util.stream.DoubleStream;

public class GenerateRandomDoubles {
    public static void main(String[] args) {

        Random r = new Random();

        r.doubles(10).forEach(System.out::print);

        System.out.println(" ");


        DoubleStream rDoubles = r.doubles().limit(10);
        rDoubles.forEach(System.out::print);

        System.out.println(" ");
        DoubleStream.generate(()->r.nextDouble()).limit(10).forEach(System.out::print);
    }
}
