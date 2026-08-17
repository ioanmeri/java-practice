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

## JavaC --add-reads

There are three command line options applicable to javac and java that **can 
be used for customizing exports and requires configurations** of modules temporarily 
(temporarily means only for that particular command execution). 


These are: `add-reads`, `add-exports`, and, `add-opens`. 

For example, if you want moduleA to be able to read public packages of moduleB and neither of 
the modules have appropriate information in their respective module-info files, 
then you can use the following commands to enable such access :

```java
javac --add-reads moduleA=moduleB --add-exports moduleB/com.modB.package1=moduleA ...
java --add-reads moduleA=moduleB --add-exports moduleB/com.modB.package1=moduleA ...
```

`--add-reads moduleA=moduleB` implies that **moduleA wants to read all exported packages of moduleB**.

`--add-exports moduleB/com.modB.package1=moduleA` implies that **moduleB exports package com.modB.package1 to moduleA**.

`--add-opens` is used to **provide access to private members** of classes through reflection but is not required for the exam.

---


