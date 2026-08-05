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

---
