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
