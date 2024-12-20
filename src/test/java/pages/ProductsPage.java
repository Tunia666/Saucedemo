package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    WebDriver driver;

    By title = By.cssSelector("[data-test=title]");
    By buttonBackpack = By.cssSelector("[data-test=add-to-cart-sauce-labs-backpack]");
    By buttonLight = By.cssSelector("[data-test=add-to-cart-sauce-labs-bike-light]");
    By productCarTShirt = By.id("item_1_title_link");
    By addToCart = By.id("add-to-cart");
    By shoppingCart = By.cssSelector("[data-test=shopping-cart-link]");
    By countPoductsShoppingCart = By.cssSelector("[data-test=shopping-cart-link]");
    By removeTShirt = By.cssSelector("[data-test=remove-sauce-labs-bolt-t-shirt]");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public void addBackpack() {
        driver.findElement(buttonBackpack).click();
    }

    public void addLight() {
        driver.findElement(buttonLight).click();
    }

    public void addTShirt() {
        driver.findElement(productCarTShirt).click();
        driver.findElement(addToCart).click();
        //Shopping();
    }

    public String countProducts() {
        return driver.findElement(countPoductsShoppingCart).getText();
    }

    public void shopping() {
        driver.findElement(shoppingCart).click();
    }

    public void removeTShirt() {
        driver.findElement(removeTShirt).click();
    }
}
