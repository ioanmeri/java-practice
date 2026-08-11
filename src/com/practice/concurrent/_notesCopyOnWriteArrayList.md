## CopyOnWriteArrayList

- A **thread-safe** variant **of ArrayList** in which all mutative operations 
- (add, set, and so on) are implemented by making a **fresh copy of the underlying array**.

This is ordinarily too costly, but may be more efficient than alternatives when traversal operations vastly outnumber mutations, and is useful when you cannot or don't want to synchronize traversals, yet need to preclude interference among concurrent threads. 

The "snapshot" style iterator method uses a reference to the state of the array at the point that the iterator was created. 

This array never changes during the lifetime of the iterator, so interference is impossible and **the iterator is guaranteed not to throw** `ConcurrentModificationException`. 

The iterator will not reflect additions, removals, or changes to the list since the iterator was created. Element-changing operations on iterators themselves (remove, set, and add) are not supported. These methods throw UnsupportedOperationException

---

**Options**

```java
var sList = new CopyOnWriteArrayList<Student>();
```

- Multiple threads can safely add and remove objects from sList simultaneously
- **You can add** null elements in `CopyOnWriteArrayList` (as well as in a regular ArrayList).
- Remember that HashMap supports adding null key as well as null values but ConcurrentHashMap does not.

---