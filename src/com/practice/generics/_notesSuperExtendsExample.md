## Notes Super Extends

Given:

```java
class Booby{
}
class Dooby extends Booby{
}
class Tooby extends Dooby{
}
```

and the following declarations:

```java
List<? super Booby> bV = null;
List<? extends Tooby> tV = null;
```

---

### `List<? super Booby>`

- `List<? super Booby>` bV implies that bV must point to a **List of some super class** of Booby.
  - It could be a List of `Booby`, or `Object`
- **We can always add** a **Booby !!or its subclass!!** object to this List 
  - That object **will satisfy the is-a relation** with Booby, Object
- if we take any object out of this list, we won't know the type of this object with enough certainty 
  - To be able to **assign** it to a variable of type **other than Object**. 
- Whoever uses the variable **bV**, expects that they be able to **add any Booby object** to the list pointed to by bV.

---

### `List<? extends Tooby>`


- `List<? extends Tooby>` tV implies that tV must point to a List of objects that **satisfies the is-a relation with Tooby**. 
- Thus, it could be a **List of Tooby**, or some other **class that extends Tooby**. 
- Since we don't know which class that is, **we cannot add any object to this list**. 
- However, we know that **whatever object we take out** from this list, **"is-a" Tooby**, and so we can take out any object from it and assign it to variable of type Tooby. 
- In other words, whoever uses the variable **tV** expects to **retrieve Tooby objects (i.e. Tooby or its subclass objects)** from the list. 
- Thus, tV must point to a List that satisfies this condition.

---