## Notes Sealed Classes


### Sealed Classes

- A sealed class has a rule:
    - If the sealed class is in a **named module**, all permitted **subclasses** must be **in the same module**.
    - They **do not need to be in the same package**.
- Only **Classes** and **Interfaces** can be sealed. Cannot be sealed
    - Enums (is implicitly final)
    - Records (is implicitly final)
- Sealed does not require abstract, and it is not limited to top-level types
- A sealed class must pre-define a list of subclasses, which means, a sealed class always has one or more subclasses.
    - Thus, a sealed class cannot be final
- It is ok for a nested sealed class to omit the permits clause
- A class **cannot be both - final and non-sealed**, at the same time
  - Non-sealed implies that a class may have subclasses, while final implies that a class cannot be subclassed
  - Both are contradictory

---

