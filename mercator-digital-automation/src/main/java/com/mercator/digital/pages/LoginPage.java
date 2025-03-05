package com.mercator.digital.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.mercator.digital.config.DriverManager;

public class LoginPage {
    private WebDriver driver;
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.get(DriverManager.getWebsiteUrl());
    }

    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public InventoryPage performLogin(String username, String password) {
        login(username, password);
        return new InventoryPage(driver);
    }
}