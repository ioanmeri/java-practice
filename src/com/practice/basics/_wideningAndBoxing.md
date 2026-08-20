### Widening and Boxing

Java allows:

- primitive widening
    - int → long ✔
- boxing
    - int → Integer ✔
- unboxing
    - Integer → int ✔

But Java does NOT allow:

wrapper widening
- Integer → Long ✘

There is no inheritance relationship between Integer and Long.
Both extend Number, but neither is a subtype of the other.

---

### Widening is preferred over boxing/unboxing.

```java

public static void printSum(int a, int b){
  System.out.println("In int "+(a+b));
}

public static void printSum(Integer a, Integer b){
  System.out.println("In Integer "+(a+b));
}

printSum(1, 2); // will choose "In int"

//  if printSum(int, int) method were not there in the code, printSum(double, double) 
//  would have been invoked instead of printSum(Integer, Integer)
```

---

### Examples

- `short s = 12 `
  - This is valid since 12 can fit into a short and an implicit narrowing conversion can occur.
- `long g = 012;`
  - 012 is a valid octal number.
- `float f = -123;`
  - Implicit widening conversion will occur in this case.
  -  an int and any valid int can be assigned to a float or a double variable without a cast.
- `double d = 320;`
  - any valid int can be assigned to a double or even a float without any cast.
- `char c = 320;`
  - 320 is below the maximum value that a char can take, which is `2^16 -1`
  - Remember that char can take only positive values.
---
