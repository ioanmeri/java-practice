## Rule: Checked Exceptions and Method Calls

**Example**

```java
//in file A.java
public class A{
   protected void m() throws SomeException{}
}

//in file B.java
public class B extends A{
   public void m(){ }
}

//in file TestClass.java
public class TestClass{
   public static void main(String[] args){
      //insert code here. //1
   }
}
```


The compiler checks the declared type of the reference variable, not the actual object type, when determining whether a checked exception must be handled.

Example:

```java
A a = new B();
a.m();   // Compile-time type = A

```


Even though `B.m()` does not `throw SomeException`, the compiler looks at `A.m()` because a is declared as type A:

```java
protected void m() throws SomeException
```


Therefore, **you must handle or declare SomeException**.

Exception to the Rule

If you cast the reference to a type whose method does not declare the exception:

```java
A a = new B();
((B)a).m();
```



**the compiler now looks at** `B.m()`:

```java
public void m() { }
```

Since `B.m()` does not throw any checked exceptions, no try-catch is required.

Exam Shortcut

✅ Method selection at runtime → actual object type (new B())

✅ Checked exception checking at compile time → reference/cast type (A or B)

Remember:

- Runtime polymorphism decides which method runs; 
- compile-time type decides which checked exceptions must be handled.

That's exactly why:

```java
A a = new B();
a.m();        // must handle SomeException
```
but

```java
A a = new B();
((B)a).m();   // no exception handling required

```

compiles successfully.