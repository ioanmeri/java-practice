package com.practice.generics;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerSuperExample {

    static class Person {
        String name;

        Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{name='" + name + "'}";
        }
    }

    static class Employee extends Person {

        Employee(String name) {
            super(name);
        }

        @Override
        public String toString() {
            return "Employee{name='" + name + "'}";
        }
    }


    static void processEmployees(
            List<Employee> employees,
            Consumer<? super Employee> consumer) {

        System.out.println("Processing employees...");
        for (Employee employee : employees) {
            consumer.accept(employee);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee("John"),
                new Employee("Alice"),
                new Employee("Bob")
        );

        // Consumes Employee
        Consumer<Employee> employeeConsumer =
                e -> System.out.println("Employee Consumer -> " + e);

        // Consumes Person
        Consumer<Person> personConsumer =
                p -> System.out.println("Person Consumer -> " + p);

        // Consumes Object
        Consumer<Object> objectConsumer =
                o -> System.out.println("Object Consumer -> " + o);

        System.out.println("=== Consumer<Employee> ===");
        processEmployees(employees, employeeConsumer);

        System.out.println("=== Consumer<Person> ===");
        processEmployees(employees, personConsumer);

        System.out.println("=== Consumer<Object> ===");
        processEmployees(employees, objectConsumer);


        System.out.println("=== Stream.forEach ===");

        // Stream.forEach also accepts Consumer<? super Employee>
        employees.stream().forEach(personConsumer);
    }
}