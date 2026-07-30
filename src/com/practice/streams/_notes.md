## Stream Notes

- Note that `count()` is also a terminal operation but it may **short circuit the stream pipeline**, 
    - which means, an implementation may choose to **not execute the stream pipeline** (either sequentially or in parallel) if it is capable of computing the count directly from the stream source. 
    - In such cases no source elements will be traversed and **no intermediate operations will be evaluated**.

**Short-Cirtuiting Terminal Operations**
- allMatch 
- noneMatch 
- anyMatch 
- findFirst 
- findAny


## Collectors Notes

- `Collectors.counting()` returns a Long, therefore, the type of the values in the map must be Long instead of Integer