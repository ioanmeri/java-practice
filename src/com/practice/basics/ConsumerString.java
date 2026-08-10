package com.practice.basics;

import java.util.function.Consumer;


class Book {

    private int id;
    private String title;

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}

public class ConsumerString {

    public static void main(String[] args) {
        Book book = new Book(101, "Java Programming");

        Consumer<Book> c =b -> System.out.println(b.getId() + ":" + b.getTitle());

        c.accept(book);
    }
}

// Consumer<Book> means:
// Book → void
