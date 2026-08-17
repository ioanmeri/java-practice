package com.practice.exceptions;

public class ThowsCheckedExceptions {

//    public static void myMethod(int x) throws Exception // Also valid
    public static void myMethod(int x) throws ClassNotFoundException, NoSuchFieldException
    {
        try{
            if(x == 0){
                throw new ClassNotFoundException();
            }
            else throw new NoSuchFieldException();
        }catch(RuntimeException e){
            throw e;
        }
    }
}

// - ClassNotFoundException and NoSuchFieldException are checked exceptions (they extend from java.lang.ReflectiveOperationException)
// - are thrown when you use Java reflection mechanism to load a class and access its fields

// Class c = Class.forName("test.MyClass") //may throw ClassNotFoundException
// java.lang.reflect.Field f = c.getField("someField"); // //may throw NoSuchFieldException

// the catch(RuntimeException e) block will not be able to catch either of the exceptions because RuntimeException is not a superclass of either of them
