## Concurrent Types

### Executor

Executor interface **executes a Runnable**. But the return type of Runnable's `run()` is **void**
- it cannot return anything.

```
Executor executor = ...;

executor.execute(() -> {
    System.out.println("Hello");
});
```

---

### ExecutorService

`ExecutorService extends Executor` and provides a `submit(Callable)` method
- `<T> Future<T>  submit(Callable<T> task)`

Submits a value-returning task for execution and **returns a Future** representing the pending results of the task

```java
ExecutorService service = Executors.newSingleThreadExecutor();
```

It provides:
```
submit(Runnable)
submit(Callable<T>)
```

---

### Executors

`java.util.concurrent.Executors` is a utility class that contains factory methods to create various kinds of `ExecutorService` implementations.

```java
ExecutorService service = Executors.newFixedThreadPool(3);
```

```java
Executors.newSingleThreadExecutor()
Executors.newFixedThreadPool(3)
Executors.newCachedThreadPool()
Executors.newScheduledThreadPool(3)
```

```
Executors
    ↓ creates
ExecutorService
    ↓ submits
Callable
    ↓ produces
Future
```

---

### Runnable

---

### Callable

The difference between Callable and Runnable is that Callable's call() returns a value. 

It may also throw an `Exception` while Runnable's run() cannot return any value and cannot throw any Exception.

---

### Future

When you submit a task (i.e. a Callable) to an ExecutorService using ExecutorService's submit(Callable ) method, it returns a Future object immediately without blocking.

You can check the status of the Future object later to get the actual result once it is done.

```java
Callable<Integer> task = () -> {
    Thread.sleep(2000);
    return 42;
};
```

You submit it:

```java
Future<Integer> future = service.submit(task);
```

---

