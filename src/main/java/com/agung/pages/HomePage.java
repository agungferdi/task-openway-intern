package com.agung.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * HomePage class represents the Periplus website homepage
 * Contains methods to interact with homepage elements
 */
public class HomePage extends BasePage {

    // Updated selectors for current Periplus website
    @FindBy(css = ".search-form input[name='q'], input[name='q']")
    private WebElement searchBox;
    
    @FindBy(css = ".search-form button[type='submit'], button.search-button")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Navigate to login page
     * @return LoginPage instance
     */
    public LoginPage navigateToLogin() {
        // Using direct URL instead of clicking UI elements
        driver.get("https://www.periplus.com/account/Login");
        return new LoginPage(driver);
    }

    /**
     * Search for a product
     * @param productName name of the product to search
     * @return SearchResultsPage instance
     */
    public SearchResultsPage searchProduct(String productName) {
        waitForPageToLoad();
        try {
            System.out.println("Attempting to search for: " + productName);
            sendKeys(searchBox, productName);
            clickElement(searchButton);
        } catch (Exception e) {
            System.out.println("Error during search: " + e.getMessage());
            // Fallback approach - try direct URL search
            driver.get("https://www.periplus.com/search?q=" + productName.replace(" ", "+"));
        }
        waitForPageToLoad();
        return new SearchResultsPage(driver);
    }
    
    /**
     * Check if user is logged in
     * @return true if user is logged in, false otherwise
     */
    public boolean isUserLoggedIn() {
        waitForPageToLoad();
        try {
            // More flexible login detection methods
            // Method 1: Check URL - often redirects to account page after login
            String currentUrl = driver.getCurrentUrl();
            System.out.println("Current URL after login: " + currentUrl);
            if (currentUrl.contains("/account") && !currentUrl.contains("/Login")) {
                return true;
            }
            
            // Method 2: Look for logout or account links
            try {
                if (driver.findElement(By.xpath("//*[contains(text(), 'Logout') or contains(text(), 'Log out') or contains(text(), 'My Account')]")).isDisplayed()) {
                    return true;
                }
            } catch (Exception e) {
                // Element not found, continue with other checks
            }
            
            // If all login checks fail, assume not logged in
            return false;
        } catch (Exception e) {
            System.out.println("Exception in isUserLoggedIn: " + e.getMessage());
            return false;
        }
    }
}