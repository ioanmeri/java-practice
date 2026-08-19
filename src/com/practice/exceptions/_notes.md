## Exceptions

- A `catch` block catches the specified type and **all of its subclasses**.
  - `E2 extends E1` with `catch(E1 e){` with catch `throw new E2();`
- Exceptions specified in a **multi-catch block** must **not** have **a parent-child (or ancestor/successor) relationship**.


---

## Method Overriding

An overriding method cannot throw an exception that is a super class of the exception thrown by the overridden method
- **Child can narrow**, but cannot broaden checked exceptions.
- And **unchecked exceptions are always allowed** in an overriding method.


```java
class Great {
    public void doStuff() throws IOException {
    }    
}

class Amazing extends Great {
  public void doStuff() throws FileNotFoundException, IllegalArgumentException{
  }    
}
```

---


