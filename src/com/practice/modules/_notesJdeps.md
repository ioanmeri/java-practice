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

### jdeps

- `jdeps -summary` reports **module dependencies**, not packages.
  - The package `java.util` is inside the module: `java.base`

---
