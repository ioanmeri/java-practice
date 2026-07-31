## Interface Notes

### General Rules

- As a rule, **fields** defined in an interface are **public, static, and final**. 
  - Therefore, you cannot assign any value to an interface field outside the interface definition
- The methods are public.

---

### Default Interface Method

**Belongs to the class**

When you mark a method in an interface as default, you are basically **providing 
a default implementation** of that method so that any class that implements 
this interface doesn't necessarily have to provide its own implementation

---

### Static Interface Method

**A static method belongs to the interface itself.**

---