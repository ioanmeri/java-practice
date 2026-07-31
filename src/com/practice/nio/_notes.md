## NIO Notes

### IZ0-830  NIO2 you should know

- Path
- Path.of()
- Files.exists()
- Files.copy()
- Files.move()
- Files.delete()
- Files.readString()
- Files.readAllLines()
- Files.newBufferedReader()
- Files.newBufferedWriter()
- resolve()
- normalize()
- relativize()

---


### Typical Classes
- Path
- Paths
- Files
- FileSystem
- DirectoryStream

---

### Examples

```java
Path p = Path.of("test.txt");

String text = Files.readString(p);
```

or 

```java
List<String> lines = Files.readAllLines(p);
```

or

```java
Path path = Path.of("test.txt");
Files.readString(path);
Files.readAllLines(path);
Files.newBufferedReader(path);
Files.newBufferedWriter(path);
```