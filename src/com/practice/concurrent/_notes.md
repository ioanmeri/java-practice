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