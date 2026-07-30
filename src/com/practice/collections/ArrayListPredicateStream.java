package com.practice.collections;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;

record Book(String title, LocalDate releaseDate) {
}

// a set of book titles that were released after the date indicated by the predicate p

public class ArrayListPredicateStream {

    public static void main(String[] args) {

        var books = new ArrayList<Book>(
                List.of(
                        new Book("The Outsider", LocalDate.of(2019, 1, 1)),
                        new Book("Becoming", LocalDate.of(2018, 1, 1)),
                        new Book("Uri", LocalDate.of(2017, 1, 1))
                )
        );

        Predicate<Book> p = b -> b.releaseDate()
                .isAfter(IsoChronology.INSTANCE.date(2018, 1, 1));

        Set<String> newBooks = books.stream()
                .collect(Collectors.partitioningBy(p))
                .get(true)
                .stream()
                .map(Book::title)
                .collect(Collectors.toCollection(TreeSet::new));

        Set<String> newBooks2 = books.stream()
                .collect(
                        Collectors.filtering(
                                p,
                                Collectors.mapping(Book::title, Collectors.toSet())
                        )
                );

//        System.out.println(newBooks);
        System.out.println(newBooks2);

    }
}
