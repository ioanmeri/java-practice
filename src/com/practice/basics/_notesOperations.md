## Notes Operations

### General

For arithmetic operators (`+`, `-`, `*`, `/`, `%`)
- `byte`, `short`, and `char` are automatically promoted to `int` before the operation.
- the result of arithmetic involving these types is usually `int`
- `byte b = 1;`  `byte c = 2;` `b + c` results to int

---

A compound assignment performs an implicit cast
- `short s = 1;` // `s += 5;` // OK
- But ordinary assignment does not cast automatically.
  - `s = s + 5;   // compile error`

---

- `short = int;` Not allowed
- `char = int;` Not allowed
- `char + byte` becomes `int`
- `float f = int;` Allowed
  - An `int` can be widened to a `float`
  - Automatic widening conversion is allowed

---

### Integral Operations

Whenever both the operands of a mathematical operator (such as / and *) are integral types except long 
- (i.e. byte, char, short, and int), 
- the result is always the integer value that remains 
- after truncating the fractional value.

```java
byte starting = 3;
short firstValue = 5;
int secondValue = 7;
int functionValue = (int) (starting/2 + firstValue/2 + (int) firstValue/3 )
                     + secondValue/2;
System.out.println(functionValue); // 7

// (1 + 2 + 1) + 3 = 7
```

---