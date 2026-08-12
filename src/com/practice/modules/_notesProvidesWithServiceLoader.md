## Notes Provides with Service

- `provides` means "I implement a service"

```
module abc.blogger {
    requires serviceapi;
    provides api.BloggerService with abc.SimpleBlogger;
}
```

This means:

- `api.BloggerService` → the **service interface**
- `abc.SimpleBlogger` → the **service provider/implementation**
- `provides ... with ...` → registers `SimpleBlogger` as a provider

To discover providers, use:
- `ServiceLoader.load(BloggerService.class)`

Then you can iterate through the discovered implementations:
- `bsLoader.forEach(bs -> bs.blog("hello"));`


### Correct

```
ServiceLoader<BloggerService> bsLoader = ServiceLoader.load(BloggerService.class);
bsLoader.forEach(bs -> bs.blog("hello"));
```

---

### Example Find First

`findFirst()` returns `Optional<BloggerService>`

```java
ServiceLoader<BloggerService> bsLoader = ServiceLoader.load(BloggerService.class);
```

Correct
```
Optional<BloggerService> bs = bsLoader.findFirst();
```
Instead of

```
BloggerService bs = bsLoader.findFirst();
```

---

### Notes

- `ServiceLoader` is a standard Java class `java.util.ServiceLoader`
- There is **no** `ServiceLoader.get()`

---


