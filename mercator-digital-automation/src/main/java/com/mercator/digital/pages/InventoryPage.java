package com.mercator.digital.pages;

import com.mercator.digital.model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class InventoryPage {
    private WebDriver driver;
    private By productName = By.className("inventory_item_name");
    private By productPrice = By.className("inventory_item_price");
    private By addToCartButton = By.className("btn_inventory");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public Product getHighestPricedProduct() {
        List<WebElement> names = driver.findElements(productName);
        List<WebElement> prices = driver.findElements(productPrice);
        List<Product> products = new ArrayList<>();

        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i).getText();
            double price = Double.parseDouble(prices.get(i).getText().replace("$", ""));
            products.add(new Product(name, price));
        }

        // Find the product with the highest price without sorting
        Product highestPriced = products.get(0);
        for (Product product : products) {
            if (product.getPrice() > highestPriced.getPrice()) {
                highestPriced = product;
            }
        }

        return highestPriced;
    }

    public void addProductToCart(Product product) {
        List<WebElement> products = driver.findElements(productName);
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getText().equals(product.getName())) {
                driver.findElements(addToCartButton).get(i).click();
                break;
            }
        }
    }
}