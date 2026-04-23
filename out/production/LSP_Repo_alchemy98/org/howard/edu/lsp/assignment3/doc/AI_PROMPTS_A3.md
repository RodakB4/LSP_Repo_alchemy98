# AI Prompts Used for Assignment 3

## Prompt 1: Understanding the Assignment
**My Prompt:**
"I need to redesign my Assignment 2 ETL pipeline to be more object-oriented. The assignment says to use multiple classes with clear responsibilities. What are the main concepts I should focus on for splitting up my single-class solution?"

**AI Response Excerpt:**
The AI explained that I should think about separating the Extract, Transform, and Load phases into different classes, and suggested using a Product class to represent the data instead of working with raw strings.

**How I Used It:**
This helped me realize I could create separate classes for reading, transforming, and writing. I decided to map each phase of ETL to a dedicated class.

## Prompt 2: Planning My Class Structure
**My Prompt:**
"I'm thinking of having a Product class to hold the data, and maybe separate classes for reading and writing CSV files. Should I also have a separate class just for transformations, or put that logic in the Product class?"

**AI Response Excerpt:**
The AI recommended keeping transformation logic separate in a ProductTransformer class rather than putting it in Product, because Product should just hold data (encapsulation principle).

**How I Used It:**
I agreed with this approach and created ProductTransformer as a separate class. This keeps Product as a simple data holder and makes the transformation logic easier to modify later. I also added a private helper method for calculating price ranges to keep that logic encapsulated.

## Prompt 3: Product Class Design
**My Prompt:**
"For the Product class, I need fields for productId, name, price, category, and priceRange. Should these be public or private? And do I need both getters and setters for all of them?"

**AI Response Excerpt:**
The AI explained that fields should be private to demonstrate encapsulation, and I should provide public getters/setters for controlled access.

**How I Used It:**
I implemented private fields with public accessor methods. I realized that priceRange is calculated during transformation, so it starts empty in the constructor but gets set later by the transformer.

## Prompt 4: Validation Logic Placement
**My Prompt:**
"In Assignment 2, I had validation logic to skip bad rows (blank lines, wrong number of fields, invalid numbers). Should this go in CSVReader or somewhere else?"

**AI Response Excerpt:**
The AI suggested putting validation in CSVReader since that's where the file is being read, and CSVReader can track rowsRead and rowsSkipped.

**How I Used It:**
I put all the validation and row-skipping logic in CSVReader. I also added getter methods so the main class could access these counts for the summary output.

## Prompt 5: Transformation Order
**My Prompt:**
"I need to make sure I apply transformations in the exact same order as Assignment 2. The tricky part is that I need to check the ORIGINAL category for step 3, even after I might have changed the price in step 2. How should I handle this?"

**AI Response Excerpt:**
The AI suggested saving the original category in a local variable before applying any transformations, then using that saved value in step 3.

**How I Used It:**
I added a line in ProductTransformer that saves `originalCategory` at the start of the transform method, which ensures step 3 works correctly even after price changes.


