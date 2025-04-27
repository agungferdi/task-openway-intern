package com.agung.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = ".search-form input[name='q'], input[name='q']")
    private WebElement searchBox;
    
    @FindBy(css = ".search-form button[type='submit'], button.search-button")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage navigateToLogin() {
        driver.get("https://www.periplus.com/account/Login");
        return new LoginPage(driver);
    }

    public SearchResultsPage searchProduct(String productName) {
        waitForPageToLoad();
        try {
            System.out.println("Attempting to search for: " + productName);
            sendKeys(searchBox, productName);
            clickElement(searchButton);
        } catch (Exception e) {
            System.out.println("Error during search: " + e.getMessage());
            driver.get("https://www.periplus.com/search?q=" + productName.replace(" ", "+"));
        }
        waitForPageToLoad();
        return new SearchResultsPage(driver);
    }
    
    public boolean isUserLoggedIn() {
        waitForPageToLoad();
        try {
            String currentUrl = driver.getCurrentUrl();
            System.out.println("Current URL after login: " + currentUrl);
            if (currentUrl.contains("/account") && !currentUrl.contains("/Login")) {
                return true;
            }
            
            try {
                if (driver.findElement(By.xpath("//*[contains(text(), 'Logout') or contains(text(), 'Log out') or contains(text(), 'My Account')]")).isDisplayed()) {
                    return true;
                }
            } catch (Exception e) {
            }
            
            return false;
        } catch (Exception e) {
            System.out.println("Exception in isUserLoggedIn: " + e.getMessage());
            return false;
        }
    }
}