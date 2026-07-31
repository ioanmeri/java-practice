# Command Line

You need to know about three command line options for running a class that is contained in a module:

## 1. `--module-path` or -p:

This option specifies the location(s) of the module(s) that are required for execution. This option is very versatile. You can specify exploded module directories, directories containing modular jars, or even specific modular or non-modular jars here. The path can be absolute or relative to the current directory. For example, --module-path c:/javatest/output/mathutils.jar or --module-path mathutils.jar

You can also specify the location where the module's files are located. For example, if your module is named abc.math.utils and this module is stored in c:\javatest\output, then you can use: --module-path c:/javatest/output.  Remember that c:\javatest\output directory must contain abc.math.utils directory and the module files (including module-info.class) must be present in their appropriate directory structure under abc.math.utils directory.

You can specify as many jar files or module locations separated by path separator (; on windows and : on  *nix) as required.

> NOTE: -p is the short form for --module-path.(Observe the single and double dashes).

---

## 2. `--module` or `-m`: 

This option specifies the module that you want to run. For example, if you want to run abc.utils.Main class of abc.math.utils module, you should write --module abc.math.utils/abc.utils.Main
If a module jar specifies the Main-Class property in its MANIFEST.MF file, you can omit the main class name from  --module option. For example, you can write, --module abc.math.utils instead of --module abc.math.utils/abc.utils.Main.

> NOTE: -m is the short form for --module.(Observe the single and double dashes).

Thus,
```bash
java --module-path mathutils.jar --module abc.math.utils/abc.utils.Main is same as
java -p mathutils.jar -m abc.math.utils/abc.utils.Main
```


> NOTE: It is possible to treat modular code as non-modular by ignoring module options altogether. For example, if you want to run the same class using the older classpath option, you can do it like this:
java -classpath mathutils.jar abc.utils.Main

## 3. `-classpath`

Remember that modular code cannot access code present on the -classpath but "automatic modules" are an exception to this rule. When a non-modular jar is put on --module-path, it becomes an "automatic module" but it can still access all the modular as well as non-modular code. In other words, a class from an automatic module can access classes present on --module-path (only the ones that are exported by the modules) as well as on -classpath without having any "requires" clause (remember that there is no module-info in automatic modules).

Thus, if your modular jar A depends on a non-modular jar B, you have to put that non-modular jar B on --module-path. You must also add appropriate requires clause in your module A's module-info, otherwise compilation of your module will not succeed. Further, if the non-modular jar B depends on another non-modular jar C, then the non-modular jar C may be put on the classpath or module-path.

---

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

