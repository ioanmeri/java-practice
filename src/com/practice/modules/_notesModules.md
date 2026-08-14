## Notes Modules


### Modules

- A module does not depend or belong to any package. Packages belong to a module.
  - There is a way to create an **automatic module** but is is created **using the name of the jar** file in which the classes reside
- If you are creating a module, then `module-info.java` must be present


---

### Module Info

- `module-info.java` must not be empty
- `module-info.java` is compiled into `module-info.class` by the compiler
- It must be placed in the root directory of a module