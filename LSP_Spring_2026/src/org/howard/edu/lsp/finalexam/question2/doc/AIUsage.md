AI Tools Used:
Claude, ChatGPT

Prompts Used (2-5 max):
1. Explain the Template Method design pattern and how to implement it in Java with an abstract base class.
2. How should the fixed workflow steps be defined so subclasses cannot change the order?
3. Show how a Driver can use polymorphism with a List<Report> to call generateReport() on different report types.
4. What is the correct package directory structure for a multi-package Java project with src and doc subpackages?

How AI Helped (2-3 sentences):
Claude was used to write and structure the code while ChatGPT was used to understand the underlying concepts. AI clarified that the template method should be marked final in the abstract class so subclasses cannot override the workflow, while the hook methods, formatHeader, formatBody, and formatFooter, remain abstract for subclasses to implement. It also helped clarify the correct file and package directory structure for organizing source files and documentation files across multiple subpackages.

Reflection (1-2 sentences):
This question showed how the Template Method pattern enforces a consistent process while still allowing flexible behavior through inheritance. Marking generateReport() as final is a small but critical detail that correctly applies the pattern.
