# Functional Interfaces

These six are the core functional interfaces used throughout Java’s functional programming features.

### General Notes
- You **cannot reuse the local variable names** that have already been used **in the enclosing method** to declare the variables in you lambda expression. 
  - It would be like declaring the same variable twice.
  - `Employee e = new Employee();`
  - `validateEmployee(e, e->e.age<10000)`
  - Valid: `validateEmployee(e, x->x.age<10000)`

---

### `Function<T, R>`

`Function` always takes two type parameters:

`Function<T, R>` → T = input type, R = return type.

---

### `UnaryOperator<T>`

`UnaryOperator<T>` is a specialization of `Function<T, T>`
-  takes only one type parameter.
- input and output types are the same.

---

### `BinaryOperator<T>`

takes two inputs of same type, returns same type

---

### `Consumer<T>`

`Consumer<T>` returns nothing (void).

---

### `Supplier<T>`

takes no input, returns a value

Local variables captured by a lambda must be:
- `final` or
- `effectively final` (assigned once and never modified)

---

### `Predicate<T>`

takes one input, returns boolean

---