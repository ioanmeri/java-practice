## Interface Notes

### General Rules

- All interface **fields** are implicitly `public`, `static`, and `final`. 
  - Therefore, you cannot assign any value to an interface field outside the interface definition
  - Fields cannot be private.
- The **methods** are public


---

### Default Interface Method

**Belongs to the class**

When you mark a method in an interface as default, you are basically **providing 
a default implementation** of that method so that any class that implements 
this interface doesn't necessarily have to provide its own implementation
- You **cannot combine** `default` **and** `final` in an interface method.
  - A `default` method is an instance method **that can be overridden** by implementing classes.

---

### Static Interface Method

- A static method **belongs to the interface** itself.

---

### Private Interface Method
- A private interface method **must have a body**
  - This is because private methods in interfaces are never abstract.