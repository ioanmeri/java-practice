## Instant

- An instance of `java.time.Instant` represents **time elapsed since Java epoch** (1970-01-01T00:00:00Z)
- `java.time.Instant` models a single instantaneous point on the time-line
- This might be used to record event time-stamps in the application
- The range of an instant requires the storage of a number larger than a **long**.
- the class stores a long representing epoch-seconds and an int representing nanosecond-of-second, 
  - which will always be between **0** and **999,999,999**

**Differences with LocalDateTime**

- `Instant.now()` will return the time as of UTC, while `LocalDateTime.now()` will return the time as per the time shown by the operating system clock, which depends on the time zone. 
- `java.time.LocalDateTime` **contains local time zone information** while `java.time.Instant` **does not**.

You need to remember that Instant doesn't represent date. It represents an instantaneous point on the time-line in nanoseconds and is used to record event time-stamps in the application.
You cannot create an instance of Instant using new Instance(). You create an instance using static methods Instant.now() or Instant.now(Clock ).

Instant.now() returns the current instant from the system clock (also known as machine time), which is always in UTC. UTC may not necessarily be same as the local time. For example, if the local time is ahead of UTC by two hours and if local time is 3 PM, then UTC time must be 1PM (3 - 2). Therefore, the Instant.now() will create an Instant representing 2022-01-20T13:00:00.001Z. (Assuming the date is Jan 20th 2022).