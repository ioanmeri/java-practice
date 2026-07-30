package com.practice.concurrent;

import java.util.concurrent.*;

public class Concurrent1 {
    public static void main(String[] args) {
        Runnable r = ()-> System.out.println("In Runnable");

        Callable<Integer> c = ()-> {
            System.out.println("In Callable");
            return 0;
        };

        var es = Executors.newCachedThreadPool();

        es.submit(c);
        es.submit(r);

        es.shutdown();

    }

}