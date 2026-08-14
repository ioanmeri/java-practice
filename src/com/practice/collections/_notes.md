## Collection Notes

- **Comparator** is primarily used for sorting collections.

---

### `list.of`

- `List.of()` does not allow null elements
- Creates an immutable list, also `List.copyOf`
  - Cannot add
  - Cannot remove
  - Cannot sort
  - Cannot replace elements
  - will cause an `UnsupportedOperationException` to be thrown at runtime
- Does **not** share the array afterward

---

### `Arrays.asList()`

- creates a **fixed-size** list
  - cannot add
  - cannot remove
  - can set
  - can sort

---

### Collectors

- `Collectors.toMap(keyMapper, valueMapper)` **does not know how to resolve duplicate keys**.
  - it throws an: `IllegalStateException`
  - But if there are three arguments: The merge function handles duplicate keys.

---

### LinkedHashMap

- `LinkedHashMap` **preserves insertion order**.
  - In comparison with a `HashMap` does **not guarantee iteration order**.

```java
.collect(
    Collectors.toMap(
        Map.Entry::getKey,
        Map.Entry::getValue,
        (x, y) -> x - y,
        LinkedHashMap::new)
);
```

When you create the resulting Map, use a LinkedHashMap instead of the default HashMap.

---

### Collections sort

```java
Object[] sa = { 100, 100.0, "100" }
Collections.sort(Arrays.asList(sa), null);
// Throws an exception at run time
```

If the second parameter to `Collections.sort(List<T> list,  Comparator<? super T> c)` is `null`, the elements' natural ordering is used for comparing them. (There is no NullPointerException.)  

Natural ordering means that the sort method will make use of `java.lang.Comparable` interface and will call `compareTo` method on the objects stored in the collection.

In this case, the implementation of `compareTo` methods of String, Integer, and Double classes **are not compatible**

**Correct Way**

```java
Object[] sa = { 100, 100.0, "100", "-100", "-200", "a", "A", "ab" };
Comparator<Object> c = (a, b)->a.toString().compareTo(b.toString());
Collections.sort(Arrays.asList(sa), c);
```

---
