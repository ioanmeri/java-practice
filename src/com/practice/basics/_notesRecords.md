## Notes Records

**Properties**

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


**Additional**

- A sealed class cannot permit a record because record cannot extend any class
- A record cannot extend any class explicitly. It cannot even have an extends clause.
- A record cannot explicitly define instance fields.
  - `private String name = "unknown"; // Not Valid`
- A record may have final and non-final static fields.
  - `public static final long serialVersionUID  = 1L; // Valid`

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

### Records Constructors


1. Calling Canonical constructor from a non canonical

If you write a non-canonical constructor in a record explicitly then, **on the first line** of such a constructor, 
you must **provide a call to either the canonical constructor or another 
constructor**. For example:

```java
public record Student(int id, String name){
    public Student(){ //a non-canonical constructor
        this(10); //this line or a call to the canonical constructor is required 
    }
    public Student(int id){ //another non-canonical constructor
        this(id, ""); //this line is required 
    }
    public Student(int id, String name){ //regular form canonical constructor
        this.id = id; this.name=name;
    }
}
```

2. Provide the canonical constructor in a "compact form"

```java
public record Student(int id, String name){
    public Student{ //no parameter list is specified here
	   if(id <0) throw new IllegalArgumentException();
	}
}
```

---