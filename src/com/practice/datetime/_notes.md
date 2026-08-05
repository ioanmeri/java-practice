### Immutability

The key concept is that `LocalDate`, `LocalTime`, `LocalDateTime`, `Period`, and `Duration` from the `java.time` are **immutable**.

Methods like:

```
plusDays()
minusWeeks()
plusYears()
minusMonths()
plusWeeks()
```

do **not modify** the existing object. They create and return **new** `LocalDate` **objects**.

---