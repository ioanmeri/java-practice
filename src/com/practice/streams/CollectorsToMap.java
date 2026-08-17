package com.practice.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

class Book1 {
    private String title;
    private double price;

    Book1(String title, double price){
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }
}

public class CollectorsToMap {
    public static void main(String[] args) {
        List<Book1> books = Arrays.asList(
                new Book1("Atlas Shrugged", 10.0),
                new Book1("Freedom at Midnight", 5.0),
                new Book1("Gone with the wind", 5.0)
        );

        Map<String, Double> bookMap = books.stream().collect(
                Collectors.toMap(
                        (
                                b->b.getTitle()
                        ),
                        b->b.getPrice()
                )
        );


        BiConsumer<String, Double> func = (a, b)->{
            if(a.startsWith("A")){
                System.out.println(b);
            }
        };

        bookMap.forEach(func);
    }
}

// The forEach method of a Map requires a BiConsumer
// This function is invoked for each entry, that is each key-value pair, in the map.
// The first argument of this function is the key and the second is the value.
