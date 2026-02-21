package org.howard.edu.lsp.assignment3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CSVReader {
    private int rowsRead;
    private int rowsSkipped;

    /**
     * Constructs a new CSVReader with counters initialized to zero.
     */
    public CSVReader() {
        this.rowsRead = 0;
        this.rowsSkipped = 0;
    }

    /**
     * Reads products from a CSV file.
     * Skips blank lines, rows without exactly 4 fields, and rows with invalid ProductID or Price.
     * @param filePath the path to the CSV file
     * @return a list of valid Product objects
     * @throws IOException if the file cannot be read
     */
    public List<Product> readProducts(String filePath) throws IOException {
        List<Product> products = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        reader.readLine();

        String line;
        while ((line = reader.readLine()) != null) {
            rowsRead++;

            if (line.trim().isEmpty()) {
                rowsSkipped++;
                continue;
            }

            String[] fields = line.split(",");
            for (int i = 0; i < fields.length; i++) {
                fields[i] = fields[i].trim();
            }

            if (fields.length != 4) {
                rowsSkipped++;
                continue;
            }

            try {
                int productId = Integer.parseInt(fields[0]);
                double price = Double.parseDouble(fields[2]);
                String name = fields[1];
                String category = fields[3];

                Product product = new Product(productId, name, price, category);
                products.add(product);

            } catch (NumberFormatException e) {
                rowsSkipped++;
            }
        }

        reader.close();
        return products;
    }

    /**
     * Gets the number of rows read from the file.
     * @return the number of rows read
     */
    public int getRowsRead() {
        return rowsRead;
    }

    /**
     * Gets the number of rows skipped due to validation errors.
     * @return the number of rows skipped
     */
    public int getRowsSkipped() {
        return rowsSkipped;
    }
}