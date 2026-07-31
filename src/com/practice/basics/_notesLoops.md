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
