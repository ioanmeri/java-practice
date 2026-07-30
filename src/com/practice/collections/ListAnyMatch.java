package com.practice.collections;

import java.util.Arrays;
import java.util.List;

public class ListAnyMatch {
    public static void main(String[] args) {
        List<String> values = Arrays.asList("Alpha A", "Alpha B", "Alpha C");

        boolean flag1 = values.stream().allMatch(str -> str.equals("Alpha B"));

        boolean flag2 = values.stream().findFirst().get().equals("Alpha B");

        boolean flag3 = values.stream().findAny().get().equals("Alpha B");

        boolean flag4 = values.stream().anyMatch(str -> str.equals("Alpha B"));

        System.out.println("flag1: " + flag1);
        System.out.println("flag2: " + flag2);
        System.out.println("flag3: " + flag3);
        System.out.println("flag4: " + flag4);
    }
}
