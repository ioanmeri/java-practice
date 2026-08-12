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