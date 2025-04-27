package com.agung.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = "input[type='email'], input[name='Email'], input.email")
    private WebElement emailField;

    @FindBy(css = "input[type='password'], input[name='Password']")
    private WebElement passwordField;

    @FindBy(css = "button[type='submit'], input[type='submit'], .login-button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public HomePage login(String email, String password) {
        waitForPageToLoad();
        System.out.println("Attempting to login with email: " + email);
        
        try {
            emailField.clear();
            sendKeys(emailField, email);
            
            passwordField.clear();
            sendKeys(passwordField, password);
            
            clickElement(loginButton);
            waitForPageToLoad();
            System.out.println("Login form submitted");
        } catch (Exception e) {
            System.out.println("Error during login: " + e.getMessage());
        }
        
        return new HomePage(driver);
    }
}