## Notes Classes

### Constructors

- Constructors have **no return type** (not even `void`)
- May have any access modifier (`public`, `protected`, package-private, `private`)
  - No modifier means default access (only classes in package can use it) 
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
- If a subclass constructor does not explicitly call `super(...)`, Java automatically inserts it
  - and if a superclass has a constructor, Java does not create **no no-argument constructor**
  - **super** from the **subclass** without arguments **fails**
- A **private** constructor is **not accessible from the subclass**.
- An overriding method **cannot reduce the visibility** of the inherited method.
- You cannot assign an `X` object to an `int`
  - `int k = (X) y.val; // illegal`

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

### Overridding

- Dynamic dispatch only applies to **overridden** methods, **not overloaded methods**.

---

### Virtual Calls

A virtual call means that the call is bound to a method at run time and not at compile time.

In Java, all non-private and non-final instance method calls are virtual. This is important because, at run time, a reference variable may point to an instance of a subclass of the class of the reference.  The compiler doesn't have the knowledge of the class of the actual object being referred to by the reference variable. If the subclass overrides the method, the call becomes polymorphic because now there are two versions of the method that can be invoked (the base class version and the subclass version). Therefore, the compiler is unable to bind the call to the method of a specific class. Only the JVM has the necessary information to bind the call.  The JVM knows the class of the actual object and it binds the call to the method of that class. This behavior is called polymorphism.
- Thus, in Java, all non-private and non-final instance method calls are potentially polymorphic because there could be multiple versions of the method eligible to be invoked.

---

### Reference type and compiler

When a method is defined only in the subclass, 
calling that method using a reference whose type is the superclass 
will not compile, even if the object is actually an instance of the subclass.

```java
class Animal {
}

class Dog extends Animal {
    void bark() {
    }
}

Animal a = new Dog();
a.bark();       // ❌ Does not compile
```

---

### Initialization Order — Exam Theory

When a class is initialized and an object is created, Java follows this order:

1. **Static fields and static initializer blocks** are executed **once**, in the exact order they appear in the class.
2. **Instance fields and instance initializer blocks** are executed **for each new object**, in the exact order they appear in the class.
3. **The constructor** is executed last.

### Example

```java
static String s1 = sM1("a");  // 1️⃣
static { s1 = sM1("b"); }     // 2️⃣
static String s2 = sM1("c");  // 3️⃣

String s3 = sM1("2");         // 4️⃣
{ s1 = sM1("3"); }            // 5️⃣
String s4 = sM1("4");         // 6️⃣

public InitTest() {
    s1 = sM1("1");            // 7️⃣
}
```

Therefore the output is:

```text
a
b
c
2
3
4
1
```

### ⭐ Rule to memorize for the exam

> **Static initialization → Instance initialization → Constructor**

And within each category:

> **Execute in textual order (top to bottom).**

So:

```text
static fields/blocks
        ↓
instance fields/blocks
        ↓
constructor
```

**Important:** Static initialization happens **once per class**, while instance initialization and the constructor happen **every time an object is created**.

---