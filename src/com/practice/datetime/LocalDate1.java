package com.practice.datetime;

import java.time.LocalDate;
import static java.time.DayOfWeek.*;
public class LocalDate1 {
    public static void main(String[] args){
        var day = LocalDate.now().with(FRIDAY).getDayOfWeek();

        switch(day){
            case MONDAY:
                TUESDAY:
                WEDNESDAY:
                THURSDAY:
                FRIDAY:
                System.out.println("working");
            case     SATURDAY:
                SUNDAY:
                System.out.println("off");
        }

        System.out.println("finished");

    }
}