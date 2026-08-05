package com.practice.nio;

import java.nio.file.*;

public class FilesMove {

    public static void main(String[] args) throws Exception {

        Path source = Paths.get(
                "c:\\temp\\src\\foo.bar\\module-info.java"
        );

        Path target = Paths.get(
                "c:\\temp\\out\\foo.bar\\module-info.java"
        );

        Files.move(source, target);
    }
}

// Before running:

// c:\temp
//│
//├── src
//│   └── foo.bar
//│       └── module-info.java
//│
//└── out
//    └── foo.bar
//        (empty)

// We want:
// c:\temp
//│
//├── src
//│   └── foo.bar
//│       (empty)
//│
//└── out
//    └── foo.bar
//        └── module-info.java