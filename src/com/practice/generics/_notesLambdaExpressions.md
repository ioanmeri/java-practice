## Lambda Expressions

###  Lambda expression must be final or effectively final

```java
public class TestClass{
    public static void main(String[] args) {
        int value = 0;
        Supplier<Integer> valueS = ()->value++; //1
        value++;//2
        System.out.println(value+" "+valueS.get()); //3
    }
}
```

**Compilation Error**

- Remember that local variables referenced from a lambda expression must be final or effectively final. 
- Here, the value variable is not defined as final and its value is being changed at //1 and //2, 
- Therefore, it is not effectively final either.

Hence, you cannot use this variable inside a lambda expression.

**Another Example**

A local variable needs to be final or effectively final to be accessed from an inner class or lambda expression.

```java
class TestClass{
   public double process(double payment, int rate)
   {
      double defaultrate = 0.10;        //1
      if(rate>10) defaultrate = rate;  //2 Must be removed so defaultrate is effectively final
      class Implement{
         public int apply(double data){
             Function<Integer, Integer> f = x->x+(int)(x*defaultrate);  //3 or change defaultrate -> rate
             return f.apply((int)data); //4
         }
      }
      Implement i = new Implement();
      return i.apply(payment);
   }
}
```

---

### Local variable names

You cannot reuse the local variable names that have already been used in the 
enclosing method to declare the variables in you lambda expression.


**Compilation Error //3**

```java
public static void main(String[] args) {
   Employee e = new Employee(); //2
   System.out.println(validateEmployee(e, e->e.age<10000)); //3
}
```

This will work

```java
System.out.println(validateEmployee(e, x->x.age<10000));
```

---



