package com.practice.collections;

import java.util.*;

class Book2 {
    private String isbn;
    private String title;
    private double price;

    public Book2(String isbn, String title, double price) {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return isbn + " - " + title + " - " + price;
    }
}

public class ListComparator {

    public static void main(String[] args) {

        List<Book2> books = new ArrayList<>();

        books.add(new Book2("333", "Java Basics", 40.0));
        books.add(new Book2("111", "Advanced Java", 60.0));
        books.add(new Book2("222", "Java Basics", 50.0));
        books.add(new Book2("444", "Streams", 30.0));


        System.out.println("Original:");
        books.forEach(System.out::println);


        // 1. Sort by title ascending
        books.sort(
                Comparator.comparing(Book2::getTitle)
        );
        /*
        Equivalent to: (b1, b2) -> b1.getTitle().compareTo(b2.getTitle())
         */

        System.out.println("\nSorted by title:");
        books.forEach(System.out::println);



        // 2. Sort by title, then by price
        books.sort(
                Comparator.comparing(Book2::getTitle)
                        .thenComparing(Book2::getPrice)
        );

        System.out.println("\nSorted by title then price:");
        books.forEach(System.out::println);



        // 3. Sort by price descending
        books.sort(
                Comparator.comparing(Book2::getPrice)
                        .reversed()
        );

        System.out.println("\nSorted by price descending:");
        books.forEach(System.out::println);



        // 4. Using a custom Comparator lambda
        Comparator<Book2> byIsbn = (b1, b2) -> b1.getIsbn().compareTo(b2.getIsbn());
        /*
        Equivalent to:

        Comparator<Book2> byIsbn = new Comparator<Book2>() {
            public int compare(Book b1, Book b2) {
                return b1.getIsbn().compareTo(b2.getIsbn());
            }
        };
         */

        books.sort(byIsbn);

        System.out.println("\nSorted by ISBN:");
        books.forEach(System.out::println);
    }
}