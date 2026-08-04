## Notes Classes

### Constructors

- Constructors have **no return type** (not even `void`)
- May have any access modifier (`public`, `protected`, package-private, `private`)
- must have a body
- The class has an **implicit default constructor (auto-generated)** **if the class contains no constructor declarations**.
- Parent constructors always execute before child constructors.
- Protected constructor means
  - It can be called from subclasses - even in different packages
  - It can be called from classes in the same package
- `public PortConnector(int port) throws IOException`
  - This means **any subclass constructor** must declare
    - **the same exception**: `throws IOException` **or**
    - **a subclass**: `throws a subclass of IOException` **or**
    - **no exception**: no `throws` clause _only if_ it handles the exception internally (i.e., wraps it).

---

### Covariant Return Types

**Does not compile: Primitive types do not have covariance**

```java
class A {
    public int getCode(){ return 2;}
}

class AA extends A { 
  public long getCode(){ return 3;}
}
```

**When overriding a method**, the return type must be:

1. Exactly the same, or 
2. A subtype of the original return type (covariant return)

**Valid Syntax**

```java
class A {
    public Number getCode() {
        return 2;
    }
}

class AA extends A {
    public Integer getCode() {
        return 3;
    }
}
```

---

### Inner Classes

- Inner classes automatically have access to all members of the outer class, including private fields
  - To access the outer class's field, you must qualify it `OuterClass.this.a`
- `this` refers to the current `Inner` object.
  - `this.a` is equivalent to: `Inner.this.a`

---

### Encapsulation

Encapsulation generally means:

- Make fields `private`
- Expose behavior through methods
- Keep related state consistent inside the class

---

### Overloading

- Overloading of a method occurs when 
  - the **name** of more than one methods **is exactly same** but 
  - the **parameter lists are different**
- You cannot have two methods with the same signature (i.e. same name and same parameter list) in the same class.

---