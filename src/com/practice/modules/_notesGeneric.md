## Modules

- A **non-modular jar** placed on the module-path results in an **automatic module**.
  - Remember that automatic modules are also **named modules**. 
  - Their name is inferred **using the name of the jar** file (or from Automatic-Module-Name entry of its manifest).
- A **modular jar** placed on the module-path results in a **named application module**.
  - Any jar (modular or non-modular) placed on the module-path becomes a named application module.
- If a package is available in a jar on the classpath as well as in another jar on the module-path, the one on the classpath is ignored.
- A module graph **cannot contain cycles**
  - m$  ---> _n
  - _n  ---> m$
- A **module** is a **set of packages** that make sense being grouped together and is designed for reuse.
- The module system ensures that **code that is internal** to a platform implementation is **not accessible from outside** the implementation.
- A **module can access public classes** of only those packages **of another module** **that** the other module **exports**.

---

### Provides Service with Provider

```
module abc.print {
    requires org.pdf;
    provides org.pdf.Print with com.abc.print.PrintImpl;
}
```

`org.pdf.Print` is the **service**

In Java's Module System (JPMS), the word service has a specific meaning: 
- it is the **API (interface or abstract class)** that defines a capability, and 
- providers supply implementations of it.

---

### Modules Names

Module names have rules:

- They are similar to Java identifiers separated by dots.
- They may contain letters, digits, and underscores.
- They cannot contain `$`