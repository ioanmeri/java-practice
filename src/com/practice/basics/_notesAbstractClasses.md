## Abstract Classes Notes


### General Notes

Here are some points to remember:

- A class is **uninstantiable if the class is declared abstract**.
- If a **method** has been declared as **abstract**, it **cannot provide an implementation** (i.e. it cannot have a method body ) and the class containing that method must be declared abstract).
- If a method is not declared abstract, it must provide a method body (the class can be abstract but not necessarily so).
- If any method in a class is declared abstract, then the whole class must be declared abstract.
- A class can still be made abstract even if it has no abstract method.

---

### Abstract Class Examples

```java

// XX It will not compile as one of its method is abstract 
// but the class itself is not abstract.
class Automobile{
   abstract void honk();  //(1)
}


// XX It will not compile as the method doesn't have 
// the body and also is not declared abstract.
abstract class Automobile{
   void honk();   //(2)
}


// Valid: This is a valid abstract class although 
// it doesn't have any abstract method
abstract class Automobile{
   void honk(){};   //(3)
}


// An abstract method cannot have a method body. 
// {} constitutes a valid method body.
abstract class Automobile{
   abstract void honk(){}   //(4)
}

// This is a valid abstract class
abstract class Automobile{
   abstract void honk();   //(5)
}
```

