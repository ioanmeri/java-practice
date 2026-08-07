## Notes Operations

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