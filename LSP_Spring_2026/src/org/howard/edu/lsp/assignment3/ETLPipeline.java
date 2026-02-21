package org.howard.edu.lsp.assignment3;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Main ETL Pipeline that orchestrates the Extract-Transform-Load process.
 * Coordinates CSVReader, ProductTransformer, and CSVWriter to process product data.
 */
public class ETLPipeline {


    public static void main(String[] args) {
        String inputPath = "data/products.csv";
        String outputPath = "data/transformed_products.csv";

        File inputFile = new File(inputPath);
        if (!inputFile.exists()) {
            System.out.println("Error: Input file not found at " + inputPath);
            return;
        }

        try {
            CSVReader reader = new CSVReader();
            List<Product> products = reader.readProducts(inputPath);

            ProductTransformer transformer = new ProductTransformer();
            for (Product product : products) {
                transformer.transform(product);
            }

            CSVWriter writer = new CSVWriter();
            writer.writeProducts(products, outputPath);

            int rowsTransformed = products.size();
            System.out.println("Rows read: " + reader.getRowsRead());
            System.out.println("Rows transformed: " + rowsTransformed);
            System.out.println("Rows skipped: " + reader.getRowsSkipped());
            System.out.println("Output: " + outputPath);

        } catch (IOException e) {
            System.out.println("Error reading/writing file: " + e.getMessage());
        }
    }
}