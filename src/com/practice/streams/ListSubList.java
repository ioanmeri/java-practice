package com.practice.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ListSubList {

    public static void main(String[] args) {
        List<String> vowels = new ArrayList<String>();
        vowels.add("a");
        vowels.add("e");
        vowels.add("i");
        vowels.add("o");
        vowels.add("u");
        Function<List<String>, List<String>> f = list->list.subList(2, 4);
        f.apply(vowels);
        vowels.forEach(System.out::print);
    }
}

// The List's subList method returns a view backed by the original list.
// It doesn't change the existing list.
// Therefore, when you print the elements from the original list after calling subList,
// you will see all the elements of the original list.


// Remember that if you modify the sub list, the changes will be visible in the original list.
// For example, the following will print aeioxu:
// List<String> view = f.apply(vowels);//get a view backed by the original list
// view.add("x");//modify the view
// vowels.forEach(System.out::print); //updates are visible in original list

