package org.howard.edu.lsp.assignment3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVWriter {

    /**
     * Writes a list of products to a CSV file. Output format: ProductID,Name,Price,Category,PriceRange
     * @param products the list of products to write
     * @param filePath the path to the output CSV file
     * @throws IOException if the file cannot be written
     */
    public void writeProducts(List<Product> products, String filePath) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

        writer.write("ProductID,Name,Price,Category,PriceRange");
        writer.newLine();

        for (Product product : products) {
            String formattedPrice = String.format("%.2f", product.getPrice());

            String row = product.getProductId() + "," +
                    product.getName() + "," +
                    formattedPrice + "," +
                    product.getCategory() + "," +
                    product.getPriceRange();

            writer.write(row);
            writer.newLine();
        }

        writer.close();
    }
}