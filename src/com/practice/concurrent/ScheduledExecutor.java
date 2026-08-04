package com.practice.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutor {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        scheduler.schedule(
                () -> System.out.println("Executed after 5 seconds"),
                5,
                TimeUnit.SECONDS
        );

        scheduler.shutdown();
    }
}

// scheduler.shutdown: The executor **does not accept any new tasks**.
