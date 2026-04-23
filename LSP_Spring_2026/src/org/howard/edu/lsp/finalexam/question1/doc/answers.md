Part 1:
Shared Resource #1: nextId (the int field that tracks the next available request ID, read and written by multiple threads)
Shared Resource #2: requests (the ArrayList<String> that stores all requests, modified by multiple threads simultaneously)

Concurrency Problem: Race condition — two or more threads can read the same value of nextId before any of them increments it, resulting in duplicate request IDs being assigned. Concurrent writes to ArrayList can also corrupt the list structure since ArrayList is not thread-safe.

Why addRequest() is unsafe: getNextId() is not synchronized, so the read-increment-write sequence on nextId is not atomic. Two threads can both read nextId = 1, both increment to get id = 1, and both add a request labeled "Request-1", creating a duplicate ID. Additionally, ArrayList.add() is not thread-safe and concurrent calls can lead to data corruption or lost updates.

Part 2:
Fix A: INCORRECT. Synchronizing only getNextId() makes ID generation atomic, but addRequest() itself is not synchronized. Two threads can still interleave after each gets its unique ID and then call requests.add() concurrently on a non-thread-safe ArrayList, potentially corrupting the list. The fix protects ID generation but leaves the ArrayList write unprotected.

Fix B: CORRECT. Synchronizing addRequest() ensures that only one thread can execute the entire method at a time, using the RequestManager instance as the monitor lock. Since getNextId() is called from inside addRequest(), ID generation is also effectively serialized under the same lock. Both the nextId counter and the ArrayList are fully protected from concurrent access.

Fix C: INCORRECT. Synchronizing getRequests() only protects reading the list reference, not writing to it. The addRequest() method remains unsynchronized, so the race conditions on nextId and the concurrent ArrayList modifications are completely unresolved. This fix does nothing to prevent duplicate IDs or list corruption.

Part 3:
Answer: No, getNextId() should NOT be public.

Explanation: According to Riel's heuristics, a class should minimize its public interface and only expose what external clients actually need. getNextId() is an internal implementation detail — it exists solely to support addRequest(). Clients of RequestManager do not need to call getNextId() directly; they only need to call addRequest(). Making getNextId() public allows external callers to invoke it independently, which increments nextId without adding a request, silently corrupting the ID sequence. It should be private to enforce proper encapsulation and prevent misuse.

Part 4:
Description: The alternative approach is using a ReentrantLock from the java.util.concurrent.locks package. Instead of using the synchronized keyword, a ReentrantLock object is explicitly acquired before the critical section and released in a finally block to guarantee the lock is always released even if an exception is thrown. This approach gives more control over locking (e.g., timed lock attempts, interruptible locks) compared to synchronized.

Code Snippet:
```java
import java.util.concurrent.locks.ReentrantLock;

private final ReentrantLock lock = new ReentrantLock();

public void addRequest(String studentName) {
    lock.lock();
    try {
        int id = nextId++;
        String request = "Request-" + id + " from " + studentName;
        requests.add(request);
    } finally {
        lock.unlock();
    }
}
```
