## Paths Notes

### `Path.relativize(Path other)`

only works when **both paths are either**:
- relative → relative
- absolute → absolute

If one is absolute and the other is relative, Java throws:

`IllegalArgumentException: 'other' is different type of Path`

---

### `Path.getName(int index)`

returns the name elements of the path, not the drive letter.

When the index is out of range, `Path.getName(int)` throws:
- IllegalArgumentException

---

### `Path resolve`

- When the argument to resolve starts with the root (such as c: or, on *nix, a /), the result is same as the argument.

**Example**

```java
Path p1 = Paths.get("c:\\temp\\test.txt");
Path p2 = Paths.get("c:\\temp\\report.pdf");
System.out.println(p1.resolve(p2));
// Prints c:\temp\report.pdf
```
---
