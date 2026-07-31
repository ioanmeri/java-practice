## Concurrent Notes

### Runnable and Callable

All you need to do to execute Runnables and Callables is to submit them to the cached thread pool. 

A cached thread pool creates new threads as needed, but will reuse previously constructed threads when they are available. 

This pool will typically improve the performance of programs that execute many short-lived asynchronous tasks. 

Calls to execute will reuse previously constructed threads if available. 

If no existing thread is available, a new thread will be created and added to the pool. 

Threads that have not been used for sixty seconds are terminated and removed from the cache. 

Thus, a pool that remains idle for long enough will not consume any resources. 

Note that pools with similar properties but different details (for example, timeout parameters) may be created using ThreadPoolExecutor constructors.

---

### Volatile

Volatile does **NOT guarantee atomicity**

```java
class Data{
    public volatile int d1 = 0;
    public AtomicInteger d2 = new AtomicInteger(0);
    
}
```
Volatile **guarantees visibility**:
- When one thread changes d1, other threads see the latest value.
- It does **not** make compound operations atomic.

---

### AtomicInteger

AtomicInteger provides atomic operations:

`data.d2.getAndIncrement();` is thread-safe.

**Example**

```java
private static AtomicInteger threadcounter = new AtomicInteger();

public void run()
{
    System.out.println(threadcounter.incrementAndGet());
}
```

---

### Synchronized

**Synchronized Class object**

- Usually when protecting a static variable
- `synchronized(SomeClass.class)` > Lock the Class object shared by all instances.

**Synchronized Function**

```java
private static int threadcounter = 0;

public synchronized void run()
{
    threadcounter++;
    System.out.println(threadcounter);
}
```

Now each thread locks its own object though — not enough, because each thread has a different TestClass instance.

**Better Approach**

```java
public void run()
{
    synchronized(TestClass.class)
    {
        threadcounter++;
        System.out.println(threadcounter);
    }
}
```

Now all threads use the same lock.

---