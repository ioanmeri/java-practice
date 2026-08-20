## Notes Provides with Service

**Example**

```
module author{
  requires serviceapi;
  uses api.BloggerService;
}

// and

module abc.blogger{
  requires serviceapi;
  provides api.BloggerService with abc.SimpleBlogger;
}

```

Yes — **`api.BloggerService` should be defined in the `serviceapi` module**. This is the key idea behind Java's **Service Provider Interface (SPI)** pattern.

Also: `abc.blogger` module should be on `--module-path` **while executing the author** module but is **not** required while **compiling**


Let's break it down.

### 1. What each module represents

You have three conceptual pieces:

```text
serviceapi
    |
    | defines
    v
api.BloggerService   ← the service interface

author
    |
    | uses
    v
BloggerService

abc.blogger
    |
    | provides implementation of
    v
BloggerService
```

So `serviceapi` is the **contract/API**, while the other two modules use that contract in different ways.

---

### 2. `serviceapi` defines the interface

For example:

```java
package api;

public interface BloggerService {
    void blog();
}
```

This belongs in:

```text
serviceapi
└── api
    └── BloggerService.java
```

And `serviceapi` exports the package:

```java
module serviceapi {
    exports api;
}
```

Why?

Because **both `author` and `abc.blogger` need to know what `BloggerService` is**.

---

### 3. `author` is the service consumer

Your `author` module says:

```java
module author {
    requires serviceapi;
    uses api.BloggerService;
}
```

This means:

> "I depend on the `BloggerService` interface, and at runtime I want to find an implementation of it."

For example:

```java
ServiceLoader<BloggerService> loader =
    ServiceLoader.load(BloggerService.class);
```

`author` does **not** need to know which class implements the service.

It only knows the interface.

---

### 4. `abc.blogger` is the service provider

It says:

```java
module abc.blogger {
    requires serviceapi;
    provides api.BloggerService
        with abc.SimpleBlogger;
}
```

This means:

> "`abc.blogger` provides an implementation of the `BloggerService` interface."

For example:

```java
package abc;

public class SimpleBlogger implements BloggerService {
    public void blog() {
        System.out.println("Blogging...");
    }
}
```

Notice the dependency:

```text
abc.blogger → serviceapi
```

The provider needs the interface because it implements it.

But:

```text
abc.blogger -X-> author
```

It does **not** need to know about `author`.

---

## Why can't `BloggerService` be in `author`?

If you put the interface here:

```text
author
└── api
    └── BloggerService
```

then `abc.blogger` would have to depend on `author`:

```text
abc.blogger → author
```

That would be backwards architecturally.

The service **consumer** shouldn't own the API that the **provider** must implement.

Instead, you extract the common contract:

```text
              ┌──────────────┐
              │  serviceapi   │
              │              │
              │ BloggerService│
              └──────┬───────┘
                     │
            ┌────────┴────────┐
            │                 │
            ▼                 ▼
        ┌────────┐       ┌─────────────┐
        │ author │       │ abc.blogger │
        │ uses   │       │ provides    │
        └────────┘       └─────────────┘
```

This is the important exam concept.

### Remember this for 1Z0-830

Think of the three roles:

| Module        | Role                          | Declaration                            |
| ------------- | ----------------------------- | -------------------------------------- |
| `serviceapi`  | Defines the service interface | `exports api`                          |
| `author`      | **Consumer** of service       | `uses api.BloggerService`              |
| `abc.blogger` | **Provider** of service       | `provides api.BloggerService with ...` |

So the answer:

> **`api.BloggerService` should be defined in `serviceapi` module**

is correct because **the service interface belongs in the API/contract module that is shared by both the consumer and provider**.

And this also explains why both modules have:

```java
requires serviceapi;
```

They both need access to the **same service contract**, but neither should depend on the other.

> The fact that both modules require serviceapi tells you that serviceapi is the module that contains the shared API/contract, which is why BloggerService is defined there.

---

### Provides Service with Provider

```
module abc.print {
    requires org.pdf;
    provides org.pdf.Print with com.abc.print.PrintImpl;
}
```

`org.pdf.Print` is the **service**

In Java's Module System (JPMS), the word service has a specific meaning:
- it is the **API (interface or abstract class)** that defines a capability, and
- providers supply implementations of it.

---

### Notes

Ideally, api.BloggerService should be an interface or an abstract class but there is no such technical restriction

The service must be a class type, an interface type, or an annotation type.

Here are the rules for a service provider:

1. If a service provider explicitly declares a public constructor with no formal parameters, or implicitly declares a public default constructor, then that constructor is called the provider constructor.

2. If a service provider explicitly declares a public static method called provider with no formal parameters, then that method is called the provider method.

3. If a service provider has a provider method, then its return type must (i) either be declared in the current module, or be declared in another module and be accessible to code in the current module; and (ii) be a subtype of the service specified in the provides directive; or a compile-time error occurs.

4. While a service provider that is specified by a provides directive must be declared in the current module, its provider method may have a return type that is declared in another module. Also, note that when a service provider declares a provider method, the service
   provider itself need not be a subtype of the service.

5. If a service provider does not have a provider method, then that service provider must have a provider constructor and must be a subtype of the service specified in the provides directive, or a compile-time error occurs.

For more info, please see https://docs.oracle.com/en/java/javase/21/docs/api//java.base/java/util/ServiceLoader.html#deploying-service-providers-as-modules-heading