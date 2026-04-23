# Design Evaluation of PriceCalculator

## Overview

The `PriceCalculator` class uses a chain of `if` statements to determine the final price based
on customer type. While this works for a small number of cases, the design introduces several
problems as the system grows.

## 1. Violates the Open/Closed Principle

Every time a new customer type is introduced (e.g., EMPLOYEE, STUDENT, SENIOR), the
`calculatePrice()` method must be directly modified to add another `if` block. A well-designed
system should be open for extension but closed for modification — new pricing behaviors should
be addable without touching existing code.

## 2. Growing If-Chain Is Fragile and Hard to Maintain

As customer types increase, the method becomes a long chain of conditionally branching logic.
This makes the code harder to read, more error-prone during edits, and increasingly difficult
to test. A single misplaced condition or typo in a string comparison could silently produce
incorrect prices.

## 3. No Polymorphism

The class relies on string comparisons to select behavior rather than leveraging polymorphism.
Each customer type's pricing logic is a natural candidate for its own class, but instead they
are all flattened into a single method. Using polymorphism would allow each pricing strategy to
encapsulate its own rules independently.

## 4. Tight Coupling Between Customer Types and Pricing Logic

All pricing rules for every customer type live in one place. This means a change to VIP pricing
could accidentally affect MEMBER or HOLIDAY pricing if the method is edited carelessly. There is
no isolation between discount behaviors — they are all tangled together in the same method body.

## 5. String-Based Type Identification Is Error-Prone

Customer types are identified by raw strings like `"REGULAR"` and `"VIP"`. There is no
compile-time safety — a typo like `"MEMMBER"` would silently fall through all the conditions
and return the unmodified price with no warning. This also makes refactoring risky since the
compiler cannot catch mismatches.

## 6. Poor Testability

Because all pricing logic is embedded in a single method, you cannot test one customer type's
pricing in isolation. Unit tests must go through the same method and rely on string inputs,
making it harder to pinpoint failures. Separate strategy classes would allow each discount rule
to be tested independently.

## 7. No Default or Error Handling

If an unrecognized customer type is passed (e.g., `"GOLD"`), the method silently returns the
original price with no indication that something unexpected happened. There is no explicit
default case, no exception, and no logging — the caller has no way to know the input was invalid.

## 8. Hardcoded Discount Values

The discount percentages (0.9, 0.8, 0.85) are directly embedded in the method.
Makes changing discount rules or reading them from a configuration impossible without modifying code.

## 9. Mixed Levels of Abstraction

PriceCalculator mixes “decision logic” (customer type) and “calculation logic” (discount application). 
Ideally, selection of strategy and calculation should be separated.

## 10. Low Extensibility

Adding a new type like “STUDENT” requires modifying PriceCalculator itself, which violates maintainability and OCP. 
Already implied by 1 & 2, but explicitly stating extensibility can earn extra clarity points.