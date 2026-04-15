# AI Usage Report – Assignment 6: IntegerSet JUnit Testing

AI (ChatGPT & Claude) was used as a support tool for clarification, project setup, and understanding testing strategy throughout this assignment.

## 1. Understanding Assignment Requirements

AI helped clarify the distinction between Assignment 5 and Assignment 6 — specifically that Assignment 6 reuses the same `IntegerSet` implementation but focuses entirely on writing JUnit 5 tests, with no `Driver.java` needed.

## 2. File Structure and Package Setup

AI assisted with resolving package-related issues:

- Confirmed that both `IntegerSet.java` and `IntegerSetTest.java` belong in `src/org/howard/edu/lsp/assignment6/` under the same package
- Identified that the test file was originally importing `org.howard.edu.lsp.assignment5.IntegerSet` instead of using the local `assignment6` copy, which caused compilation errors
- Helped resolve an IntelliJ issue where JUnit annotations showed red underlines because the JUnit dependency was scoped to `Test` instead of `Compile`, which prevented it from working in the `src` folder

## 3. JUnit Testing Strategy

AI helped map test cases to the grading rubric to ensure full coverage:

- Clarified the difference between "normal case" and "edge case" — for example, testing `largest()` with multiple elements (normal) vs. on an empty set expecting `IllegalStateException` (edge)
- Identified specific required edge cases such as: duplicate values in `add()`, removing a non-existent element in `remove()`, order-independent equality in `equals()`, and disjoint sets in `complement()`
- Explained proper use of assertions: `assertEquals` for value comparison, `assertTrue`/`assertFalse` for boolean checks, `assertThrows` for exception verification, and `assertDoesNotThrow` for confirming no exception is thrown
- Recommended testing that `union()`, `intersect()`, `diff()`, and `complement()` do not modify the original sets by asserting their `toString()` output before and after the operation

## 4. Development Environment and Git

AI assisted with:

- Resolving IntelliJ project structure configuration (marking source roots, adding JUnit to the classpath)
- Understanding Git commands (`git status`, `git diff`) for tracking changes and managing which files to push

## Summary

AI was used for clarifying requirements, debugging IDE configuration, and planning test coverage.
