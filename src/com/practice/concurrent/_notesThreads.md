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

(Assume that r refers to a Runnable instance)

```
Thread t = Thread.ofVirtual().unstarted(r);
```

---

### BLOCKED

```java
public class TestClass {
    static class Calculation implements Runnable {
       int result;
       public void run() {
          synchronized(this){
              try{
                 Thread.sleep(5000); //LINE 10: TIMED_WAITING
                result = 101;
              }catch(Exception e){ e.printStackTrace(); }
           }
       }
    }
    
    public static void main(String args[]) throws Exception {
       Calculation c = new Calculation();
       Thread.Builder tb = Thread.ofPlatform();
       Thread t = tb.unstarted(c);
       t.start();
       Thread.sleep(100);
       synchronized(c){  //LINE 21: BLOCKED
           System.out.println("Result is "+c.result);
       }
    }
}
```


A thread that is waiting for a monitor to become free is in **BLOCKED** state. 

When the main thread tries to enter the `synchronized(c)` block, it too tries to acquire the same lock that the calculation thread has already acquired. 

Therefore, **the main thread will be put in the BLOCKED state**. 

It will remain in that state until the calculation thread releases the lock (by exiting the synchronized block).
