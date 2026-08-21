## Notes Modules


### Modules

- A module does not depend or belong to any package. **Packages belong to a module**.
  - There is a way to create an **automatic module** but it is created **using the name of the jar** file in which the classes reside
- A **non-modular jar** placed on the **module-path** results in an **automatic module**
  - Automatic modules are also named modules. Their name is inferred using the name of the jar file.
- A modular jar placed on the module-path results in a named application module
- If a package is available in a jar on the classpath as well as in another jar on the module-path, the one on the classpath is ignored.
- If a module directly uses classes from another jar, then that jar has to be a module - either named or automatic
- Modules are not allowed to have circular/cyclic dependencies
  - e.g. Here, module `m$` requires module `_n` and module `_n` requires module `m$`. This is not allowed.

---

### Module Info

- If you are creating a module, then `module-info.java` must be present
- `module-info.java` must not be empty
- `module-info.java` is compiled into `module-info.class` by the compiler
- It must be placed in the root directory of a module

---

### Modular JDK

- Modular JDK allows modular as well as non-modular applications to co-exist.
- With modular JDK it is possible to assemble and optimize a set of modules and their dependencies **into a custom runtime image**.
- Modular JDK allows a module to export a package only to a specific module as well.


**Example export to specific module**

```java
module A {
    exports internal.utils to B;
}
```
---