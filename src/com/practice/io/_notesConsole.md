For the **Java SE 21 Developer Professional (1Z0-830)** exam, `java.io.Console` belongs to the chapter/category:

## **Java I/O (Input/Output) API**

## Notes Console

- **None** of the calls to Console **throw any checked exception**

---

## What you need to know about `Console` for 1Z0-830

You do **not** need a huge amount of theory. The exam usually tests these points:

---

### 1. Creating/accessing a Console

```java
Console console = System.console();
```

Important:

```java
System.console()
```

can return:

```java
null
```

if there is no console available (very common inside IDEs).

Example:

```java
Console c = System.console();

if (c != null) {
    String name = c.readLine();
}
```

**Available methods**
✅ readPassword
✅ reader
✅ writer
✅ readLine
✅ format

---

### 2. Reading input

#### `readLine()`

```java
String name = console.readLine();
```

Reads text.

With formatting:

```java
String name = console.readLine("Name: ");
```

---

#### `readPassword()`

```java
char[] password = console.readPassword();
```

Important exam point:

* Returns `char[]`
* Does not return `String`

Why?

Because `char[]` can be cleared afterward:

```java
Arrays.fill(password, ' ');
```

A `String` is immutable and stays in memory.

---

### 3. Writing output

Methods:

```java
console.printf("Hello %s", name);

console.format("Value: %d", 10);
```

Both return the `Console` object, allowing chaining:

```java
console.printf("Hello")
       .printf(" World");
```

---

### 4. Character only

`Console` is **not** a byte stream.

No:

```java
readBytes()
writeBytes()
```

It works with characters.

Comparison:

| Class             | Data       |
| ----------------- | ---------- |
| `FileInputStream` | bytes      |
| `FileReader`      | characters |
| `Console`         | characters |

---

## Typical 1Z0-830 questions

### Example 1

```java
Console c = System.console();
String s = c.readLine();
```

Question: What does it read?

✅ Character data.

---

### Example 2

```java
Console c = System.console();
String password = c.readPassword();
```

Result:

❌ Compilation error.

Because:

```java
readPassword()
```

returns:

```java
char[]
```

not:

```java
String
```

---

### Example 3

```java
Console c = System.console();
c.printf("Hello");
```

Valid?

✅ Yes.

---

## Where it fits in your current study plan

Based on the Java SE 21 modules you have been studying, put it under:

```
Module: I/O and Serialization

✓ java.io
    ✓ InputStream / OutputStream
    ✓ Reader / Writer
    ✓ Buffered streams
    ✓ Console
    ✓ Serialization

✓ NIO.2
    ✓ Path
    ✓ Files
    ✓ File attributes
```

For the exam, `Console` is a **small subtopic** compared with `Files`, `Path`, streams, and serialization. You mainly need the API methods and the fact that it handles **characters only**.
