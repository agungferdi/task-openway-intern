package com.agung.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * LoginPage class represents the Periplus login page
 * Contains methods to handle login functionality
 */
public class LoginPage extends BasePage {

    // Using multiple selector options to increase reliability
    @FindBy(css = "input[type='email'], input[name='Email'], input.email")
    private WebElement emailField;

    @FindBy(css = "input[type='password'], input[name='Password']")
    private WebElement passwordField;

    @FindBy(css = "button[type='submit'], input[type='submit'], .login-button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Login to Periplus with provided credentials
     * @param email user's email
     * @param password user's password
     * @return HomePage instance after login
     */
    public HomePage login(String email, String password) {
        waitForPageToLoad();
        System.out.println("Attempting to login with email: " + email);
        
        try {
            // Clear fields before sending keys
            emailField.clear();
            sendKeys(emailField, email);
            
            passwordField.clear();
            sendKeys(passwordField, password);
            
            // Take screenshot to debug any UI issues
            // Implement screenshot if needed
            
            clickElement(loginButton);
            waitForPageToLoad();
            System.out.println("Login form submitted");
        } catch (Exception e) {
            System.out.println("Error during login: " + e.getMessage());
        }
        
        return new HomePage(driver);
    }
}