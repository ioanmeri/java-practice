package com.practice.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class LocalDateTime1 {
    public static void main(String[] args) {
        LocalDate ld = LocalDate.parse("2024-06-01");
        LocalDateTime ldt1 = ld.atTime(LocalTime.of(10, 10));
        LocalDateTime ldt2 = ldt1.plus(Period.ofDays(-1)).withHour(23);
        System.out.println("""
            ld: %s
            ldt1: %s
            ldt2: %s
            ldt1.isAfter(ldt2): %s
            """.formatted(
                    ld,
                    ldt1,
                    ldt2,
                    ldt1.isAfter(ldt2)
        ));
        if(ldt1.isAfter(ldt2) &! ldt1.getMonth().equals(ldt2.getMonth())){
            System.out.println("In if");
            System.out.println(ldt1.format(DateTimeFormatter.ofPattern("HHMM")));
        }else{
            System.out.println("In else");
            System.out.println(ldt2.format(DateTimeFormatter.ofPattern("HHMM")));
        }

        // Printed: 1006
    }
}
