## Notes Pattern Matching

1. Redeclaring variables

```java
A a = null;
if(base instanceof A a ){
 System.out.println(a.power());
}
```

The code as written actually **does not compile**, 
because you **cannot declare a pattern variable with 
the same name as a local variable** that is already 
in scope

---

2. Instance of
   
```java
class A {}
class B extends A {}
class C extends B {}
class D extends C {}

D d = new D();

the expression (d instanceof A) will return true.
```

An object is an instance of its own class and every superclass in its inheritance hierarchy.

---
