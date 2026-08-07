package com.practice.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class T extends Thread {
    public static Lock lock = new ReentrantLock();

    public T(String name){
        super(name);
    }

    static StringBuilder data = new StringBuilder();

    public void run() {
        if(lock.tryLock()){
            try{
                lock.lock();
                data.append("hello");
            }finally{
                lock.unlock();
            }
        }
    }
}

public class ReentrantLockDemo {

    public static void main(String args[]) throws Exception {
        T t1 = new T("T1");
        t1.start();
        try{
            t1.lock.lock();
            System.out.println(t1.data);
        }finally{
            t1.lock.unlock();
        }
    }
}

// The run method acquires the lock twice, but releases it only once, so the hold count never returns to 0.

// The JVM may choose either main or T1 thread to run first.

// Scenario 1: T1 runs first
// main:
//    t1.start()
//
//T1:
//    tryLock()
//        succeeds
//        hold count = 1
//
//    lock.lock()
//        hold count = 2
//
//    data.append("hello")
//
//    unlock()
//        hold count = 1
// Then main runs: t1.lock.lock()
// So main blocks forever.
// Program hangs


// Scenario 2: main runs first
// main:
//    t1.start()
//
//main:
//    t1.lock.lock()
// tryLock() returns false