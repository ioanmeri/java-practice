# Functional Interfaces

These six are the core functional interfaces used throughout Java’s functional programming features.

### General Notes
- You **cannot reuse the local variable names** that have already been used **in the enclosing method** to declare the variables in you lambda expression. 
  - It would be like declaring the same variable twice.
  - `Employee e = new Employee();`
  - `validateEmployee(e, e->e.age<10000)`
  - Valid: `validateEmployee(e, x->x.age<10000)`
- A local variable used inside **a lambda**, **a local class**, **an anonymous class**
  - must be `final` or
  - **effectively final**

---

### Functional Interface and Lambdas

To take advantage of lambda expressions, an interface must be a "functional" interface, 
which basically means that **the interface must have exactly one abstract method**.

The following is still a valid functional interface:

```java
@FunctionalInterface
public interface FI{
   int m1(); //valid abstract method
   boolean equals(Object o); //valid declaration
   //but does not count towards the number of abstract methods
   String toString(); //valid declaration
   //but does not count towards the number of abstract methods
}
```



---

### `Function<T, R>`

`Function` always takes two type parameters:

`Function<T, R>` → T = input type, R = return type.

Function takes one argument and returns a value. So `Function<Type>` will not compile. 
It should actually be `Function<T, R>`. For example, `Function<Locale, String>`.

**Example**

```java
Function<Locale, String> f1 = name::toUpperCase;
val = f1.apply(Locale.UK);
```

---

### `UnaryOperator<T>`

`UnaryOperator<T>` is a specialization of `Function<T, T>`
-  takes only one type parameter.
- input and output types are the same.


`IntFunction` is a functional interface that takes an int and returns whatever it is typed to

**Example**

```java
IntFunction<IntUnaryOperator> fo = (int a)-> {
    return (int b) -> a - b;  // IntUnaryOperator, b = 5
};

// or
IntFunction<IntUnaryOperator> fo = a->b->a-b;
```



---

### `BinaryOperator<T>`

takes two inputs of same type, returns same type

---

### `Consumer<T>`

`Consumer<T>` returns nothing (void).

---

### `Supplier<T>`

takes no input, returns a value
- The functional method of the interface `Supplier <T>` is `T get()`.


Local variables captured by a lambda must be:
- `final` or
- `effectively final` (assigned once and never modified)

```java
Supplier s1 = b1::getPrice;
s1.get(); // does not have getAsDouble() -> will not compile
```

---

### `Predicate<T>`

takes **one input**, returns boolean

- `x -> x == null`
- `x->true`


**Variables names in the same method**

You cannot reuse the variable names that have already been used in the same method / block.

It would be like defining the same variable twice in the same scope.

(parameter list) OR single_variable_without_type ->
{ regular lines of code } OR just_an_expression_without_semicolon

**Predicate Types**

When predicate is typed like this `Predicate<List>`, it expects exactly a `List` as input,
`ArrayList` is not valid.

---