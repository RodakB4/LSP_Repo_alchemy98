# Assignment 3 Reflection

## Comparison of Assignment 2 vs Assignment 3

### Assignment 2 Design
In Assignment 2, I implemented the ETL pipeline in a single class (`ETLPipeline.java`) with all logic contained in the `main()` method. The program was procedural, it read the CSV line by line, applied transformations inline, and wrote the output, all in one sequential flow.

### Assignment 3 Design
In Assignment 3, I redesigned the solution into 5 distinct classes, each with a specific responsibility:

1. **Product** - Data model representing a product
2. **CSVReader** - Handles CSV input and validation
3. **ProductTransformer** - Applies transformation rules
4. **CSVWriter** - Handles CSV output
5. **ETLPipeline** - Coordinates the entire process

### How Assignment 3 is More Object-Oriented

**Encapsulation**: In Assignment 2, all data was stored in primitive variables and arrays. In Assignment 3, product data is encapsulated in the `Product` class with private fields and public getters/setters. This hides implementation details and provides controlled access to data.

**Single Responsibility Principle**: Assignment 2 had one class doing everything. Assignment 3 separates concerns - `CSVReader` only reads, `ProductTransformer` only transforms, `CSVWriter` only writes. Each class has one reason to change.

**Objects as Data**: Assignment 3 uses `Product` objects to represent each row of data, making the code more intuitive and easier to work with than raw strings and arrays.

**Composition**: The `ETLPipeline` class demonstrates composition by creating and using instances of `CSVReader`, `ProductTransformer`, and `CSVWriter` to accomplish its goal.

### OO Concepts Used

1. **Object**: Each `Product` instance represents one row of product data with its own state.

2. **Class**: I created 5 classes, each defining the structure and behavior for a specific concept (Product, CSVReader, etc.).

3. **Encapsulation**:
    - `Product` class has private fields with public getters/setters
    - `ProductTransformer` has a private helper method `calculatePriceRange()`
    - Internal implementation details are hidden from other classes

4. **Composition**: The `ETLPipeline` class is composed of instances of `CSVReader`, `ProductTransformer`, and `CSVWriter`.

5. **Polymorphism**: Not heavily used in this assignment, but the `List<Product>` demonstrates polymorphism through the List interface.

6. **Inheritance**: Not used in this assignment, as the requirements didn't call for a class hierarchy.

### Testing

I verified that Assignment 3 produces identical output to Assignment 2 by:

1. **Robust Sample Test**: Ran both programs with the same input file and compared outputs byte-by-byte - they matched exactly.

2. **Empty File Test**: Created a CSV with only the header row. Both programs correctly output a file with only the header.

3. **Missing File Test**: Deleted the input file. Both programs print the same error message and exit cleanly without crashing.

4. **Summary Output**: Verified both programs print identical row counts (read: 13, transformed: 7, skipped: 6).

### Conclusion

Assignment 3 is significantly more maintainable and extensible than Assignment 2. If I needed to add new transformation rules, I would only modify `ProductTransformer`. If I needed to change the output format, I would only modify `CSVWriter`. In Assignment 2, all changes would require editing the same large `main()` method, increasing the risk of bugs.