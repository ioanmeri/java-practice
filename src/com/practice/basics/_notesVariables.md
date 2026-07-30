## Variable Notes

### Var

- var declarations are allowed only for local variables (i.e. variables defined inside method body) and in for loops
- var is not allowed as an element type of array.
  - `var cA[][]` implies that the type of the elements of the cA array is var, which is not allowed. 
  - `var cA = new char[3][];` would be valid.

--- 
### Integers

- `Integer.parseInt(s);` throws a **NumberFormatException** because 12.3 is not an integer.
  - `f = Float.valueOf("12.3");`
  - `int i = Integer.parseInt(s);`

---