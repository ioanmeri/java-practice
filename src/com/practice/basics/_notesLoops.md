## Loop notes

### Missing initialization and update

```java
for (; data.d1 < 2;) {
    // body
}
``` 

is equivalent to

```java
while (data.d1 < 2) {
    // body
}
```

---

### Declaring a variable with the same name

A for-loop initializer **cannot** declare a variable with the same name as an existing variable in the same method.

**Compilation error**
```java
var i = 20; 

for (var i = 0; i < 10; i++) System.out.print(i + " ")
```
---

### While

- The expression inside a `while` condition **must evaluate to a boolean**.
- `while(true) {` is actually a **valid infinite loop** (can be intentional)
- `while (false) { x=3; }` is a compile-time error because the statement `x=3`; is not reachable;

---

### For

- `for( int i = 0; false; i++) x = 3;`  is also a compile time error because `x=3` is unreachable.

---