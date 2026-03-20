# Proposed Redesign — CRC Cards

## Card 1: Order

**Class:** Order

**Responsibilities:**
- Store order data (customer name, email, item, price)
- Validate input fields (non-null, non-negative price, valid email)
- Provide access to order details through getters

**Collaborators:** None

---

## Card 2: TaxCalculator

**Class:** TaxCalculator

**Responsibilities:**
- Calculate tax for a given price
- Store the tax rate as a configurable value

**Collaborators:** Order

---

## Card 3: DiscountCalculator

**Class:** DiscountCalculator

**Responsibilities:**
- Determine if a discount applies based on price threshold
- Calculate the discounted total
- Store discount rules as configurable values

**Collaborators:** Order

---

## Card 4: ReceiptPrinter

**Class:** ReceiptPrinter

**Responsibilities:**
- Format and print a receipt for a processed order
- Display customer name, item, and final total

**Collaborators:** Order

---

## Card 5: OrderRepository

**Class:** OrderRepository

**Responsibilities:**
- Persist order records to a storage destination (e.g., file)
- Handle I/O errors and propagate failures appropriately

**Collaborators:** Order

---

## Card 6: EmailService

**Class:** EmailService

**Responsibilities:**
- Send a confirmation email to the customer after order processing

**Collaborators:** Order

---

## Card 7: ActivityLogger

**Class:** ActivityLogger

**Responsibilities:**
- Log order processing activity with timestamps

**Collaborators:** None

---

## Card 8: OrderProcessor

**Class:** OrderProcessor

**Responsibilities:**
- Orchestrate the order processing workflow
- Delegate tax calculation, discounts, receipt printing, persistence, email, and logging to collaborators
- Ensure correct ordering of business logic (discounts before output)

**Collaborators:** Order, TaxCalculator, DiscountCalculator, ReceiptPrinter, OrderRepository, EmailService, ActivityLogger