# Development Log for Question 2
**Author:** Rodak Tehwodros Beckure  
**Course:** LSP Midterm — Question 2  
**File:** development_log_q2.md

---

## Overview
This log documents all external resources used while completing Question 2 of the midterm.  
All AI interactions, conceptual clarifications, and design reasoning sessions are included here as required.

---

## AI Assistance Used (ChatGPT & Claude)

I used ChatGPT to help analyze the poor object-oriented design in the provided `OrderProcessor` class and to reason through the redesign using CRC cards. Below is a summary of the prompts and how the responses guided my solution.
Whereas I used Claude to help write the implementations for the descriptions and so forth.

### **1. Identifying Object-Oriented Design Problems**
**What I asked:**  
I asked ChatGPT to point out flaws in the `OrderProcessor` class beyond the obvious ones like poor encapsulation and too many responsibilities.

**How it helped:**  
ChatGPT explained several additional issues:
- Law of Demeter violations
- Hard-coded values (“magic numbers”)
- Lack of abstraction
- Poor testability
- Mixed levels of abstraction
- No error propagation
- Tight coupling to I/O

These points helped shape my analysis section for `evaluation.md`.

---

### **2. Clarifying the CRC Card Architecture**
**What I asked:**  
I asked which CRC cards were appropriate for a clean redesign, and whether additional classes were needed or if some should be removed.

**How it helped:**  
ChatGPT validated that the following set of classes formed a strong and realistic architecture:

- ReceiptPrinter
- OrderRepository
- EmailService
- ActivityLogger
- OrderProcessor

It also explained why this set should not be expanded further, keeping the system clean but not over-engineered.  
This guided the final list used in `design.md`.

---

### **3. General Explanations**
ChatGPT provided conceptual explanations based on:
- Single Responsibility Principle
- Coupling vs. cohesion
- Separation of concerns
- Riel’s object-oriented heuristics


---

## Other External Resources
No websites, documentation pages, Stack Overflow posts, textbooks, or lecture slides were used.

---
