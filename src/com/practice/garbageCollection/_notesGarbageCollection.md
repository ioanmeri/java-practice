## Notes Garbage Collection

### Method making object null

When you see:

```java
void method(M pM) {
    pM = null;
}
```

this does **NOT** change the caller's reference.

For example:

```java
M m = new M();

makeItNull(m);

System.out.println(m); // still points to M object
```

Because

```
Before:
m  ─────→ M

call:
m  ─────→ M
pM ─────→ M

pM = null:

m  ─────→ M
pM       null
```

**What would actually make the M eligible?**

```
public void makeThisNull(){
    m = null;
}
```

---

### Reachable reference

Don't think:

"I set `n1 = null`, therefore Node1 is garbage."

Instead ask:

"Is there ANY reachable reference to Node1?"

Maybe 

```
n2.next ─────→ Node1
```

so Node1 is still alive.

This is especially important with linked structures, because **one object can remain 
reachable through another object's field even after the original reference is set to** `null`

---

### Static variables in GC

Whenever you see:

```
static Something x;
```

remember:

`x` belongs to the class, not to an instance.

Garbage-collecting an object does **not** automatically clear the class's static fields.

So

```
N n = new N();
n = null;
System.gc();
```

can make the `N` and its `M` instance eligible for GC, but:

```
M.obj
```
is still reachable

---

