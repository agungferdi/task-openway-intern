package com.agung.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(css = ".ProductList .product-item, .product-list .product-item, .product-grid .item")
    private List<WebElement> productItems;

    @FindBy(css = ".ProductList .product-item .product-title, .product-list .title, .product-title a, h3.title a")
    private List<WebElement> productTitles;

    @FindBy(css = ".ProductList .product-item .product-title a, .product-list .title a, .product-title a, h3.title a")
    private List<WebElement> productLinks;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public int getNumberOfProducts() {
        return productItems.size();
    }

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
                System.out.println("Index out of bounds, selecting first product instead");
                scrollIntoView(productLinks.get(0));
                clickElement(productLinks.get(0));
                waitForPageToLoad();
                return new ProductPage(driver);
            } else {
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

    public ProductPage selectFirstProduct() {
        return selectProductByIndex(0);
    }

    public boolean hasResults() {
        waitForPageToLoad();
        
        if (!productItems.isEmpty()) {
            return true;
        }
        
        try {
            List<WebElement> alternativeProducts = driver.findElements(By.cssSelector("a[href*='/product/']"));
            return !alternativeProducts.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }
}