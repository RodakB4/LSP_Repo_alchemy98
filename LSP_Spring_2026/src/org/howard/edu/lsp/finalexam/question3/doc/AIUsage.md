AI Tools Used:
Claude, ChatGPT

Prompts Used (2-5 max):
1. What boundary values should I test for a GradeCalculator that validates scores between 0 and 100?
2. How do I correctly write assertThrows in JUnit 5 for a method that takes parameters?
3. What test cases cover average(), letterGrade(), and isPassing() with good boundary coverage?
4. Where should JUnit test files be placed within the project structure when the test class is in the same package as the implementation?

How AI Helped (2-3 sentences):
Claude was used to write and structure the code while ChatGPT was used to understand the underlying concepts. AI helped identify the key boundary values, such as a score of 0, a score of 100, and an average exactly at 90, and confirmed the correct JUnit 5 assertThrows lambda syntax for methods with arguments. It also helped clarify where test files should be placed within the project directory structure to match the existing package organization.

Reflection (1-2 sentences):
This question reinforced that boundary values, meaning values exactly at the cutoff, are more likely to expose bugs than values safely inside a range. Using assertThrows with a lambda makes exception testing clean and readable in JUnit 5.
