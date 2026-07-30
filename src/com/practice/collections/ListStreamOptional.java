package com.practice.collections;

import com.practice.collections.data.Book;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ListStreamOptional {

    public static void main(String[] args) {

        var books = List.of(
                new Book("Where the Crawdads Sing", "Dalia Owens"),
                new Book("The Outsider", "Stephen King"),
                new Book("Elevetion", "Stephen King"),
                new Book("Coffin from Hong Kong", "James Hadley Chase")
        );

        Stream<Book> bkStrm = books.stream();

        Optional<Book> bk = bkStrm.filter(b -> b.getAuthor().equals("Stephen King")).findFirst();

        bk.ifPresent(book -> System.out.println(book.getTitle()));

    }
}
