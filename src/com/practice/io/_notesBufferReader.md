## Buffer Reader Notes

###  BufferedReader

- A `BufferedReader` can wrap any Reader. Both `FileReader` and `BufferedReader` are Readers so are valid.


---

`mark()`

The mark remains valid until one of these happens:
- You call `mark()` again
- You read more than the specified read-ahead limit
  - `mark(100)` 100 characters here
- The stream is closed

You can reread the same section as many times as you want until the bookmark becomes invalid.

---

`reset()`

- You return to that bookmark

---

### BufferedReader constructor

The constructor is:

```java
BufferedReader(Reader in)
```

Valid examples:

```java
BufferedReader handle =
    new BufferedReader(new FileReader(fullFilePath));
```

```java
BufferedReader handle =
    new BufferedReader(
        new FileReader(new File(fullFilePath))
    );
```

and the `FileReader` construstor is

```java
new FileReader(String path)
new FileReader(File file)
```

---

### Writer

- A Reader can't be converted into a Writer or vice-versa. In other words, there is no way you can chain a Reader and a Writer together.
  - Invalid: `var pw = new PrintWriter(new FileReader(f));`