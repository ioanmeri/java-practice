## Generic Notes 

### Generic Content

- Introduction to generics  
    - Why Java added them, type safety, compile‑time checking.
- Generic classes & methods  
  - How to define and use them.
- Wildcards & bounds  
  - Unbounded wildcard: `List<?>`
  - Upper‑bounded wildcard: `List<? extends Number>`
  - Lower‑bounded wildcard: `List<? super Integer>`
- Generics in collections  
  - How `List<T>`, `Map<K,V>` use generics.
- Type erasure  
  - What happens at runtime.

---

### Generics Introduce

- Type parameters (`<T>`, `<E>`, `<K,V>`)
- Generic classes and methods
- Bounded types (extends, super)
- Wildcards (?, ? extends, ? super)
- Type erasure
- Generic collections (List<T>, Map<K,V>, etc.)

---

### General Notes

- lower‑bounded wildcards (? super) are not covariant.
  - you cannot narrow the return type.
- wildcards (? super, ? extends) are invariant for overriding.
- The override must use the exact same return type.

