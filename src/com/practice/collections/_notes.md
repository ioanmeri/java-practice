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