## Notes Uses

`uses` means "I want to consume a service"

```
module book {
    requires org.pdf;
    uses org.pdf.Print;
}
```

```
book
 │
 ├── requires org.pdf
 │       ↓
 │   I need classes from this module
 │
 └── uses org.pdf.Print
         ↓
     I want to discover implementations
     of Print using ServiceLoader
```

- The `uses` directive **does not require an implementation to exist at compile time.**
- You can compile `book` even if there is no service provider implementation available

---

### Uses Example

A valid `module-info` for a **service user module** that **uses an Order service defined in OrderServiceAPI module** and **implemented by OrderServiceProvider module**

```java
module Customer{
   requires OrderServiceAPI;
   uses com.orderservice.api.Order;
}
```

or

```java
module Customer{
   requires OrderServiceAPI;
   requires OrderServiceProvider;
   uses com.orderservice.api.Order;
}
```

The Customer module does not need to access the `OrderServiceProvider` module directly. It should not even be aware of it. On the other hand, it should require the `OrderServiceAPI` module.

---
