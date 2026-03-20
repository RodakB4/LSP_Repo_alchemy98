package org.howard.edu.lsp.midterm.strategy;

/**
 * Demonstrates the Strategy Pattern implementation for price calculation.
 * @author Rodak
 */
public class Driver {

    public static void main(String[] args) {
        PriceCalculator calculator = new PriceCalculator(new RegularPricing());
        System.out.println("REGULAR: " + calculator.calculatePrice(100.0));

        calculator.setStrategy(new MemberPricing());
        System.out.println("MEMBER: " + calculator.calculatePrice(100.0));

        calculator.setStrategy(new VIPPricing());
        System.out.println("VIP: " + calculator.calculatePrice(100.0));

        calculator.setStrategy(new HolidayPricing());
        System.out.println("HOLIDAY: " + calculator.calculatePrice(100.0));
    }
}