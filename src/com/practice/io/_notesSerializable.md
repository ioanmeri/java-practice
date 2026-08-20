## Notes Serializable

- When an object is **deserialized**, **only the Serializable class’s constructor is skipped**.
    - Constructors of **non‑serializable superclasses ARE executed**.
- **No-args constructor is required** in the most specific class in the class hierarchy **that doesn't implement Serializable**. 
  - It will throw an `InvalidClassException`.
- `Static` **fields are not serialized** 
- `transient` **fields are not serialized**
- It is **not necessary** for a class to implement `readObject` and `writeObject` methods. 
  - It may implement **neither**, **either**, **or both** the methods depending on what aspect of serialization it wants to customize.
  - But note that, if provided, the `readObject` and `writeObject` methods **must be private**.
- The `readObject` method will be **invoked during the deserialization** of a Data object.

---

### Example: Deserializing without no-arg constructor

What will be a part of the output when the following code is compiled and run?

```java
class Boo {
    int boo = 10;
    public Boo(int k){ System.out.println("In Boo k = "+k); boo = k;}
}

class BooBoo extends Boo {
     public BooBoo(int k ){ super(k); System.out.println("In BooBoo k = "+k); }
}
    
class Moo extends BooBoo implements Serializable {
    int moo = 10;
    public Moo(){ super(5); System.out.println("In Moo"); }
}
    
public class TestClass {
    
    public static void main(String[] args) throws Exception{
    
        var moo = new Moo();
        var fos = new FileOutputStream("c:\\temp\\moo1.ser");
        var os = new ObjectOutputStream(fos);
        os.writeObject(moo);
        os.close();
        var fis = new FileInputStream("c:\\temp\\moo1.ser");
        var is = new ObjectInputStream(fis);
        moo = (Moo) is.readObject();
        is.close();    
      }
}
```
```
In Boo k = 5
In BooBoo k = 5
In Moo
```
and

**It will throw an exception at runtime**

while deserializing, the JVM **will not find any no-arg constructor** that can be invoked to initialize BooBoo. 
- No-args constructor is required in BooBoo because **BooBoo is the most specific class** in the class hierarchy **that doesn't implement Serializable**. 
- So it will throw an `InvalidClassException`.

---
