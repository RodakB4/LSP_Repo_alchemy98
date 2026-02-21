package org.howard.edu.lsp.assignment3;


public class Product {
    private int productId;
    private String name;
    private double price;
    private String category;
    private String priceRange;

    /**
     * Constructs a Product with the given attributes.
     * @param productId the unique identifier for the product
     * @param name the product name
     * @param price the product price
     * @param category the product category
     */
    public Product(int productId, String name, double price, String category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
        this.priceRange = "";
    }

    /**
     * Gets the product ID.
     * @return the product ID
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Gets the product name.
     * @return the product name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the product name.
     * @param name the product name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the product price.
     * @return the product price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the product price.
     * @param price the product price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the product category.
     * @return the product category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the product category.
     * @param category the product category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Gets the price range.
     * @return the price range (Low, Medium, High, or Premium)
     */
    public String getPriceRange() {
        return priceRange;
    }

    /**
     * Sets the price range.
     * @param priceRange the price range
     */
    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }
}