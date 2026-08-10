package com.practice.basics;

public class StringsComparison {

    public static void main(String[] args) {
        String s1 = "Hello World";
        String s2 = """
            Hello World""";
        String s3 = """
            Hello World
            """;
        System.out.println((s1 == s2)+" "+s2.equals(s3)+" "+s2.intern().equals(s3.intern()));
        // true false false
    }
}
