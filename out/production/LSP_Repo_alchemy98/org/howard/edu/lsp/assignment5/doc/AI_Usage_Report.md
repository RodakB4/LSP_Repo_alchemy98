# AI Usage Report – Assignment 5: IntegerSet + JUnit Tests

AI was used as a conceptual guide throughout this assignment — not for direct code generation, but for understanding design expectations, clarifying behavior, and planning test coverage.

## 1. Understanding the Assignment Requirements

AI helped clarify the intended behavior of each method:

- `largest()` and `smallest()` should throw exceptions on empty sets
- `union()`, `intersect()`, `diff()`, and `complement()` must return **new** `IntegerSet` objects without modifying the originals
- `equals()` checks element equality regardless of insertion order
- `add()` must prevent duplicates internally
- `toString()` must return elements in ascending order with the format `[1, 2, 3]`

## 2. Design Decisions

AI helped evaluate two possible internal representations:

- **ArrayList**: simple to implement, but `contains()` is O(n), making set operations O(n²)
- **HashSet**: O(1) lookups and automatic duplicate prevention, but requires sorting for `toString()`

This discussion clarified the trade-offs, even though the assignment required using `ArrayList`.

## 3. Planning JUnit Test Coverage

AI helped identify what to test across three categories:

- **Core functionality**: add, remove, contains, length, clear, largest, smallest, isEmpty, toString
- **Set operations**: union, intersect, diff, and complement return correct results and don't mutate originals
- **Edge cases**: empty sets, negative numbers, single-element sets, duplicate additions, removing non-existent elements

AI also explained the Arrange/Act/Assert pattern and proper use of `assertThrows`, `assertDoesNotThrow`, and `assertEquals`.

## 4. Summary

AI was used for explaining concepts, clarifying assignment expectations, reasoning about set theory behavior, discussing time complexity, and planning thorough test coverage.