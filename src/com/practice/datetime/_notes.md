### Local General

- `Locale.setDefault(...)` changes the **JVM-wide default locale**.
  - This affects APIs like:
    - `NumberFormat.getCurrencyInstance();`
    - `DateFormat.getDateInstance();`
    - because they use the **default locale** if you don't specify one.
- `NumberFormat.getCurrencyInstance()` looks up that default locale at the moment you call it.

---

### ResourceBundle

But then you call

```java
ResourceBundle rb =
ResourceBundle.getBundle("msgs", Locale.of("fr"));
```

you explicitly requested:

```
fr
```

When you specify a locale, Java starts with **that locale**, not the default locale.

So it searches

```
msgs_fr.properties
↓
msgs.properties
```

---

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