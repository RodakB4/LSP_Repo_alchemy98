package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class ProductTransformer {

    /**
     * Transforms a product by applying all transformation rules.
     * @param product the product to transform
     */
    public void transform(Product product) {
        String originalCategory = product.getCategory();

        product.setName(product.getName().toUpperCase());

        if (product.getCategory().equals("Electronics")) {
            product.setPrice(product.getPrice() * 0.9);
        }
        BigDecimal bd = new BigDecimal(product.getPrice());
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        product.setPrice(bd.doubleValue());

        if (product.getPrice() > 500.00 && originalCategory.equals("Electronics")) {
            product.setCategory("Premium Electronics");
        }
        product.setPriceRange(calculatePriceRange(product.getPrice()));
    }

    /**
     * Calculates the price range category based on the given price.
     * @param price the product price
     * @return range
     */
    private String calculatePriceRange(double price) {
        if (price <= 10.00) {
            return "Low";
        } else if (price <= 100.00) {
            return "Medium";
        } else if (price <= 500.00) {
            return "High";
        } else {
            return "Premium";
        }
    }
}