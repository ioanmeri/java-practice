## Modules

- A non-modular jar placed on the module-path results in an **automatic module**.
  - Remember that automatic modules are also named modules. Their name is inferred using the name of the jar file (or from Automatic-Module-Name entry of its manifest).
- A modular jar placed on the module-path results in a named application module.
  - Any jar (modular or non-modular) placed on the module-path becomes a named application module.
- If a package is available in a jar on the classpath as well as in another jar on the module-path, the one on the classpath is ignored.

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