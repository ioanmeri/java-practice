package com.practice.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorsJoining {

    public static void main(String[] args) {
        List<String> letters = Arrays.asList("j", "a", "v","a");
        String word = letters.stream().collect(Collectors.joining());
        System.out.println(word);
    }

}
