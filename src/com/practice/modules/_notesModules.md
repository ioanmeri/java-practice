## Notes Modules


### Modules

- A module does not depend or belong to any package. Packages belong to a module.
  - There is a way to create an **automatic module** but it is created **using the name of the jar** file in which the classes reside
- If you are creating a module, then `module-info.java` must be present
- A non-modular jar placed on the module-path results in an **automatic module**
  - Automatic modules are also named modules. Their name is inferred using the name of the jar file.
- A modular jar placed on the module-path results in a named application module
- If a package is available in a jar on the classpath as well as in another jar on the module-path, the one on the classpath is ignored.

---

### Module Info

- `module-info.java` must not be empty
- `module-info.java` is compiled into `module-info.class` by the compiler
- It must be placed in the root directory of a module