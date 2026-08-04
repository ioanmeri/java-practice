## Notes Serializable

- When an object is **deserialized**, **only the Serializable class’s constructor is skipped**.
    - Constructors of **non‑serializable superclasses ARE executed**.