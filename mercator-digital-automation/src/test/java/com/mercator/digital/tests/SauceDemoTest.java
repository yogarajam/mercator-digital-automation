package com.mercator.digital.tests;

import com.mercator.digital.config.DriverManager;
import com.mercator.digital.model.Product;
import com.mercator.digital.pages.InventoryPage;
import com.mercator.digital.pages.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

public class SauceDemoTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @Before
    public void setUp() {
        driver = DriverManager.getDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testSauceDemoWorkflow() {
        // Step 1: Navigate to the URL
        loginPage.navigateTo();

        // Step 2: Login with provided credentials
        inventoryPage = loginPage.performLogin("standard_user", "secret_sauce");

        // Step 3 & 4: Select and add the highest-priced item to the cart
        Product highestPricedProduct = inventoryPage.getHighestPricedProduct();
        inventoryPage.addProductToCart(highestPricedProduct);

        // Verify the item was added to the cart (e.g., check cart badge or URL)
        String cartUrl = driver.getCurrentUrl();
        assertTrue(cartUrl.contains("cart.html") || driver.findElements(By.className("shopping_cart_badge")).size() > 0);
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}