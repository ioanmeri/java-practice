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