## Top Down Approach for modularising an application

While modularizing an app in a top-down approach, you need to remember the following points -

1. Any **jar** file can be converted into an **automatic module** by simply putting that jar on the **module-path** instead of the classpath. 
   2. Java **automatically derives the name** of this module **from the name of the jar** file. 
   3. An automatic module implicitly **exports all of its packages**.

2. Any **jar** that is put on **classpath** (instead of module-path) is loaded as a part of the **unnamed module**. 
   3. The unnamed module implicitly **exports all of its packages**.

3. An explicitly **named module** (which means, a module that has an explicitly defined name in its module-info.java file) 
   4. **can specify dependency on an automatic module** just like it does for any other module i.e. by adding a requires <module-name>; clause in its module info but 
   5. **it cannot do so for the unnamed module** because there is no way to write a requires clause without a name.  
   6. In other words, an explicitly **named module can "read" classes present in an automatic module** using an appropriate requires clause but cannot read classes in the unnamed module by any means.

4. An **automatic module exports all of its packages** and is allowed to **read all packages exported by other modules**. 
   5. Thus, a class in an automatic module can access: 
      6. all packages of other automatic modules + 
      7. all packages exported by explicitly named modules + 
      8. all packages of the unnamed module.

5. The **unnamed module exports all of its packages** and is allowed to **read all packages exported by other modules**. 
   6. Thus, a class in the unnamed module can access: 
      7. all packages of the unnamed module + 
      8. all packages of automatic modules + 
      9. all packages exported by explicitly named modules.

---

> Thus, if your application jar A directly uses a class from another jar B, then you would have to convert B into a module (either named or automatic). If B uses another jar C, then you can leave C on the class path if B hasn't yet been migrated into a named module. Otherwise, you would have to convert C into an automatic module as well.

Note:
There are two possible ways for an automatic module to get its name:
1. When an Automatic-Module-Name entry is available in the manifest, its value is the name of the automatic module.
2. Otherwise, a name is derived from the JAR filename (see the ModuleFinder JavaDoc for the derivation algorithm) - Basically, **hyphens are converted into dots** and the version number part is ignored. So, for example, 
   3. if you put `mysql-connector-java-8.0.11.jar` on module path, its module name would be `mysql.connector.java`