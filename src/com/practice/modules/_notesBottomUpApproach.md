## Notes Bottom Up Approach

### Bottom Up Approach for modularizing an application

While modularizing an app using the bottom-up approach, you need to 
- **convert lower level libraries i.e. dependencies into modular jars** 
- before you can convert the higher level libraries. 

For example, if a class in **A.jar** directly uses a class from **B.jar**, and a class in **B.jar** directly uses a class from **C.jar**, 
- You need to first modularize **C.jar** and then **B.jar** before you can modularize **A.jar**.


Thus, bottom up approach is possible only when the dependencies are modularized already. 

Effectively, when bottom-up migration is complete, every class/package of an application is put on the module-path. Nothing is left on the classpath.

---

### Theory

Yes — **this is a different and much more specific meaning of "bottom-up."** Here it refers to **JPMS/module migration**, and your description is correct.

Let's use your exact A → B → C example.

### The dependency structure

Suppose:

```text
A.jar
  |
  | uses
  ↓
B.jar
  |
  | uses
  ↓
C.jar
```

So:

```text
A → B → C
```

where the arrow means **"depends on."**

For example:

```java
// A.jar
class A {
    B b;
}
```

```java
// B.jar
class B {
    C c;
}
```

```java
// C.jar
class C {
}
```

### Why start with C?

Because **C has no dependency on B or A**.

You can turn C into a module first:

```text
C.jar
 ↓
module C
```

For example:

```java
module c {
    exports c.package;
}
```

Then B can be modularized because its dependency, C, is already a module:

```java
module b {
    requires c;
    exports b.package;
}
```

Finally A can be modularized:

```java
module a {
    requires b;
    exports a.package;
}
```

So the migration proceeds:

```text
             BOTTOM
               ↓
              C.jar
               ↓
           module C
               ↓
              B.jar
               ↓
           module B
               ↓
              A.jar
               ↓
           module A
               ↑
              TOP
```

That's why it's called **bottom-up**.

---

## Why can't we start with A?

Suppose you try to modularize A first:

```java
module a {
    requires b;
}
```

But B is still a **non-modular JAR**.

That's possible in some migration scenarios because an ordinary JAR can become an **automatic module** when placed on the module path.

However, the **true bottom-up migration approach** means that you progressively modularize the dependencies first.

So:

```text
C → B → A
```

rather than:

```text
A → B → C
```

---

## The important exam distinction

There are two common migration approaches you should remember for **JPMS**:

### Bottom-up

Start with the **lowest-level dependencies**:

```text
C → B → A
```

You modularize:

```text
C first
B second
A last
```

Eventually:

```text
Module A
   ↓
Module B
   ↓
Module C
```

Everything ends up on the **module path**.

---

### Top-down

Start with the **highest-level application**:

```text
A → B → C
```

You can initially put the existing JARs on the **module path as automatic modules** and migrate them progressively.

So you might temporarily have:

```text
Module A
   ↓
Automatic Module B
   ↓
Automatic Module C
```

and gradually convert the automatic modules into explicit modules.

---

### The easiest way to remember it

Think about **dependencies**:

```text
A depends on B
B depends on C
```

**Bottom-up = follow the dependencies backwards:**

```text
C → B → A
```

**Top-down = start from the application:**

```text
A → B → C
```

For your **1Z0-830 exam**, the key phrase to recognize is:

> **Bottom-up migration: modularize the lowest-level dependencies first, then move upward to the libraries/applications that depend on them.**

And yes, the final goal of a complete bottom-up migration is that the application is fully modularized, with the relevant code on the **module path rather than the classpath**.
