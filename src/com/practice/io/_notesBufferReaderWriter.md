## Buffer Reader Notes

###  BufferedReader

- A `BufferedReader` can wrap any Reader. Both `FileReader` and `BufferedReader` are Readers so are valid.
- `java.nio.file.NoSuchFileException: test.txt`
  - This exception will be thrown when the program tries to create a BufferedReader to read the file specified by the Path object.
  - `var myfile = Paths.get("test.txt");`
  - `try(var bfr = Files.newBufferedReader(myfile, Charset.forName("US-ASCII") )){`


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
BufferedReader handle = new BufferedReader(new FileReader(fullFilePath));
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

### `lines()`

- The `lines()` method has been added to `java.io.BufferedReader` in Java 1.8. It returns `Stream<String>`
- `Stream<String> ref = new BufferedReader(new FileReader(filePath)).lines();`



### Writer

- A Reader can't be converted into a Writer or vice-versa. In other words, there is no way you can chain a Reader and a Writer together.
  - Invalid: `var pw = new PrintWriter(new FileReader(f));`
- `BufferedWriter` **does not have a** `writeUTF()` method.
  - `writeUTF()` belongs to `DataOutputStream` (and `DataOutput`), not Writer/BufferedWriter
  - BufferedWriter's `append` method = works **same as the write(String)** method.
    - It doesn't really append the data to the end of the existing content.
    - **It overwrites the existing content**.
  - A call to `flush` is useful when you want to write the contents to the file **but don't want to close the writer yet**.
  - The `close` method **flushes the stream** and makes sure that **all data is actually written to the file**.
    - If the given code includes a call to `close()`, **there is no need for a call to flush**.

---