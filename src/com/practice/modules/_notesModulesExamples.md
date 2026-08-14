## Notes Modules Examples

### Example 1

You have created a module named `mycompany.smartschool` packaged in `smartschool.jar`. 

This module **uses a third party non-modular** java **library** packaged as `utils.jar`.

How will you execute your module's main class named `mycompany.smartschool.Main`?

**Answer**

```
java --module-path smartschool.jar;utils.jar
     --module mycompany.smartschool/mycompany.smartschool.Main
```

- Remember that a module cannot access non-modular classes from the classpath. 
- You must convert non-modular third party jar to an automatic module by putting that jar on module-path. (You must have already added an appropriate requires clause in your module-info while compilation of your module).

Other options of the command remain the same i.e. --module-path (or -p) for specifying the location of module jars and --module (or -m) for specifying the module and class that you want to run.

---