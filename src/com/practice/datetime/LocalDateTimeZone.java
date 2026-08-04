package com.practice.datetime;

import java.time.*;

public class LocalDateTimeZone {

    public static void main(String[] args) {

        LocalDate ld = LocalDate.now().withMonth(6).withDayOfMonth(2); // June 2
        LocalTime lt = LocalTime.of(6, 0, 0); // 06:00
        LocalDateTime ldt = ld.atTime(lt); // June 2 06:00 - without any timezone

        // Fixed offset
        ZoneOffset nyOffset = ZoneOffset.ofHoursMinutes(-5, 0); // UTC-05:00

        // New York timezone - real timezone
        // Normal New York offset: UTC-5
        // DST adds +1 hour
        // Therefore in June: America/New_York = UTC-04:00
        ZoneId nyZone = ZoneId.of("America/New_York");

        OffsetDateTime nyOdt = ldt.atOffset(nyOffset); // 06:00 -05:00 => UTC 11:00

        ZonedDateTime nyZdt = ldt.atZone(nyZone); // June 2 06:00 -04:00 => UTC 10:00

        Duration d = Duration.between(nyOdt, nyZdt); // nyZdt - nyOdt
        // (end - start): 10:00 - 11:00 = -1 hour

        System.out.println(d);
        // PT-1H

    }
}


//Given :
//  1. The time zone of America/New York is normally 5 hours behind UTC.
//  2. Day light saving is ON during June in New York. (This means, clocks in New York are 1 hour ahead of the regular time that would have been shown when day light saving is OFF.)