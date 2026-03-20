# Development Log for Question 3
**Author:** Rodak Tehwodros Beckure  
**Course:** LSP Midterm — Question 3  
**File:** development_log_q3.md

---

## Overview
This log documents all external resources used while completing Question 3 of the midterm.  
It includes reasoning about design evaluation, Strategy Pattern refactoring, and structuring the implementation.

---

## AI Assistance Used (ChatGPT & Claude)

I used ChatGPT to help analyze the design of the provided `PriceCalculator` class, identify its limitations, and guide the refactoring using the Strategy Pattern.

### **1. Identifying Design Problems**
**What I asked:**  
I asked ChatGPT to evaluate the original `PriceCalculator` implementation and point out why it might be difficult to maintain or extend.

**How it helped:**  
ChatGPT highlighted several issues:
- Violates the Open/Closed Principle
- Growing if-chain is fragile
- No polymorphism
- Tight coupling between customer types and pricing logic
- String-based type identification is error-prone
- Hardcoded discount values


These points formed the basis for `design_evaluation.md`.

---

### **2. Refactoring with the Strategy Pattern**
**What I asked:**  
I asked ChatGPT how to apply the Strategy Pattern to the `PriceCalculator`, including interface design, concrete strategies, and context class.

**How it helped:**  
ChatGPT suggested:
- Creating a `PricingStrategy` interface
- Creating a concrete class for each customer type (Regular, Member, VIP, Holiday)
- Refactoring `PriceCalculator` to delegate calculation to the selected strategy
- Using `setStrategy()` for dynamic behavior
- Heavily suggested using a factory or enum for strategy selection

I decided to keep the design simple by **instantiating strategies directly in the driver**, avoiding unnecessary complexity.

---


## Other External Resources
No websites, documentation pages, Stack Overflow posts, textbooks, or lecture slides were used.

---