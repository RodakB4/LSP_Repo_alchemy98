package org.howard.edu.lsp.midterm.strategy;

/**
 * Pricing strategy for members. Applies a 10% discount.
 * @author Rodak
 */
public class MemberPricing implements PricingStrategy {

    /**
     * Applies a 10% discount to the price.
     * @param price the original price
     * @return the price after a 10% discount
     */
    @Override
    public double calculatePrice(double price) {
        return price * 0.90;
    }
}