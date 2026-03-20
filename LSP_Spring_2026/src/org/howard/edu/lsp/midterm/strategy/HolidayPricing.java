package org.howard.edu.lsp.midterm.strategy;

/**
 * Pricing strategy for holiday promotions. Applies a 15% discount.
 * @author Rodak
 */
public class HolidayPricing implements PricingStrategy {

    /**
     * Applies a 15% discount to the price.
     * @param price the original price
     * @return the price after a 15% discount
     */
    @Override
    public double calculatePrice(double price) {
        return price * 0.85;
    }
}