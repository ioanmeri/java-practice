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