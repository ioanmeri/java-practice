## Notes Serializable

- When an object is **deserialized**, **only the Serializable class’s constructor is skipped**.
    - Constructors of **non‑serializable superclasses ARE executed**.
- **No-args constructor is required** in the most specific class in the class hierarchy **that doesn't implement Serializable**. 
  - It will throw an `InvalidClassException`.
- `Static` **fields are not serialized** 
- `transient` **fields are not serialized**

---