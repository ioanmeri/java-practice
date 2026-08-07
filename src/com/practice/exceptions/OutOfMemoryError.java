package com.practice.exceptions;

import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryError {

    public static void main(String[] args) {
        List s1 = new ArrayList( );
        try{
            while(true){
                s1.add("sdfa");
            }
        }catch(RuntimeException e){
            e.printStackTrace();
        }
        System.out.println(s1.size());
    }
}

// It will throw an error at runtime that will not be caught by the catch block.

// The result is:
// java.lang.OutOfMemoryError

// When the array becomes full, Java creates a larger array and copies the elements.
// Eventually, the JVM cannot allocate a larger array.