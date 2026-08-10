```java
class Base{
  public List<CharSequence> transform(Set<CharSequence> list){
      //valid code
  };
}

class Derived extends Base{
  *INSERT CODE HERE*
      //valid code
   }
}
```
**Valid Declarations**

```java
public ArrayList<CharSequence> transform(Set<CharSequence> list){
```


```java
// Observe the method parameter. It is not an override but an overload.
public List<Integer> transform(TreeSet<CharSequence> id){
```


Here are a few points that you need to understand.

1.
Observe that there is no @Override annotation on the method in the Derived class. Thus, you have to watch out for not just valid override but also valid overload.

2.
### Type erasure of generic method parameters
Remember that unlike arrays, generic collections are not reified, which means that all generic information is removed from the compiled class. Thus, Set<CharSequence> and Set<String> are converted to just Set by the compiler while generating the class file. This implies that two methods whose parameter types differ only on the type specification are not really different methods.
For example,
void m(Set<CharSequence> cs), void m(Set<String> s), and void m(Set<SomeOtherClass> o) are not different method signatures at all. If you remove the type specification, they all resolve to the same signature i.e. void m(Set x).

Hence, if you put them in the same class, the resulting class file will have two methods with the exact same signature. This is obviously a problem and so, the compiler rejects the code. If you put one of them in a superclass and another in a subclass, then from the compiler's perspective they constitute valid overloading, however, from the JVM's perspective it is an override and the JVM will not respect the compile time method binding done by the compiler based on the generic type specification. That is why Java does not allow this either.

The exception to this rule is that the overriding method is allowed to erase the generic type specification. For example, if the overridden method has Set<Integer>, then the overriding method can use Set or Set<Integer>. But if overridden method has Set, then the overriding method must also have Set for a valid override.

3.

### Rule of Covariant Returns
An overriding method (i.e. a sub class's method) is allowed to return a sub-type of the type returned by the overridden method (i.e. super class's method).

So, first check whether the return type of the overriding method is a subtype. For example, if the overridden method returns List, the overriding method can return ArrayList but not Object.

Next, you need to check the type specification of generic types. This is a bit complicated. To determine this, you must remember the following hierarchy of subtypes. Assuming that S is a sub type of T and <<< means "is a subtype of", here are the two hierarchies:

Hierarchy 1 : `A<S> <<< A<? extends S> <<< A<? extends T>`
Example: Since Integer is a subtype of Number, List<Integer> is a subtype of List<? extends Integer> and List<? extends Integer> is a subtype of List<? extends Number>.
Thus, if an overridden method returns List<? extends Integer>, the overriding method can return List<Integer> but not List<Number> or List<? extends Number>.


Hierarchy 2 : `A<T> <<< A<? super T> <<< A<? super S>`
Example: List<Number> is a subtype of List<? super Number> and List<? super Number> is a subtype of List<? super Integer>
Thus, if an overridden method returns List<? super Number>, the overriding method can return List<Number> but not List<Integer> or List<? super Integer>.


It is important to understand that List<Integer> is not a subtype of List<Number> even though Integer is a subtype of Number.

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

### Base Extends

```java
class Base{
   public <T extends CharSequence> Collection<String> transform(Collection<T> list)
   {
      return new ArrayList<String>();
   }
    
}
```

**Correct overload**

```java
public <T extends CharSequence> Collection<T> transform(List<T> list) {
         return new HashSet<T>(); }; //4
```

---

### Superclass

```java
class Base {
    public ArrayList transform(Set list) {
        // valid code
    }
}
```

So an overriding method in Derived must return either:
- exactly `ArrayList`
- a subtype of `ArrayList`

```java
public ArrayList transform(Set list)
```