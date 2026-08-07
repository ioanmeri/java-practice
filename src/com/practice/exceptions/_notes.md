## Exceptions

- A `catch` block catches the specified type and **all of its subclasses**.
  - `E2 extends E1` with `catch(E1 e){` with catch `throw new E2();`