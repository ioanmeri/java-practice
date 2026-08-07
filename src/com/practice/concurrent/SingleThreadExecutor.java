package com.practice.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyCallable implements Callable<String> {
    public String call() throws Exception {
        Thread.sleep(5000);
        return "DONE";
    }
}

public class SingleThreadExecutor {

    public static void main(String[] args) throws Exception {
        ExecutorService es =  Executors.newSingleThreadExecutor(); // one worker thread.
        Future<String> future = es.submit(new MyCallable());
        System.out.println(future.get()); //1
        es.shutdownNow(); //2
    }
}

// submit() starts the task asynchronously

// Future.get():
// - Blocks until the task completes.
// - It does not throw an exception just because the task takes a long time.
// - So the main thread waits about 5 seconds.

// If you don't want to block the code, you may use Future's isDone(), which returns a boolean without blocking
