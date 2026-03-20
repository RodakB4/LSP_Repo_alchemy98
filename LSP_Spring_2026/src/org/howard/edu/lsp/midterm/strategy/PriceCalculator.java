package org.howard.edu.lsp.midterm.strategy;

/**
 * Context class that delegates price calculation to a PricingStrategy.
 * The strategy can be set at construction or swapped at runtime.
 * @author Rodak
 */
public class PriceCalculator {

    private PricingStrategy strategy;

    /**
     * Creates a PriceCalculator with the given pricing strategy.
     * @param strategy the pricing strategy to use
     * @throws IllegalArgumentException if strategy is null
     */
    public PriceCalculator(PricingStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("Strategy cannot be null.");
        }
        this.strategy = strategy;
    }

    /**
     * Sets a new pricing strategy at runtime.
     * @param strategy the new pricing strategy to use
     * @throws IllegalArgumentException if strategy is null
     */
    public void setStrategy(PricingStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("Strategy cannot be null.");
        }
        this.strategy = strategy;
    }

    /**
     * Calculates the final price using the current strategy.
     * @param price the original price
     * @return the final price after the strategy is applied
     */
    public double calculatePrice(double price) {
        return strategy.calculatePrice(price);
    }
}