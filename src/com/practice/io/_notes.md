## IO Notes

### IZ0-830 Classic IO you should know

- InputStream
- OutputStream
- Reader
- Writer
- FileInputStream
- FileOutputStream
- InputStreamReader
- BufferedReader
- BufferedWriter
- read()
- skip()
- ready()
- close()

---

### Why use InputStreamReader?

`FileInputStream` reads bytes

Suppose your file contains:

```java
ABC
```

`FileInputStream` reads the bytes:
```java
65 66 67
```

But if you want **characters**, you wrap it:

```java
FileInputStream fis = new FileInputStream("test.txt");
InputStreamReader isr = new InputStreamReader(fis);
```

Now you can call:
```java
isr.read();
```

---

### Classic IO

```java
FileInputStream fis =
        new FileInputStream("test.txt");

InputStreamReader reader =
        new InputStreamReader(fis);

reader.read();
reader.skip(2);
reader.ready();
```

---

### FileOutputStream

- `FileOutputStream(fileName2)` always overwrites the file
  - Unless you use the constructor with `true` (append mode), this call truncates the file to zero bytes before writing.

**Example**

```java
public static void copy(String fileName1, String fileName2) throws Exception{
    try (
            InputStream is = new FileInputStream(fileName1);
            OutputStream os = new FileOutputStream(fileName2);  ) {
        byte[] buffer = new byte[1024];
        int bytesRead = 0;
        while ((bytesRead = is.read(buffer)) != -1) {
            os.write(buffer, 0, bytesRead);
            System.out.println("Read and written bytes " + bytesRead);
        }
    }
}   
```