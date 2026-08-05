## Notes Java

### General

`java` is used for **Running modular applications**

```
java -p mods -m my.module/com.example.Main
```

or

```
java --module-path mods --module my.module/com.example.Main
```

- `-p` / `--module-path`
- `-m` / `--module`
- `module/mainClass`

The **module path** is simply **the location where Java looks for modules at runtime** 
(or during compilation with javac)

For example, suppose your source code is:

```
src/
└── com.bank/
    ├── module-info.java
    └── com/
        └── bank/
            └── Main.java
```

You compile it with:

```
javac -d out --module-source-path src -m com.bank
```

The compiler creates:

```
out/
└── com.bank/
    ├── module-info.class
    └── com/
        └── bank/
            └── Main.class
```

Here:
- `out` is the **module path** (it can be `mods`)
- It contains the compiled module `com.bank`

The module path contains **modules**, which can be either:
- Exploded modules (directories)
  - a directory containing the compiled classes
- Modular JARs - JAR file
  - package classes into a JAR
    - Compressed archive
    - Used for distribution

---

### JAR creation

```
jar --create --file=com.bank.jar -C out/com.bank .
```

Now you have

```
mods/
    com.bank.jar
```

Inside the JAR:

```
com.bank.jar
│
├── module-info.class
└── com/
    └── bank/
        ├── Main.class
        └── Account.class
```

Run it:

```
java -p mods -m com.bank/com.bank.Main
```

---

### Running a Non-Modular Application

```
java com.example.Main
```

Java searches for `com.example.Main` on the **classpath**

If the class is in another directory:

```
java -cp out com.example.Main
```

or

```
java --class-path out com.example.Main
```

---

### Module Path vs Classpath

| Classpath              | Module Path                  |
| ---------------------- | ---------------------------- |
| `-cp`                  | `-p`                         |
| Ordinary classes       | Modules                      |
| Unnamed module         | Named modules                |
| No dependency checking | Module dependencies enforced |

---

### Using Both Together

```
java -p mods -cp libs/* -m com.bank/com.bank.Main
```
Meaning
- named modules come from `mods`
- ordinary libraries come from `libs`

---

### Automatic Modules

A normal JAR **without** `module-info.class`

Suppose

```
mysql.jar
```
has no

```
module-info.class
```

If it is placed on

```
-p
```

instead of

```
-cp
```

Java treats it as an **automatic module**.

Example:

```
java -p mods;mysql.jar -m com.bank/com.bank.Main
```

- False: Non-modular JARs must be on the classpath

---

### Unnamed module

The unnamed module is created from the **classpath**

Example:

```
java -cp mylib.jar com.example.Main
```

Everything on the classpath belongs to **unnamed module**

The unnamed module:
- does not have a module name
- does not have `module-info.class`
- exists only on the classpath
- Not on the module path

---