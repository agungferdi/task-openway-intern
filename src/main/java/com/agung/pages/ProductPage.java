package com.agung.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * ProductPage class represents the Periplus product detail page
 * Contains methods to interact with product details and add to cart
 */
public class ProductPage extends BasePage {

    @FindBy(css = ".product-title")
    private WebElement productTitle;
    
    @FindBy(css = ".product-price")
    private WebElement productPrice;
    
    @FindBy(css = ".add-to-cart-button")
    private WebElement addToCartButton;
    
    @FindBy(css = ".cart-success-message")
    private WebElement cartSuccessMessage;
    
    @FindBy(css = ".view-cart-button")
    private WebElement viewCartButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }
    
    /**
     * Get product title
     * @return product title text
     */
    public String getProductTitle() {
        return getElementText(productTitle);
    }
    
    /**
     * Get product price
     * @return product price text
     */
    public String getProductPrice() {
        return getElementText(productPrice);
    }
    
    /**
     * Add product to cart
     * @return ProductPage instance
     */
    public ProductPage addToCart() {
        scrollIntoView(addToCartButton);
        clickElement(addToCartButton);
        waitForPageToLoad();
        return this;
    }
    
    /**
     * Check if product was successfully added to cart
     * @return true if success message is displayed, false otherwise
     */
    public boolean isProductAddedToCart() {
        try {
            wait.until(d -> isElementDisplayed(cartSuccessMessage));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Navigate to cart page
     * @return CartPage instance
     */
    public CartPage navigateToCart() {
        if (isElementDisplayed(viewCartButton)) {
            clickElement(viewCartButton);
        }
        waitForPageToLoad();
        return new CartPage(driver);
    }
}