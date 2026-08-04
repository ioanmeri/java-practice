package com.practice.io;

import java.io.*;

class Person implements Serializable {
    String name;
    Person(String name){
        this.name = name;
    }
}

class Student extends Person{
    String school;
    public Student(String name, String school){
        super(name);
        this.school = school;

    }
    public String toString(){
        return name+" "+school;
    }
}

public class Serializable2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException  {
        Person p = new Student("Bob Dylan", "NYU");
        try(
                ObjectOutputStream oos = new ObjectOutputStream(
                        new FileOutputStream("student.ser"));
                ObjectInputStream ois = new ObjectInputStream(
                        new FileInputStream("student.ser"));
        ){
            oos.writeObject(p);
            oos.flush();
            System.out.println((Student)ois.readObject());
        }
    }
}

// **ClassNotFoundException**: To rebuild this object, you need the class Student
// The object stored in the file is not just the field values:
// Java also stores metadata about the class:
// Class: Student
// Fields:
//    name
//    school


// flush() forces any buffered data to be written immediately to the underlying output destination.
// Program
//   |
//   | write()
//   ↓
//Buffer (memory)
//   |
//   | flush()
//   ↓
//File / Network / Console

