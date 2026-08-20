## Notes TreeSet


### TreeSet Subset
TreeSet is a NavigableSet and so, it supports `subSet()` method :

`NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive)`
Returns a view of the portion of this set whose elements range from fromElement to toElement.

The returned subset is backed by the original set. So if you insert or remove an element from the subset, the same will be reflected on the original set.

**Example**

```java
public class TestClass {

    public static void main(String[] args) {

        TreeSet<Integer> s = new TreeSet<Integer>();
        TreeSet<Integer> subs = new TreeSet<Integer>();

        for(int i = 324; i<=328; i++)
        {
            s.add(i);
        }
        subs = (TreeSet) s.subSet(326, true, 328, true );
        subs.add(329);
        System.out.println(s+" "+subs);
        
    }

}
```

The subset's valid range is:
- `326 <= element <= 328`

The Java NavigableSet.subSet(fromInclusive, toInclusive) specification requires that **attempts to insert an element outside the subset range throw an exception**.

Further, since the subset is created using a range (fromElement to toElement), the element that you are inserting must fall within that range. Otherwise an IllegalArgumentException is thrown with a message "key out of range.". This is what is happening in this question. The range of subs is 326 to 328 and 329 is out of that range. Therefore, an IllegalArgumentException is thrown at runtime.