## Variable Notes

### Var

- `var` declarations are allowed only for **local variables** 
  - i.e. variables defined inside method body and 
  - in for loops
- It cannot be used for:
  - instance variables
  - static variables
  - method parameters
  - return types
- var is not allowed as an element type of array.
  - `var cA[][]` implies that the type of the elements of the cA array is var, which is not allowed. 
  - `var cA = new char[3][];` would be valid.
- 'var' is not allowed in a compound declaration. In other words, you can define only one variable using var.
- Variables declared with var must be assigned a value in the declaration itself because without the value, the compiler will not be able to infer the type of the variable.
- You cannot redeclare a parameter name inside the method using var

--- 
### Integers

- `Integer.parseInt(s);` throws a **NumberFormatException** because 12.3 is not an integer.
  - `f = Float.valueOf("12.3");`
  - `int i = Integer.parseInt(s);`
- Comparison on Integers is **reference equality**, not value equality
- Java caches Integer values in the range: `-128 to 127`
  - If the value is outside this range, a new Integer object is created
  - If the final value after `i--` and `i++` is within this range, i will be re-boxed to the cached object


---

### Primitives

- Primitive types do not have covariance.

---

### Chars

- When char values participate in arithmetic, they are promoted to int
  -  `System.out.println((char)a1+(char)b1);` = `195`

---


### Static fields and methods

- Static fields can be accessed through an instance (though not recommended).
- You cannot declare a local variable with the same name as an already accessible static field
- Instance methods always take precedence when invoked on an object reference, over static methods
- Static and instance methods can have the same name
- Overloading between static and instance methods is allowed

---

### This

- Cannot use 'this' in a static context

---

### Final Variables

- A `final` instance variable **must be assigned exactly once**, and **before the constructor completes**. This can be done in
  - an instance initializer block
  - the constructor
  - or at the point of declaration

---

### String

- `intern()` returns the reference from the String Pool.
  - "Give me the pooled version of this string."
  - `String internedExamName = uniqueExamName.intern();`
  - `new String()` always creates a new String object on the heap
- `StringBuilder sb = new StringBuilder("How are you?");`
  - `StringBuilder` overrides `toString()` and the actual characters
- Default `Object.toString()` returns `ClassName@hashcode`
- The original string does not change unless reassigned:
  - `String s = "";`
  - `s.concat("hello");` // difference with StringBuilder
  - `s = s.concat("hello");` // Only here changes
- Local String (and other) variables does not have a default value

---

### StringBuilder

- **Mutable objects**
  - `StringBuilder sb = new StringBuilder();`
  - `sb.append("hello");`
  - The same object changes 

---

### `null`

- `null` is compatible with any reference type
- So all three methods are applicable:
  - `method(Object)`
  - `method(IOException)`
  - `method(FileNotFoundException)`

```
Object
   │
Exception
   │
IOException
   │
FileNotFoundException
```

the most specific is: `FileNotFoundException`

---

### Long

- `long g = 012` is a valid octal number.

---

### Float

- `float f = -123;` Implicit widening conversion will occur in this case.
- `Float.parseFloat` It throws a `NumberFormatException` when the given string **does not contain a valid floating point number**.
  - `Float.NEGATIVE_INFINITY` valid
  - `Float.POSITIVE_INFINITY` valid
  - `Float.NaN` valid


---

