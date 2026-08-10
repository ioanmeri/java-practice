## Notes Conditions

### If Statements

- Java associates an `else` with the **nearest unmatched** `if`

**Example dangling `else`**

```java
public class Test{
   public static void main(String[] args){
      if (args[0].equals("open"))
         if (args[1].equals("someone"))
            System.out.println("Hello!");
      else System.out.println("Go away "+ args[1]);
    }
}
```

```java
if (args[0].equals("open")) {
    if (args[1].equals("someone")) {
        System.out.println("Hello!");
    } else {
        System.out.println("Go away " + args[1]);
    }
}
```

---

### Switch

Java switch supports only:
- byte
- short
- char
- int
- their wrappers (Byte, Short, Character, Integer)
- String
- enum

**Properties**
- A `default` clause is **not required**.

---

### Switch expression

```java
int result = switch(c) {
    case 'a' -> 1;
    case 'b' -> 2;
    default -> 0;
};
```
the switch must be **exhaustive**
- You need `default -> something`
- or cover every possible value.
- `case null, default -> "invalid input";` is valid
- Use `default` when other object types must be handled.
- You need an unguarded `default` (or an unguarded `case Integer i`) to make the switch exhaustive
- The default case is an **unconditional match**, so the later cases are considered dominated by it
  - must be the last one

---
