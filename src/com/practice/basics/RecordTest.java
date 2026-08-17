package com.practice.basics;

// Record with canonical and overloaded constructors
record Student(int id, String name) {

    // Compact canonical constructor
    // The compiler automatically adds:
    // this.id = id;
    // this.name = name;
    public Student {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be positive");
        }

        if (name == null || name.isBlank()) {
            // isBlank() returns true if the string is empty or contains only white space codepoints, otherwise false
            // isEmpty() returns true if, and only if, length() is 0
            throw new IllegalArgumentException("Name cannot be empty");
        }

        name = name.toUpperCase();
    }


    // Overloaded constructor
    // Must call another constructor using this(...)
    public Student(String name) {
        this(999, name);
    }


    // Example of a method inside a record
    public String getDescription() {
        return "Student " + name + " has id " + id;
    }
}

public class RecordTest {

    public static void main(String[] args) {

        Student s1 = new Student(101, "John");
        Student s2 = new Student("Mary");

        System.out.println(s1);
        System.out.println(s2);

        System.out.println("ID: " + s1.id());
        System.out.println("Name: " + s1.name());
    }
}



