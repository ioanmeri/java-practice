## Stream Notes

- Note that `count()` is also a terminal operation but it may **short circuit the stream pipeline**, 
    - which means, an implementation may choose to **not execute the stream pipeline** (either sequentially or in parallel) if it is capable of computing the count directly from the stream source. 
    - In such cases no source elements will be traversed and **no intermediate operations will be evaluated**.

**Short-Cirtuiting Terminal Operations**
- allMatch 
- noneMatch 
- anyMatch 
- findFirst 
- findAny

---

## Collectors Notes

- `Collectors.counting()` returns a Long, therefore, the type of the values in the map must be Long instead of Integer

---

### `takeWhile`

`takeWhile` keeps elements **only until the first element that does not satisfy the predicate**.
- Once it encounters a `false`, it **stops processing entirely**.

```java
Arrays.stream(Card.values()).takeWhile(c->c.isRed()).forEach(System.out::print);
```

---

### `reduce()`

Compile error:

```java
letters.stream().reduce("", (a, b)->a.concat(b)).get();
```

This will not compile. There are three flavors of reduce method. 

The one used here directly returns the **final result** instead of returning an **Optional** containing the result. 

So the call to **get() will cause compilation failure**.

- **Parallel reduce + wrong identity** = **suspicious**.
  - `lon.parallelStream().reduce(5, Integer::sum);` // Result won't be the same

---

`forEach`

- `Stream.forEach()` requires a `Consumer<? super T>`
- Consumer → Void

```
DoubleFunction df = x -> x + 10; // DoubleFunction
dList.stream().forEach(df); // A compilation error will occur.

Consumer<Number> c = n -> System.out.println(n); // valid consumer
```

```java
filter(x -> x > 10)       // asks → boolean
map(x -> x * 2)           // changes → new value
forEach(x -> println(x))  // does → void
```

```java
list.stream().forEach(x -> x = x * 2);
// only changes the local lambda parameter x
// It does not change the element in the list
```

---


