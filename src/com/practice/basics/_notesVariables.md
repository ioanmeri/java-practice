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
- var **is not allowed** as an element type of **array**.
  - `var cA[][]` implies that the type of the elements of the cA array is var, which is not allowed. 
  - `var cA = new char[3][];` would be valid.
- 'var' is not allowed in a compound declaration. In other words, you can define only one variable using var.
- Variables declared with var must be assigned a value in the declaration itself because without the value, the compiler will not be able to infer the type of the variable.
- You cannot redeclare a parameter name inside the method using var
- `_` has been made a keyword, it cannot be used as a variable name anymore
  - `var _  = 10 // Invalid`

--- 
### Integers

- `Integer.parseInt(s);` throws a **NumberFormatException** because 12.3 is not an integer.
  - `f = Float.valueOf("12.3");`
  - `int i = Integer.parseInt(s);`
- Comparison on Integers is **reference equality**, not value equality
- Java caches Integer values in the range: `-128 to 127`
  - If the value is outside this range, a new Integer object is created
  - If the final value after `i--` and `i++` is within this range, i will be re-boxed to the cached object
- `int i = Integer.parseInt(s);` throws a `NumberFormatException` if s is 12.3 (not an integer).


---

### Primitives

- Primitive types do not have covariance.

---

### Chars

- When char values participate in arithmetic, they are promoted to int
  -  `System.out.println((char)a1+(char)b1);` = `195`

---

### Double

- The call to `printSum(1, 2.0)` will be bound to `printSum(double... )` 
  - and not to `printSum(int, float)` or `printSum(float, float)`
  - Double is a wider data type than int or float
  - So, a double value cannot be passed to an int or a float parameter.
  - An int value can be passed to a long, float, or double parameter because int is a narrower data type than the other three

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

### Private final

```
private   final   Object   obj;
   ↓        ↓       ↓       ↓
access   cannot   type    variable
         reassign
```
---

### Default Values

- byte, short, char, int, long, float, double: to 0 ( or 0.0 )
- Object types: null
- boolean: false

---

### Objects

- An array of objects can store Objects of any class.
- Primitives (i.e. int, byte, char, short, boolean, long, double, and float) are NOT objects.
- An array (of primitives as well as of objects) is an Object.

**Valid**

```java
new Object[]{ "aaa", new Object(), new ArrayList(), 10}
```

10 is a primitive and not an Object but due to auto-boxing it will be converted into an Integer (object)

```java
new Object[]{ "aaa", new Object(), new ArrayList(), new String[]{""} };
```

Every array is an Object so `new String[]{""}` is also an Object and can be placed in an array of objects

**Not Valid**

```java
new Object[1]{ new Object() }; // can't specify array length if you are initializing it at the same place.

new Object[]{ "aaa", new Object(), new ArrayList(), {} }; // {} is not a valid way to create an Object here
```

---

### Local Variables

- Local variables can have same name as member variables
  - The local variables will simply shadow the member variables with the same names.

---

### Instance Variables

- Instance variables and can only be accessed through a reference.
  - It cannot be accessed directly from a static method because the implicit variable "this" is not available in a static method.