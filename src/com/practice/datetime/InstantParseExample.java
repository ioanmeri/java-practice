package com.practice.datetime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class InstantParseExample {

    public static void main(String[] args) {
        // Instant is a point on Java time line
        Instant start = Instant.parse("2022-06-25T16:13:30.00z");
        start.plus(10, ChronoUnit.HOURS);
        System.out.println(start); // 2022-06-25T16:13:30Z

        Duration timeToCook = Duration.ofHours(1);
        Instant readyTime = start.plus(timeToCook);
        System.out.println(readyTime); // 2022-06-25T17:13:30Z

        LocalDateTime ltd = LocalDateTime.ofInstant(readyTime, ZoneId.of("GMT+2"));
        System.out.println(ltd); // 2022-06-25T19:13:30
    }

}

// 1. The first println prints the same Instant because Instant is immutable.
// Calling plus on an Instant doesn't change it but returns a new Instant.
// 2. Adding 1 hour to 16:13, will change it to 17:13, which is what the second println prints.
// 3. A Timezone of GMT+2 means that in that time zone, the time is 2 hours ahead of GMT.
// Thus, when it is 17:13 in GMT, it is 19:13 in GMT+2.