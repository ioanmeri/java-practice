## TreeMap

### Basics

A TreeMap keeps its **entries sorted according to its keys**.

Example:

```
Map<Integer, String> map = new TreeMap<>();

map.put(30, "C");
map.put(10, "A");
map.put(20, "B");

System.out.println(map);
```

Output:

```
{10=A, 20=B, 30=C}
```

**Properties**
- By default, TreeMap uses the keys' **natural ordering**.
- A Map **cannot have duplicate keys**.
  - The second `put()` replaces the value.
- Does **not normally allow a null key** when using natural ordering
  - `map.put(null, "A");` will result in a `NullPointerException`


---

### Provide a Comparator

You can tell `TreeMap` how to sort its keys

```
TreeMap<Integer, String> map =
    new TreeMap<>(Comparator.reverseOrder());

map.put(10, "A");
map.put(30, "C");
map.put(20, "B");

System.out.println(map);
```

```
{30=C, 20=B, 10=A}
```

---

### Key must be comparable

```java
TreeMap<Student, String> map = new TreeMap<>();
```

then `Student` must be able to be compared

Usually that means `Student` implements:

```java
Comparable<Student>
```

or you supply a `Comparator<Student>`

Otherwise, you can get a `ClassCastException` when the map needs to compare keys.

---

### NavigableMap methods

Because `TreeMap` implements `NavigableMap`, you need to know methods such as:

```
lowerKey()    // <  target
floorKey()    // <= target
ceilingKey()  // >= target
higherKey()   // >  target
```

---

### `firstKey()` and `lastKey()`

Because it's sorted:

```
map.firstKey()
```

returns the smallest key.

```
map.lastKey()
```
returns the largest key.

---

### `firstEntry()` and `lastEntry()`

You can get the entire entry:

```
map.firstEntry()
map.lastEntry()
```

For example:

```
firstEntry() → 10=A
lastEntry()  → 30=C
```

---

### `pollFirstEntry()` and `pollLastEntry()`

These are especially useful to recognize.

```
map.pollFirstEntry()
```

returns the first entry **and removes it**.

Similarly:

```
map.pollLastEntry()
```

returns the last entry **and removes it**.

Example:

```
TreeMap<Integer, String> map = new TreeMap<>();

map.put(10, "A");
map.put(20, "B");
map.put(30, "C");

System.out.println(map.pollFirstEntry());
System.out.println(map);
```

```
10=A
{20=B, 30=C}
```

---

### `subMap`, `headMap`, `tailMap`

Suppose:

```
TreeMap<Integer, String> map = new TreeMap<>();

map.put(10, "A");
map.put(20, "B");
map.put(30, "C");
map.put(40, "D");
```

`headMap`

```java
map.headMap(30)
```

means keys **less than 30**.

Result:

```
{10=A, 20=B}
```

There is also:

```
map.headMap(30, true) // which includes 30
```

---

`tailMap`

```java
map.tailMap(30)
```

means 30 and everything **after it**

Result:

```
{30=C, 40=D}
```

```
map.tailMap(30, false) // {40=D}
```

---

`subMap`

This is probably the most important range method.

```java
map.subMap(20, 40)
```

means:

```
20 <= key < 40
```

Result

```
{20=B, 30=C}
```

You can explicitly control both boundaries:

```
map.subMap(20, true, 40, true)
```

means:

```
20 <= key <= 40
```
Result:

```
{20=B, 30=C, 40=D}
```
Memorize:

```
subMap(from, to)

from → inclusive
to   → exclusive
```

---

### descendingMap()

You can get the map in reverse key order:

```
map.descendingMap()
```

For:

```
{10=A, 20=B, 30=C}
```

you get:

```
{30=C, 20=B, 10=A}
```

---

### descendingKeySet()

Returns the keys in reverse order.

```
map.descendingKeySet()
```

Result:

```
[30, 20, 10]
```

Remember the return type:

```
NavigableSet<K>
```

---

### `TreeMap` and `Collection`

This is **wrong**:

```java
Collection<String> c = new TreeMap<>();
```

because:

```
TreeMap → Map

// NO TreeMap → Collection
```

But this is correct:

```java
Map<Integer, String> map = new TreeMap<>();
```

and 

```
Collection<String> values = map.values();
```

is correct because `values()` returns a `Collection`

Also:

```java
Set<Integer> keys = map.keySet();
```

and:

```java
Set<Map.Entry<Integer,String>> entries = map.entrySet();
```


---

### `TreeMap` vs `TreeSet`

This is another common confusion.

**TreeSet**

Stores elements:

```java
TreeSet<Integer> set = new TreeSet<>();

set.add(30);
set.add(10);
set.add(20);
```

Result:

```
[10, 20, 30]
```

**TreeMap**

Stores **key-value pairs**:

```java
TreeMap<Integer, String> map = new TreeMap<>();

map.put(30, "C");
map.put(10, "A");
map.put(20, "B");
```

Result:

```
{10=A, 20=B, 30=C}
```

### TreeMap vs HashMap vs LinkedHashMap

|                  | HashMap      | LinkedHashMap | TreeMap      |
| ---------------- | ------------ | ------------- | ------------ |
| Map?             | Yes          | Yes           | Yes          |
| Sorted?          | No           | No            | **Yes**      |
| Insertion order? | No guarantee | **Yes**       | No           |
| Sorted by        | —            | —             | **Keys**     |
| Null key         | Yes          | Yes           | Generally no |
| Null values      | Yes          | Yes           | Yes          |
| Duplicate keys   | No           | No            | No           |


The key exam distinction:

```
HashMap
    ↓
fast general-purpose map
no ordering guarantee

LinkedHashMap
    ↓
insertion order

TreeMap
    ↓
sorted keys
```

---

### A major trap: modifying a TreeMap view

Methods such as:

```
keySet()
values()
entrySet()
```

return **views backed by the map**.

For example:

```java
TreeMap<Integer, String> map = new TreeMap<>();
map.put(10, "A");
map.put(20, "B");

Set<Integer> keys = map.keySet();

keys.remove(10);
```

The map is also modified:

```
{20=B}
```

---

### `Map.Entry`

```
map.entrySet()
```

returns:

```
Set<Map.Entry<K,V>>
```

Each entry contains:

```
entry.getKey()
entry.getValue()
```

For example:

```java
for (Map.Entry<Integer, String> e : map.entrySet()) {
    System.out.println(e.getKey());
    System.out.println(e.getValue());
}
```

---





