package com.practice.collections;


import java.util.Arrays;
import java.util.List;

public class ListFlatMap {
    public record Book3(String title, Double price){ }

    public static void main(String[] args) {

        List<List<Book3>> books = Arrays.asList(
                Arrays.asList(
                        new Book3("Windmills of the Gods", 7.0),
                        new Book3("Tell me your dreams",9.0)
                ),
                Arrays.asList(
                        new Book3("There is a hippy on the highway", 5.0),
                        new Book3("Easy come easy go", 5.0)
                )
        );

        double d = books.stream()
                        .flatMap(bs -> bs.stream())
                                .mapToDouble(book -> book.price())
                                .sum();


        System.out.println(d);
    }
}
