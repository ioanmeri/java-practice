## Format Notes

### Common date/time formatting symbols (Java java.time)

| Pattern | Meaning          | Example  |
| ------- | ---------------- | -------- |
| `y`     | year             | `2026`   |
| `yy`    | 2-digit year     | `26`     |
| `yyyy`  | 4-digit year     | `2026`   |
| `M`     | month number     | `7`      |
| `MM`    | 2-digit month    | `07`     |
| `MMM`   | short month name | `Jul`    |
| `MMMM`  | full month name  | `July`   |
| `d`     | day of month     | `31`     |
| `dd`    | 2-digit day      | `31`     |
| `E`     | day name short   | `Fri`    |
| `EEEE`  | full day name    | `Friday` |

---

### Time Fields

| Pattern | Meaning            | Example |
| ------- | ------------------ | ------- |
| `H`     | hour (0-23)        | `14`    |
| `HH`    | hour padded        | `14`    |
| `h`     | hour (1-12)        | `2`     |
| `hh`    | padded 12-hour     | `02`    |
| `m`     | minute             | `5`     |
| `mm`    | padded minute      | `05`    |
| `s`     | second             | `42`    |
| `ss`    | padded second      | `42`    |
| `S`     | fraction of second | `1`     |
| `SSS`   | milliseconds       | `123`   |
| `a`     | AM/PM              | `PM`    |

---

### Time Zone

| Pattern | Meaning    | Example  |
| ------- | ---------- | -------- |
| `z`     | zone name  | `UTC`    |
| `Z`     | offset     | `+0000`  |
| `XXX`   | ISO offset | `+00:00` |

---

### Example

```java
ZonedDateTime zdt = ZonedDateTime.now();

System.out.println(zdt.format(
    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss XXX")
));
```

`2026-07-31 14:35:42 +03:00`

---