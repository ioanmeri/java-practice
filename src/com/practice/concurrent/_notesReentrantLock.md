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