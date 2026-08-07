package com.practice.exceptions;

public class NullPointerException {

    public static void main(String[] args) {
        try{
            RuntimeException re = null;
            throw re;
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}

// Compiles and prints
// java.lang.NullPointerException: Cannot throw exception because "re" is null

// A thrown exception reference must point to an actual object.
// Since the reference is null, Java throws:
// java.lang.NullPointerException