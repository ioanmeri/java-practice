## Notes Collectors Grouping By

### Example using default toString (here overridden)

```
Collectors.groupingBy(s -> s.getMarks())
```

means:

"For every Student, **calculate a key** using `s.getMarks()`, 
and put **Students** having **the same key into the same List**."

```
20 → [S1:20, S3:20]
30 → [S3:30]
```

---

### Example with grouping by second argument


```java
Collectors.groupingBy(
    Student::getMarks,
    Collectors.mapping(
        Student::getName,
        Collectors.toList()
    )
)
```

First

```java
Student::getMarks
```

determines the key: `Integer`

So far:

```
Map<Integer, ...>
```

But then you have:

```
Collectors.mapping(
    Student::getName,
    Collectors.toList()
)
```

This says:

"After grouping the Students by marks, 
**transform each Student into its name**, then collect those names into a List."

So

```
S1:20 → "S1"
S3:20 → "S3"
```

---

### Collectors Second Argument

The second argument to groupingBy() **must be a Collector**

For example

```
Collectors.toList()
Collectors.toSet()
Collectors.counting()
Collectors.summingInt(...)
Collectors.mapping(...)
Collectors.joining(...)
```

---

### Mental Model

```
                 groupingBy()
                      |
              ┌───────┴────────┐
              ↓                ↓
        classifier        downstream
        determines         determines
        the KEY             the VALUE
```


---

### Common methods

| Code                                                                | Result                       |
| ------------------------------------------------------------------- | ---------------------------- |
| `groupingBy(Student::getMarks)`                                     | `Map<Integer,List<Student>>` |
| `groupingBy(Student::getMarks, toList())`                           | `Map<Integer,List<Student>>` |
| `groupingBy(Student::getMarks, toSet())`                            | `Map<Integer,Set<Student>>`  |
| `groupingBy(Student::getMarks, counting())`                         | `Map<Integer,Long>`          |
| `groupingBy(Student::getMarks, mapping(Student::getName,toList()))` | `Map<Integer,List<String>>`  |
| `groupingBy(Student::getMarks, mapping(Student::getName,toSet()))`  | `Map<Integer,Set<String>>`   |

---