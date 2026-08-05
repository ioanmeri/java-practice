## Javac command notes

## 4. `--module-source-path`


`--module-source-path` tells javac how to find your module sources by mapping module names to directory paths.

It tells the compiler:

> “My source files are organized by module name.
Each module lives in its own directory.
Please compile them accordingly.”

```java
module enthu.finance{
  exports com.enthu.Reports;
  requires enthu.utils;
}
```

So the compiler expects a directory structure like:

```
src/
    enthu.finance/
        module-info.java
        com/enthu/Reports/...
    enthu.utils/
        module-info.java
        com/enthu/utils/...
```

```bash
javac --module-source-path src -d out src/enthu.finance/module-info.java src/enthu.utils/module-info.java
```
`-d` tells javac where to place the compiled .class files.
- Put all compiled output into this directory

**Summary**

`--module-source-path` maps module names → directory names.

Each module must be in a directory whose name matches the module name.

module-info.java must be inside that directory.

---