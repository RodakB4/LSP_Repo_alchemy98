# Design Evaluation of OrderProcessor

## Overview

The `OrderProcessor` class suffers from numerous object-oriented design violations that make it
difficult to maintain, test, and extend. The issues are outlined below.

## 1. Poor Encapsulation (Public Fields)

All fields (`customerName`, `email`, `item`, `price`) are declared `public`, meaning any
external class can directly read or modify them without any validation or control. This violates
one of Riel's core heuristics: a class should hide its implementation details and only expose
behavior through well-defined methods. These fields should be `private` with accessor methods
that can enforce constraints — for example, preventing a negative price from being set.

## 2. Too Many Responsibilities (God Class)

The `processOrder()` method handles tax calculation, receipt printing, file storage, email
notification, discount logic, and activity logging — all in a single class. This violates the
principle that a class should have a single, well-defined responsibility. When a class tries to
do everything, any change to one concern (say, how emails are sent) risks breaking unrelated
functionality (say, how receipts are printed). Each of these responsibilities should be
extracted into its own class.

## 3. Tight Coupling to Implementation Details

File writing is hardcoded directly into `processOrder()` using `FileWriter`, and email sending
is embedded inline as well. This means the class is tightly coupled to specific implementations.
If the system later needs to store orders in a database instead of a text file, or send emails
through an external API, the entire method must be rewritten. These dependencies should be
abstracted behind interfaces so they can be swapped without modifying OrderProcessor.

## 4. Incorrect Business Logic Ordering

The discount is applied *after* the receipt is printed and the order is saved to file. This
means the customer sees an incorrect total on the receipt, and the wrong amount is persisted
to the file. The discount calculation should happen before any output or storage takes place,
so that all downstream consumers see the correct final total.

## 5. No Separation of Data and Behavior

The `OrderProcessor` class stores order data (customer name, email, item, price) and also
performs all processing operations on that data. According to Riel's heuristics, data and the
operations that belong to different concerns should not be lumped together. A separate `Order`
class should hold the order data, while processing responsibilities are distributed among
focused classes.

## 6. Poor Extensibility

Because everything is packed into one method in one class, extending the system is extremely
difficult. Adding a new discount rule, supporting a new output format, or changing the tax
rate all require modifying `processOrder()` directly. A well-designed system would allow new
behaviors to be added by creating new classes rather than editing existing code.

## 7. Violates the Law of Demeter

The `processOrder()` method directly reaches into low-level I/O classes like `FileWriter` and
output streams rather than delegating to collaborators that handle those concerns. The Law of
Demeter states that a method should only interact with its immediate collaborators, not dig
through chains of implementation details. OrderProcessor should delegate file operations to a
dedicated persistence class instead of managing file handles itself.

## 8. Hard-Coded Magic Values

The tax rate (`0.07`), the discount threshold (`500`), the discount multiplier (`0.9`), and
the output file name (`"orders.txt"`) are all hard-coded directly in the method body. These
magic values have no explanation, are easy to overlook during maintenance, and require editing
source code to change. They should be extracted into named constants or configuration
parameters that can be modified without touching the business logic.

## 9. Generic Error Handling with No Propagation

The `try-catch` block around file writing catches a generic `Exception` and only calls
`e.printStackTrace()`. This silently swallows the error — the method continues executing as if
nothing went wrong, and the caller has no way of knowing the file write failed. Proper design
would either propagate the exception to the caller, throw a domain-specific exception, or at
minimum use a logging framework with appropriate severity levels.

## 10. No Interfaces or Polymorphism

There are no interfaces or abstract types anywhere in the design. Every dependency is a
concrete class, which prevents substitution. For example, if there were an `EmailService`
interface, you could swap in different implementations (SMTP, API-based, mock for testing)
without changing OrderProcessor. The absence of polymorphism makes the system rigid and
impossible to extend without modifying existing code.

## 11. Poor Testability

Because all dependencies (file system, email, console output) are instantiated directly inside
`processOrder()`, there is no way to isolate the class for unit testing. You cannot mock the
file writer, intercept email sends, or verify output without actually triggering real side
effects. If dependencies were injected through constructors or interfaces, each component
could be tested independently.

## 12. Mixed Levels of Abstraction

Within a single method, the code jumps between high-level business operations (calculating
totals, applying discounts) and low-level implementation details (opening file handles, writing
raw strings, flushing streams). This mixing makes the method difficult to read and reason about.
High-level orchestration logic and low-level I/O should be separated into different layers so
each can be understood and maintained on its own terms.

## 13. Unclear API

The class exposes a single method, `processOrder()`, that silently performs many unrelated
operations with no indication to the caller of what will happen. There is no way to calculate
a total without printing a receipt, save an order without sending an email, or apply a discount
without logging. A well-designed API would expose distinct, composable operations so the caller
has control over what gets executed and in what order.

## 14. No Validation of Input Fields

There is no validation anywhere — not in the constructor, not through setters, and not at the
start of `processOrder()`. Fields like `email` could be null or malformed, `price` could be
negative, and `customerName` could be empty. The method will proceed with invalid data,
producing garbage output, corrupted files, and meaningless emails. Input validation should be
enforced at the point of entry, either in a constructor or through validated setter methods.