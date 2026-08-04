package com.practice.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathsRelativize1 {

    public static void main(String[] args) {
        Path p1 = Paths.get("photos/goa");
        Path p2 = Paths.get("/index.html");
        Path p3 = p1.relativize(p2);
        System.out.println(p3);

        // IllegalArgumentException
        // because one is relative the other is absolute
    }
}
