package com.practice.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

class Great {
    public void doStuff() throws FileNotFoundException {
    }
}

class Amazing extends Great {
//    public void doStuff() throws IOException, IllegalArgumentException{ // Original Code
//    Subclass cannot through broader
    public void doStuff() throws IllegalArgumentException{
    }
}

public class ExceptionsPolymorphism {

    public static void main(String[] args) throws IOException{
        Great g = new Amazing();
        g.doStuff();
    }
}


// Fixes

// 1. Change doStuff in Amazing to throw only IllegalArgumentException

//  IOException (Checked) ->  FileNotFoundException
//  RuntimeException (Unchecked) -> IllegalArgumentException (You may or may not declare it in the throws clause)


// 2. Change doStuff in Great to throw only IOException instead of FileNotFoundException.
//