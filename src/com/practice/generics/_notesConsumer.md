## Consumer Notes


A Consumer<T> is a functional interface that consumes a value of type T:

```java
@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}
```
A Consumer takes in a value of type `T` and does something with it.

It does not return anything.

### Consumer Examples

```java
Consumer<String> x = (String msg)->{ System.out.println(msg); };

Consumer x = (msg)->{ System.out.println(msg); };// msg's type will be inferred as Object

Consumer x = (m)->{ };

Consumer x = System.out::println

Consumer x = (String msg)->{ System.out.println(msg); };
// Not valid: Since Consumer is not typed to String, the type of msg must be Object.
```


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

---

### Example


```java
class Booby{
}
class Dooby extends Booby{
}
class Tooby extends Dooby{
}

var bL = new ArrayList<Booby>();
var tL = new ArrayList<Tooby>();

List<? extends Booby> bV = //code for initialization
List<? super Dooby> dV = //code for initialization
```

**Valid declarations**

```java
dV.add(new Dooby(){ });

bV = bL;

dV = bL;

bV = tL;
```

`List<? extends Booby>` bV implies that bV must point to a List of Booby or some subtype of Booby. But the exact subtype is not known. Thus, it could be a List of Booby, Tooby, or some other class that extends Booby. Since we don't know exactly which subtype objects this list is supposed to contain, we can't add any object (except null) to this list. For example, if the list is supposed to contain objects of type Tooby, adding an object of type Dooby would corrupt the list. On the other hand, we know that it is-a Booby, and so we can take out any object from it and assign it to variable of type Booby. In other words, whoever uses the variable bV expects to retrieve Booby objects (i.e. Booby or its subclass objects) from the list. Thus, bV must point to a List that satisfies this condition. bL and tL both satisfy this condition and therefore, both can be assigned to bV.


`List<? super Dooby>` dV implies that dV must point to a List of some super class of Dooby. It could be a List of Dooby, Booby, or Object. Although we don't know which class that is, we can always add a Dooby or its subclass object to this List because that object will satisfy the is-a relation with Dooby, Booby, Object, or whatever superclass of Dooby this list is composed of. On the other hand, if we take any object out of this list, we won't know the type of this object with enough certainty to be able to assign it to a variable of type other than Object. Thus, whoever uses the variable dV, expects that they be able to add any Dooby (i.e. Dooby or its subclass) object to the list pointed to by dV. This is possible with a list of type Booby because you can add any Dooby object to a list of Booby, but not with a list of type Tooby because Tooby is just one subclass of Dooby, there could be other subclasses of Dooby that have no relation to Tooby.
Therefore, only bL can be assigned to dV.

