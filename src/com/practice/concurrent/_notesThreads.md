## Thread Notes

### Thread General

- `Thread` implements `Runnable`
  - A `Thread` object can be assigned to a `Runnable` reference.
  - This is valid upcasting: `Runnable r = new Thread();`
  - You cannot instantiate an interface like `Runnable()`

---

### Thread States

- `NEW`
  - Thread created, `start()` not called
- `RUNNABLE`
  - Eligible to run or currently running
- `BLOCKED`
  - Waiting to acquire a monitor (`synchronized`)
- `WAITING`
  - Waiting indefinitely (`wait()`, `join()`)
- `TIMED_WAITING`
  - Waiting with a timeout(`sleep()`, `wait(timeout)`)
- `TERMINATED`
  - `run()` ha completed

---

### Virtual Threads

| Platform Thread             | Virtual Thread                                        |
| --------------------------- | ----------------------------------------------------- |
| One OS thread               | Managed by the JVM                                    |
| Expensive                   | Very lightweight                                      |
| Limited (thousands)         | Millions possible                                     |
| Good for CPU-bound tasks    | Excellent for blocking I/O                            |
| Can be pooled               | Usually **not pooled**                                |
| Created with `new Thread()` | `Thread.ofVirtual()` or `Thread.startVirtualThread()` |

**Properties**

- The `Executors.newWorkStealingPool()` method is used to improve virtual thread performance by reusing threads in a thread pool.
  - It creates a pool of optimum number of platform threads (depending on the underlying hardware), which are then used to execute virtual threads.
- Virtual threads are always **daemon threads**
- Virtual threads **have a fixed thread priority** that cannot be changed.
  - they **do not honor thread priority** at all
-  Virtual thread run utilizes a platform thread to execute code and so
  - it cannot be faster than a platform thread.
- A Virtual thread **executes code on top of a platform thread**
- Creating millions of virtual threads is possible and even normal for a Java program.
  - virtual threads eliminate the need to create thread pools when a large number of tasks are required to be executed in parallel

**Ways to Create**

```java
Thread t1 = Thread.ofVirtual();
t1.start(runnableInstance);

Thread t2 = Thread.startVirtualThread(runnableInstance);
```
or

```
Thread t = Thread.ofVirtual().unstarted(r);
```

---


