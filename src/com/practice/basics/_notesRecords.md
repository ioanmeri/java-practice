## Notes Records

- Records **cannot** declare additional instance **fields**
    - The only instance fields allowed are the record components
- Records **can** declare **additional methods**
- A record **may** implement any number of **interfaces**
- **Automatically gets a canonical constructor** if you do not provide one.
- A record may have **at most one compact** and **one normal canonical constructor**.
- Any number of additional overloaded constructors (as long as they delegate using this(...))
- A record is **not** allowed explicitly define **instance fields**.
  - It can define **static fields** as well as **instance and static methods**
- A record is allowed to have at most one varargs field and if present, it should be at the end of the header.


---

### Records example

**Record with Interfaces**

```java
interface Printable {
    void print();
}

interface Identifiable {
    int id();
}

record Student(String name, int id) 
        implements Printable, Identifiable {

    public void print() {
        System.out.println(name);
    }
}
```

---