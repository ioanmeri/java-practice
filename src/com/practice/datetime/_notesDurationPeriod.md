## Notes Duration Period

### Period
- Period is used to manipulate dates in terms of **days, months, and years**
- Period doesn't mess with the time component of the date

```java
LocalDateTime ld = LocalDateTime.of(2022, Month.OCTOBER, 31, 10, 0);

date = ZonedDateTime.of(ld, ZoneId.of("US/Eastern"));
date = date.plus(Period.ofDays(1));
System.out.println(date); //2022-11-01T10:00-05:00 (time didn't change)

```

---

### Duration

- Duration is used to manipulate dates in terms of **hours, minutes, and seconds**.
- Duration may change the time component if the date is close to the DST  boundary

```java
LocalDateTime ld = LocalDateTime.of(2022, Month.OCTOBER, 31, 10, 0);

ZonedDateTime date = ZonedDateTime.of(ld, ZoneId.of("US/Eastern"));
date = date.plus(Duration.ofDays(1));
System.out.println(date); // 2022-11-01T09:00-05:00 (Time changed because of DST)
```