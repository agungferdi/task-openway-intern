package com.agung.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    
    public String getProductTitle() {
        return getElementText(productTitle);
    }
    
    public String getProductPrice() {
        return getElementText(productPrice);
    }
    
    public ProductPage addToCart() {
        scrollIntoView(addToCartButton);
        clickElement(addToCartButton);
        waitForPageToLoad();
        return this;
    }
    
    public boolean isProductAddedToCart() {
        try {
            wait.until(d -> isElementDisplayed(cartSuccessMessage));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public CartPage navigateToCart() {
        if (isElementDisplayed(viewCartButton)) {
            clickElement(viewCartButton);
        }
        waitForPageToLoad();
        return new CartPage(driver);
    }
}