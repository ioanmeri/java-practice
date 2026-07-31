## Notes Classes

### Constructors

- Constructors should not specify a return value
- The class has an implicit default constructor (auto-generated) if the class contains no constructor declarations.
- Parent constructors always execute before child constructors.

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