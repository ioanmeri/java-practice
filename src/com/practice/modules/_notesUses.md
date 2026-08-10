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