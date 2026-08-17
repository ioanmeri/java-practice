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
- Modules **allows a sealed class** and its direct subtypes **to be members of different packages**.
  - Normally, the direct subclasses of a seal class must reside in the same package as the package of the sealed class
  - However, if a **sealed class** belongs to a **named module**, it is allowed to **list classes from different packages** of the **same module in its permits clause**.

---

### Modules and Command Line Options

- Although not recommended, **it is possible to customize what packages a module exports from the command line**
- If a **module wants to read another module but only temporarily**, it can **request such access using command line options**.
  - Even packages that have not been exported in `module-info` can be made accessible using `--add-exports` command line option

---

### Modules Names

Module names have rules:

- They are similar to Java identifiers separated by dots.
- They may contain letters, digits, and underscores.
- They cannot contain `$`

---

### Properties

- Every **module** must reside in a **directory** (or a jar) **of its own**.
  - You cannot have more than one module in a directory.
  - Although you may package a module into a jar, put multiple such module jars in a directory, and put that directory (which contains multiple module jars) on the module path.
- A module can specify **packages** as well as **services**
  - **Packages** are exported and used using the **exports** and **requires** clauses respectively, while **services** are exported and used using the **provides** and **uses** clauses respectively
- Modular JDK is helpful in improving performance of an application
  - The JVM uses various optimization techniques to improve application performance.
  - JSR 376 indicates that these techniques are more effective when it is known in advance that required types are located only in specific modules.
- Java modules **do allow a service consumer** to find a service implementation
  - A service **consumer has to loop through each available service implementation** and pick the one it needs.
- All **subclasses of a sealed class must belong to the same module** (or to the same package if the sealed class is not a part of a named module)
  - So, even if a sealed class is visible outside a module, it cannot be extended by classes of other modules
- A **JImage** is a customized JRE that containts just those parts of a standard JRE that are required for a particular application to run.

---
