package com.practice.interfaces;

interface AmazingInterface {
    String value = "amazing";
    void amazingMethod(String arg);
}

abstract class AmazingClass implements AmazingInterface {
    static String value = "awesome";
    abstract void amazingMethod(String arg1, String arg2);
}


public class Interfaces6 extends AmazingClass implements AmazingInterface {
    public void amazingMethod(String arg1){
        System.out.println("In amazing Method: String arg1");
    }

    public void amazingMethod(String arg1, String arg2){
        System.out.println("In amazing Method: String arg1, String arg2");
    }

    public static void main(String[] args){
        AmazingInterface ai = new Interfaces6();

        //INSERT CODE HERE
        System.out.println("AmazingInterface value: " + AmazingInterface.value);
        System.out.println("AmazingClass value: " + AmazingClass.value);

        ai.amazingMethod(AmazingInterface.value);
        ai.amazingMethod("x1");


//      ai.amazingMethod(value); Fails to compile: 'value' is ambiguous, both 'AmazingClass.value' and 'AmazingInterface.value' match
//      ai.amazingMethod(AmazingInterface.value, AmazingClass.value); Fails to compile, Only void amazingMethod(String arg); in Amazing Interface
//      ((AmazingClass)ai).amazingMethod("x1", value); Fails to compile for the same reason

    }

}