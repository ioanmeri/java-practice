## Module Requires Example 1

### Statement

Your application is packaged in **myapp.jar** and 
- depends on a jar named **datalayer.jar**, 
    - which in turn depends on **mysql-connector-java-8.0.11.jar**. 

The following packages exist in these jars:
- myapp.jar:   com.abc.myapp
- datalayer.jar: com.abc.datalayer
- mysql-connector-java-8.0.11.jar:  com.mysql.jdbc


You have decided to modularize your application even though datalayer and mysql libraries are still not modularlized. 
Which of the following would be a valid module-info for your app?

---

### Solution

```java
module abc.myapp{
  requires datalayer;
}
```

---

### Explanation

Since myapp depends directly only on **datalayer.jar**, you just need to **put this jar on module-path to make it an automatic module**. 

The name of this module will be datalayer. Thus, you must specify requires datalayer; in the module-info of myapp.

There is no need to add a dependency on msql jar in myapp. datalayer will be able to access mysql classes if you simply put the mysql jar on the classpath.

So, your command to run myapp module would be:


```bash
java --module-path datalayer.jar;myapp.jar -classpath mysql-connector-java-8.0.11.jar
--module abc.myapp
```
