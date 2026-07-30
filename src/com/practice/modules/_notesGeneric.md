## Modules

- A non-modular jar placed on the module-path results in an **automatic module**.
  - Remember that automatic modules are also named modules. Their name is inferred using the name of the jar file (or from Automatic-Module-Name entry of its manifest).
- A modular jar placed on the module-path results in a named application module.
  - Any jar (modular or non-modular) placed on the module-path becomes a named application module.
- If a package is available in a jar on the classpath as well as in another jar on the module-path, the one on the classpath is ignored.
