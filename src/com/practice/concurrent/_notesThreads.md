## Thread Notes

### Thread States

- `NEW`
  - Thread created, `start()` not called
- `RUNNABLE`
  - Eligible to run or currently running
- `BLOCKED`
  - Waiting to acquire a monitor (`synchronized`)
- `WAITING`
  - Waiting indefinitely (`wait()`, `join()`)
- `TIMED_WAITING`
  - Waiting with a timeout(`sleep()`, `wait(timeout)`)
- `TERMINATED`
  - `run()` ha completed

---