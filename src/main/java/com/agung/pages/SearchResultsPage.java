package com.agung.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * SearchResultsPage class represents the Periplus search results page
 * Contains methods to interact with search results
 */
public class SearchResultsPage extends BasePage {

    // More flexible selectors that can match various product list structures
    @FindBy(css = ".ProductList .product-item, .product-list .product-item, .product-grid .item")
    private List<WebElement> productItems;

    @FindBy(css = ".ProductList .product-item .product-title, .product-list .title, .product-title a, h3.title a")
    private List<WebElement> productTitles;

    @FindBy(css = ".ProductList .product-item .product-title a, .product-list .title a, .product-title a, h3.title a")
    private List<WebElement> productLinks;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Get number of products found in search results
     * @return number of products
     */
    public int getNumberOfProducts() {
        return productItems.size();
    }

    /**
     * Select a product by index
     * @param index product index in list
     * @return ProductPage instance
     */
    public ProductPage selectProductByIndex(int index) {
        waitForPageToLoad();
        try {
            System.out.println("Found " + productItems.size() + " product(s) in search results");
            
            if (index >= 0 && index < productItems.size()) {
                System.out.println("Selecting product at index: " + index);
                scrollIntoView(productLinks.get(index));
                clickElement(productLinks.get(index));
                waitForPageToLoad();
                return new ProductPage(driver);
            } else if (!productItems.isEmpty()) {
                // Fallback: If index is out of bounds but products exist, click the first one
                System.out.println("Index out of bounds, selecting first product instead");
                scrollIntoView(productLinks.get(0));
                clickElement(productLinks.get(0));
                waitForPageToLoad();
                return new ProductPage(driver);
            } else {
                // Fallback: Try a different selector if our main ones didn't work
                System.out.println("No products found with primary selectors, trying alternative approach");
                List<WebElement> alternativeProducts = driver.findElements(By.cssSelector("a[href*='/product/']"));
                if (!alternativeProducts.isEmpty()) {
                    scrollIntoView(alternativeProducts.get(0));
                    clickElement(alternativeProducts.get(0));
                    waitForPageToLoad();
                    return new ProductPage(driver);
                }
                throw new IllegalArgumentException("No products found in search results");
            }
        } catch (Exception e) {
            System.out.println("Error selecting product: " + e.getMessage());
            throw e;
        }
    }

    /**
     * Select first product from search results
     * @return ProductPage instance
     */
    public ProductPage selectFirstProduct() {
        return selectProductByIndex(0);
    }

    /**
     * Check if any products were found
     * @return true if products were found, false otherwise
     */
    public boolean hasResults() {
        waitForPageToLoad();
        
        if (!productItems.isEmpty()) {
            return true;
        }
        
        // Fallback: Try alternative selectors
        try {
            List<WebElement> alternativeProducts = driver.findElements(By.cssSelector("a[href*='/product/']"));
            return !alternativeProducts.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }
}