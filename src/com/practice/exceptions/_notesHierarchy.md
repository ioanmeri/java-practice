```
java.lang.Throwable
│
├── java.lang.Error
│   │
│   ├── AssertionError
│   ├── LinkageError
│   │   │
│   │   ├── ClassCircularityError
│   │   ├── ClassFormatError
│   │   ├── ExceptionInInitializerError
│   │   ├── IncompatibleClassChangeError
│   │   │   │
│   │   │   ├── AbstractMethodError
│   │   │   ├── IllegalAccessError
│   │   │   ├── InstantiationError
│   │   │   ├── NoSuchFieldError
│   │   │   └── NoSuchMethodError
│   │   │
│   │   ├── NoClassDefFoundError
│   │   └── UnsatisfiedLinkError
│   │
│   ├── VirtualMachineError
│   │   │
│   │   ├── InternalError
│   │   ├── OutOfMemoryError
│   │   ├── StackOverflowError
│   │   └── UnknownError
│   │
│   └── ThreadDeath
│
└── java.lang.Exception
    │
    ├── Checked Exceptions
    │   │
    │   ├── IOException
    │   │   │
    │   │   ├── FileNotFoundException
    │   │   └── EOFException
    │   │
    │   ├── SQLException
    │   ├── ClassNotFoundException
    │   ├── InterruptedException
    │   ├── ReflectiveOperationException
    │   │   │
    │   │   ├── ClassNotFoundException
    │   │   ├── IllegalAccessException
    │   │   ├── InstantiationException
    │   │   ├── InvocationTargetException
    │   │   └── NoSuchFieldException
    │   │
    │   └── ParseException
    │
    └── RuntimeException
        │
        ├── ArithmeticException
        ├── ArrayStoreException
        ├── ClassCastException
        ├── ConcurrentModificationException
        ├── EmptyStackException
        ├── IllegalArgumentException
        │   │
        │   ├── IllegalChannelGroupException
        │   ├── IllegalFormatException
        │   ├── NumberFormatException
        │   └── InvalidPathException
        │
        ├── IllegalMonitorStateException
        ├── IllegalStateException
        ├── IndexOutOfBoundsException
        │   │
        │   ├── ArrayIndexOutOfBoundsException
        │   └── StringIndexOutOfBoundsException
        │
        ├── MissingResourceException
        ├── NegativeArraySizeException
        ├── NoSuchElementException
        ├── NullPointerException
        ├── SecurityException
        ├── TypeNotPresentException
        ├── UnsupportedOperationException
        └── UncheckedIOException
```