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