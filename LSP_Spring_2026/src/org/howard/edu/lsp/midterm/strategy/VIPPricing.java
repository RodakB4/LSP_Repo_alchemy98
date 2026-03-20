package org.howard.edu.lsp.midterm.strategy;

/**
 * Pricing strategy for VIP customers. Applies a 20% discount.
 * @author Rodak
 */
public class VIPPricing implements PricingStrategy {

    /**
     * Applies a 20% discount to the price.
     * @param price the original price
     * @return the price after a 20% discount
     */
    @Override
    public double calculatePrice(double price) {
        return price * 0.80;
    }
}