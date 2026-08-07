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

---

### `Files.deleteIfExists()`

- If the file/directory exists and is successfully deleted → returns `true`
- If it does not exist → returns `false`
- If deletion fails → throws an exception
- can delete directories.
  - Non-empty directory → exception (`DirectoryNotEmptyException`).
  - It will print `true` if p refers to an empty directory.