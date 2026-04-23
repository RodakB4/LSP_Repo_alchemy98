AI Tools Used:
Claude, ChatGPT

Prompts Used (2-5 max):
1. Explain the concurrency problems in a RequestManager class where multiple threads call addRequest() simultaneously.
2. Which of three synchronized fixes correctly solves the race condition on nextId and ArrayList?
3. Show how ReentrantLock can make addRequest() thread-safe without using the synchronized keyword.

How AI Helped (2-3 sentences):
Claude was used to write and structure the code while ChatGPT was used to understand the underlying concepts. AI helped identify which shared resources, nextId and the ArrayList, are at risk in a multi-threaded environment and explained why each proposed fix either works or fails. It also demonstrated the ReentrantLock alternative with a concrete code snippet showing the lock, try, finally, and unlock pattern.

Reflection (1-2 sentences):
Working through this question reinforced that synchronizing only part of a compound operation, such as just getNextId(), does not make the full operation thread-safe. Understanding which lock scope covers all shared state is the key to correct concurrent design.
