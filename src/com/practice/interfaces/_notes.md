## Interface Notes

### General Inteface Rules

- All interface **fields** are implicitly `public`, `static`, and `final`. 
  - Therefore, you cannot assign any value to an interface field outside the interface definition
  - Fields cannot be private.
- The **methods** are public
- Only methods of an interface can be private. **private/protected fields are not allowed**.
- Public fields must be given a value explicitly.
- `@Override` annotation on a method must override another existing method


---

### Default Interface Method

**!! -- Belongs to the class -- !!**

When you mark a method in an interface as default, you are basically **providing 
a default implementation** of that method so that any class that implements 
this interface doesn't necessarily have to provide its own implementation
- You **cannot combine** `default` **and** `final` in an interface method.
  - A `default` method is an instance method **that can be overridden** by implementing classes.
- Default method in an interface belongs to the implementing object, not to the interface itself
- An interface **can** redeclare a **default method** and also make it **abstract**
  - When extends another interface which has a default method
  - OK: default -> `String getId()`
- A **default method cannot be overridden by a static** method

---

### Static Interface Method

**!! -- belongs to the interface -- !!**

- A static method **belongs to the interface** itself.
- Valid only if not conflicting with inherited instance method
- But, you **cannot override a non-static** method **with a static method** and vice versa.
  - e.g. Not Allowed: default -> static
- You can **redeclare a static method** of a super interface **as a default method** in the sub interface

---

### Private Interface Method
- A private interface method **must have a body**
  - This is because private methods in interfaces are never abstract.
- You still cannot override a public method with a private method

---