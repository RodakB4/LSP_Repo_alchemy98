package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy interface for calculating prices based on customer type.
 * @author Rodak
 */
public interface PricingStrategy {

    /**
     * Calculates the final price after applying a discount.
     * @param price the original price before discount
     * @return the final price after discount is applied
     */
    double calculatePrice(double price);
}