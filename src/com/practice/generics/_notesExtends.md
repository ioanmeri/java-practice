## Notes Extends

### Extends keyword

```List<? extends Number>``` means:
- A List containing **some unknown type** that is 
  - Number or 
  - a subclass of Number.

Valid examples:

```java
List<Integer>
List<Double>
List<Float>
List<Number>
```

**Example**

```java
class A{
  public List<? extends Number> getList(){
      //valid code
  };
}
class B extends A{
  @Override
  *INSERT CODE HERE*
      //valid code
  };
}
```

Option 1:
```java
public List<? extends Integer> getList()
```

--- 
Option 2:

```java
public ArrayList<? extends Number> getList()
```

because ```ArrayList<E> extends List<E>```

---

Option 3:

```java
public ArrayList<? extends Integer> getList()
```

```
ArrayList<? extends Integer>
          |
          v
ArrayList<? extends Number>
          |
          v
List<? extends Number>

```

---

Option 4:

```java
public ArrayList<Number> getList()
```

- `ArrayList<Number>` is a subtype of:
  - `List<Number>` which matches
    - `List<? extends Number>` 

---

Option 5:

```java
public ArrayList<Integer> getList()
```

---