package com.practice.streams;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Movie {
    private String title;
    private String genre;

    public Movie(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }
    //accessors not shown
    String getGenre(){
        return this.genre;
    }
}


public class StreamCollectors1 {

    public static void main(String[] args) {
        Stream<Movie> sm = Stream.of(
                new Movie("a1", "a"),
                new Movie("a2", "a"),
                new Movie("b1", "b"),
                new Movie("c1", null)
        );

        Map<Optional<String>, Long> gcount = sm.collect(
                Collectors.groupingBy(
                        movie -> Optional.ofNullable(movie.getGenre()), Collectors.counting()
                )
        );

        System.out.println(gcount);
    }
}
