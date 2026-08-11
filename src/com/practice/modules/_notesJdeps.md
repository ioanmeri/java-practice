## Notes JDeps

### JDeps

- The `jdeps` tool is used to find out all **dependencies** of a class file or a jar file.
- It inspects the given class file (or all class files inside a jar files) and 
  - **finds out all the required modules** 
  - and **packages** that are referred to **by this class or jar** file.
- You can **add** module **jars** and other jars in its search path using `--module-path` and `--classpath` options.
- `jdeps` needs **the path to the file** that you want to inspect

---

**Example**

identify class and module dependencies of a **class** named `test.A` of module named `moduleA`

```bash
jdeps --module-path out out\moduleA\test\A.class
```

---

### `jdeps -summary`

- `jdeps -summary` reports **module dependencies**, not packages.
  - The package `java.util` is inside the module: `java.base`

---

### `jdeps -jdkinternals or --jdk-internal`

- It analyzes all classes of the given jar file for class level **dependence on jdk's internal API**.
  - If any such dependence is found, it is printed with a suggestion for replacement
- It performs static analysis
  - Jdeps does not execute any classes/modules. It only inspects the code. 
  - Thus, it cannot find out dependencies that are created due classes loaded at run time using reflection API.

**Overview**
- Finds class-level dependencies **in the JDK internal APIs**.
- JDK internal APIs are unsupported and private to JDK implementation that are subject to be removed

---

