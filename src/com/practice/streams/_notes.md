## Stream Notes

- Note that `count()` is also a terminal operation but it may **short circuit the stream pipeline**, 
    - which means, an implementation may choose to **not execute the stream pipeline** (either sequentially or in parallel) if it is capable of computing the count directly from the stream source. 
    - In such cases no source elements will be traversed and **no intermediate operations will be evaluated**.

**Short-Cirtuiting Terminal Operations**
- allMatch 
  - returns `boolean`
- noneMatch 
  - returns `boolean`
- anyMatch 
  - returns `boolean`
- findFirst 
  - returns `Optional<T>`: Returns the **first element**
- findAny
  - returns `Optional<T>` : Returns **any element**

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

### `average`

```java
OptionalDouble x = is1.filter(i->i%2 == 0).average();
```

Remember that `average()` methods of all numeric streams (i.e. **IntStream, DoubleStream, and LongStream**) returns an `OptionalDouble`
- If the stream has no elements (as is the case in this question), the returned OptionalDouble will be empty (not 0 or null).

---

### `sum`

```java
int y = is2.filter( i->i%2 != 0 ).sum();
```

But the `sum()` methods of the **numeric streams return a primitive value**
of the same type **i.e. IntStream returns an int**, DoubleStream returns a double, and LongStream returns a long. If the stream is empty, the sum() method returns 0.

---





