Yes. **JDBC / database access is included in the Java SE 21 Developer Professional (1Z0-830) exam objectives.**

It is part of the broader **JDBC API / database connectivity** material.

For your preparation, you should know the **core JDBC concepts**, especially:

* `DriverManager`
* `Connection`
* `Statement`
* `PreparedStatement`
* `CallableStatement`
* `ResultSet`
* `SQLException`
* try-with-resources with JDBC
* `ResultSet` cursor navigation (`next()`, etc.)
* column indexes starting at **1**
* basic transactions: `commit()` / `rollback()`

You **don't need to become a database/JDBC developer**. For 1Z0-830, the focus is generally on understanding the Java APIs and being able to reason about code snippets and API behavior.

Given the Enthuware questions you've been doing, **yes, this is one of those areas worth knowing because they can test small JDBC details such as `rs.getString(0)`**.

---

### ```next()``` > move to next row

```java
while (rs.next()) {
    ...
}
```

This is the standard way to iterate through results.

**Column indexes start at 1**

```java
rs.getString(1);  // first column ✅
rs.getString(2);  // second column ✅
rs.getString(0);  // ❌ SQLException
```

**You can also use column names**

```java
while (rs.next()) {
    System.out.println(rs.getInt("ID"));
    System.out.println(rs.getString("NAME"));
}
```
---



