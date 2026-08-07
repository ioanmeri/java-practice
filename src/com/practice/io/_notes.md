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
- RandomAccessFile

---

### Why use InputStreamReader?

`FileInputStream` reads **bytes**

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
FileInputStream fis = new FileInputStream("test.txt");

InputStreamReader reader = new InputStreamReader(fis);

reader.read();
reader.skip(2);
reader.ready();
```

---

### FileOutputStream

- `FileOutputStream(fileName2)` always overwrites the file
  - Unless you use the constructor with `true` (append mode), this call truncates the file to zero bytes before writing.
- `OutputStream.write(int)` writes **the lowest 8 bits** of the integer.

DataOutputStream provides methods such as

- writeInt
- writeChar and 
- writeDouble 

for writing complete value of the primitives to a file. 

So if you want to write an **integer** to the file, you should use `writeInt(1)` in which case a file of size **4 bytes** will be created.

You can read back the stored primitives using methods such as DataInputSream.readInt().


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

---

### File

- You can always create a File object whether or not an actual file or directory by that name exists

---

### IO Exceptions

Remember that **most of the I/O operations** (such as opening a **stream on a file**, **reading or writing from/to a file**) 
- throw `IOException`
- `FileNotFoundException` is a subclass of `IOException` and `IndexOutOfBoundsException` is subclass of `RuntimeException`.
- The code can be fixed by replacing FileNotFoundException | IndexOutOfBoundsException with IOException or by adding another catch block that catches IOException.

---

### PrintWriter

- `PrintWriter` writes **characters**, not bytes.
  - OutputStream, `FileOutputStream` writes **raw bytes**.
- The file size depends on the **default character encoding**.
  - UTF-8 → 1 byte
  - UTF-16 → 2 bytes
- `PrintWriter` is never **flushed** or **closed** if it isn't declared as a resource

**Example**


```java
OutputStream os = new FileOutputStream(name);
var pw = new PrintWriter(os);
pw.write(1);
```

writes the character whose **Unicode value is 1**

---

