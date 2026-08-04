package com.practice.collections.operators;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class ListUnaryOperator {

    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(11, 22, 33);
        UnaryOperator<Integer> func = x -> x + 10;
        ls.replaceAll(func);
        System.out.println(ls);
    }
}
