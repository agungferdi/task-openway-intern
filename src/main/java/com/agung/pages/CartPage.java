package com.agung.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(css = "a.single-icon i.ti-bag")
    private WebElement cartIcon;
    
    @FindBy(css = "#cart_total")
    private WebElement cartItemCount;
    
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
    
    public int getCartCount() {
        try {
            return Integer.parseInt(getElementText(cartItemCount));
        } catch (Exception e) {
            System.out.println("Could not get cart count: " + e.getMessage());
            return 0;
        }
    }
    
    public int getNumberOfItems() {
        waitForPageToLoad();
        return cartItems.size();
    }
    
    public boolean hasItems() {
        if (getCartCount() > 0) {
            return true;
        }
        
        return getNumberOfItems() > 0;
    }
    
    public boolean isProductInCart(String productName) {
        if (!hasItems()) {
            return false;
        }
        
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
        
        System.out.println("Could not find product '" + productName + "' in cart. Items found:");
        for (WebElement itemName : itemNames) {
            System.out.println("- " + getElementText(itemName));
        }
        
        return false;
    }
    
    public String getCartTotal() {
        return getElementText(cartTotal);
    }
    
    public boolean isCartEmpty() {
        try {
            if (isElementDisplayed(emptyCartMessage)) {
                return true;
            }
        } catch (Exception e) {
        }
        
        return getCartCount() == 0 && getNumberOfItems() == 0;
    }
}