package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

    By title = By.cssSelector("[data-test=title]");
    By checkoutButton = By.cssSelector("[data-test='checkout']");
    String productName = "//div[text()='%s']";
    By countPoductsShoppingCart = By.cssSelector("[data-test=shopping-cart-link]");
    By removeTShirt = By.cssSelector("[data-test=remove-sauce-labs-bolt-t-shirt]");
    By shoppingCart = By.cssSelector("[data-test=shopping-cart-link]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }


}
