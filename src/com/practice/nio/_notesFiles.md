## Files

### `Files.move()`

```java
Files.move(source, target);
```

where `target` is **the final path of the moved item**.

**Replace Existing**

```java
Files.move(
    source,
    target,
    StandardCopyOption.REPLACE_EXISTING
);
```

allows replacement.

**COPY_ATTRIBUTES**

```java
Files.copy(p1, p2, StandardCopyOption.COPY_ATTRIBUTES);
```

- Copying of the attributes is platform and system dependent.

---

### `Files.deleteIfExists()`

- If the file/directory exists and is successfully deleted → returns `true`
- If it does not exist → returns `false`
- If deletion fails → throws an exception
- can delete directories.
  - Non-empty directory → exception (`DirectoryNotEmptyException`).
  - It will print `true` if p refers to an empty directory.

---

### `Files.lines`

- `Files.lines(Path path)` method expects a **Path object** as an argument (not a String).
  - `Stream<String> ref = Files.lines(Paths.get(filePath));`

To count the lines you may also use a Collector:
- `Long count = ref.collect(Collectors.counting());`

if you have a File instead of a Path, you may convert the File object to a Path object using File's toPath() method:

```java
File file = new File(filePath);
Stream<String> ref = Files.lines(file.toPath());
```

---

