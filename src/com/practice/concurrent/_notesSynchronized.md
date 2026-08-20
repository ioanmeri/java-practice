## Notes Synchronized

### Synchronized General Notes

- When a synchronized method **ends with a checked exception**, the intrinsic **lock held by the thread is released** automatically
  - The intrinsic lock **is released when the method ends**. Irrespective of how it ends.
- A **deadlock** might occur when multiple threads try to **acquire locks on multiple objects in different sequence**
- A deadlock **can be avoided** if the second thread acquire the **locks in the same order** as the first thread
    - This is a standard technique to prevent a deadlock when multiple thread need to acquire multiple locks.
- An **intrinsic lock is never shared**. Once a thread acquires an intrinsic lock, **it owns the lock exclusively** until it releases the lock.

---

### Synchronized Class object

- Usually when protecting a static variable
- `synchronized(SomeClass.class)` > Lock the Class object shared by all instances.


**Example Function**

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

### Nested Synchronized

Nested `synchronized` blocks simply mean **a thread is acquiring more than one
lock** at the same time, in a specific order.

```java
static StringBuffer sb1 = new StringBuffer();
static StringBuffer sb2 = new StringBuffer();
```


```java
synchronized(sb1) {
    sb1.append("X");
    synchronized(sb2) {
        sb2.append("Y");
    }
}
```

The thread first acquires the lock on **sb1**, and while still holding that lock, 
it tries to acquire the lock on **sb2**. 

Only after both locks are acquired does
it execute the inner code. When the inner block finishes, it releases sb2, 
and when the outer block finishes, it releases sb1.

---

### Why do nested synchronized blocks exist?

They’re used when:

- You need **atomic access to multiple shared resources**.
- You want to **enforce a strict lock ordering** to avoid race conditions.
- You want to **prevent other threads from modifying either object** while you work with both.

---

### The danger of Nested synchronized blocks: Deadlock

Nested synchronized blocks are safe **only if 
all threads acquire locks in the same order**.

If one thread does:

```java
synchronized(sb1) {
    synchronized(sb2) { ... }
}
```

and another thread does:

```java
synchronized(sb2) {
    synchronized(sb1) { ... }
}

```

you have a classic deadlock scenario:
- Thread A holds **sb1** and waits for **sb2**
- Thread B holds **sb2** and waits for **sb1**
- Neither can proceed