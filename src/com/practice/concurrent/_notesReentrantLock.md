## Notes ReentrantLock


### ReentrantLock General

- `ReentrantLock` internally behaves **as if it has a counter (hold count)** for the thread that owns it.
- The lock is released only when that counter returns to `0`.
- `tryLock()` does two things:
  - Tries to acquire the lock
  - If successful, it **actually acquires the lock** and **increases** the hold **count**
  - return `true`

---

### Reentrant Basic

```java
Lock lock = new ReentrantLock();
```

A thread can acquire it:

```java
lock.lock();
```

and release it:

```java
lock.unlock();
```

---

### ReentrantReadWriteLock

From a `ReadWriteLock`, you can get one read lock (by calling `lock.readLock()` ) and one write lock (by calling `lock.writeLock()` ). 

Even if you call these methods multiple times, the same lock is returned.

```java
private ReadWriteLock lock = new ReentrantReadWriteLock();

lock.readLock().lock();

lock.readLock().unlock();
```

- if one thread is reading, other threads can read, but no thread can write. 
- If one thread is writing, no other thread can read or write.


Methods that do not modify the collection (i.e. the threads that just "read" a collection) 
should acquire a read lock 
and threads that modify a collection should acquire a write lock.



---
