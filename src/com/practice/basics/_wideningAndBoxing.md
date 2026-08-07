### Widening and Boxing

Java allows:

- primitive widening
    - int → long ✔
- boxing
    - int → Integer ✔
- unboxing
    - Integer → int ✔

But Java does NOT allow:

wrapper widening
- Integer → Long ✘

There is no inheritance relationship between Integer and Long.
Both extend Number, but neither is a subtype of the other.

---