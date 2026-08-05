## Consumer Notes


A Consumer<T> is a functional interface that consumes a value of type T:

```java
@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}
```
A Consumer takes in a value of type T and does something with it.

It does not return anything.

---

### What does `? super Integer` mean?

It means the list can hold Integer or any superclass of Integer, such as:
- Integer
- Number
- Object

This is used when you want to add integers to the list safely.

---

`List<? super Integer>`

When a generic structure is meant to consume values of type T—meaning you will
- add
- insert or
- write T

into it—you declare it with:

`? super T`

> Use `? super T` when the method needs to add `T` into the collection.
The collection is a consumer of `T`, so it must be declared with `? super T`.

---

### List CharSequence

```java
class Base{
    public List<? super CharSequence> getList(int id){
        return null;
    }
}
```

as meaning:

```java
List<CharSequence> // or
List<Object>
```

