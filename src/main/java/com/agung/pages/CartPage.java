package com.agung.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * CartPage class represents the Periplus shopping cart page
 * Contains methods to interact with cart items and verify cart functionality
 */
public class CartPage extends BasePage {

    // Updated selectors based on the actual website structure
    @FindBy(css = "a.single-icon i.ti-bag")
    private WebElement cartIcon;
    
    @FindBy(css = "#cart_total")
    private WebElement cartItemCount;
    
    // Cart page elements after navigating to cart
    @FindBy(css = ".cart-items .cart-item, .shop-list, .shopping-cart-table tr")
    private List<WebElement> cartItems;
    
    @FindBy(css = ".cart-items .cart-item .item-name, .shop-list .product-name, .shopping-cart-table .product-name")
    private List<WebElement> itemNames;
    
    @FindBy(css = ".cart-items .cart-item .item-price, .shop-list .product-price, .shopping-cart-table .product-price")
    private List<WebElement> itemPrices;
    
    @FindBy(css = ".cart-total, .order-total, .grand-total")
    private WebElement cartTotal;
    
    @FindBy(css = ".cart-empty-message, .empty-cart-message, .cart-empty")
    private WebElement emptyCartMessage;

    public CartPage(WebDriver driver) {
        super(driver);
    }
    
    /**
     * Get cart count from the cart icon
     * @return count of items in cart
     */
    public int getCartCount() {
        try {
            return Integer.parseInt(getElementText(cartItemCount));
        } catch (Exception e) {
            System.out.println("Could not get cart count: " + e.getMessage());
            return 0;
        }
    }
    
    /**
     * Get number of items in cart page
     * @return number of items
     */
    public int getNumberOfItems() {
        waitForPageToLoad();
        return cartItems.size();
    }
    
    /**
     * Check if cart has items
     * @return true if cart has items, false otherwise
     */
    public boolean hasItems() {
        // First check cart count in the header
        if (getCartCount() > 0) {
            return true;
        }
        
        // If that doesn't work, check for items in the cart page
        return getNumberOfItems() > 0;
    }
    
    /**
     * Check if specific product is in cart
     * @param productName name of product to check
     * @return true if product is in cart, false otherwise
     */
    public boolean isProductInCart(String productName) {
        if (!hasItems()) {
            return false;
        }
        
        // If cart count is positive but we can't find items, we may need to wait
        if (itemNames.isEmpty()) {
            System.out.println("Waiting for cart items to load...");
            waitForPageToLoad();
        }
        
        for (WebElement itemName : itemNames) {
            String actualName = getElementText(itemName);
            System.out.println("Found item in cart: " + actualName);
            if (actualName.contains(productName) || productName.contains(actualName)) {
                return true;
            }
        }
        
        // If we can't find the exact product name, print what we found
        System.out.println("Could not find product '" + productName + "' in cart. Items found:");
        for (WebElement itemName : itemNames) {
            System.out.println("- " + getElementText(itemName));
        }
        
        return false;
    }
    
    /**
     * Get cart total amount
     * @return cart total text
     */
    public String getCartTotal() {
        return getElementText(cartTotal);
    }
    
    /**
     * Check if cart is empty
     * @return true if cart is empty, false otherwise
     */
    public boolean isCartEmpty() {
        try {
            if (isElementDisplayed(emptyCartMessage)) {
                return true;
            }
        } catch (Exception e) {
            // If we can't find the empty message, check the count
        }
        
        return getCartCount() == 0 && getNumberOfItems() == 0;
    }
}