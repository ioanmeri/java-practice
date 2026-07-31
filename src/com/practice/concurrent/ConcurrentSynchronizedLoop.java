package com.practice.concurrent;

public class ConcurrentSynchronizedLoop extends Thread {
    private static int threadcounter = 0;

    public void run() {
        threadcounter++;
        System.out.println(threadcounter);
    }

    public static void main(String[] args) throws Exception {
        for(int i=0; i<10; i++) {
            synchronized(ConcurrentSynchronizedLoop.class) {
                // It creates and starts a thread.
                // The new thread later calls: run()
                new ConcurrentSynchronizedLoop().start();
            }
        }
    }
}

// synchronized(TestClass.class) locks the Class object.
// There is only one: TestClass.class object in the JVM.
// So only one thread can enter that block at a time.

// The synchronization protects only the creation/start operation:
// It does NOT protect: threadcounter++; inside run().

// **TimeLine**
//main thread:
//lock TestClass.class
//create Thread-1
//start Thread-1
//unlock
//
//lock TestClass.class
//create Thread-2
//start Thread-2
//unlock
//
//...
//
//Thread-1 starts running run()
//Thread-2 starts running run()