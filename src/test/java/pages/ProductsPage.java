package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage {
    WebDriver driver;

    By title = By.cssSelector("[data-test=title]");
    String productPage = "//div[text()='%s']";
    String addToCartPattern = "//div[text()='%s']//ancestor::div[@class='inventory_item']//button";
    String addToCartInPage = "//div[text()='%s']//ancestor::div[@class='inventory_details']//button";
    By countPoductsShoppingCart = By.cssSelector("[data-test=shopping-cart-link]");
    String removeProductPage = "//div[text()='%s']//ancestor::div[@class='inventory_item']//button";
    String removeCar = "//div[text()='%s']//ancestor::div[@class='cart_item']//button";
    By shoppingCart = By.cssSelector("[data-test=shopping-cart-link]");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public void addToCart(String product) {
        driver.findElement(By.xpath(String.format(addToCartPattern, product))).click();
    }

    public String countProducts() {
        return driver.findElement(countPoductsShoppingCart).getText();
    }

    //переход в корзину
    public void shopping() {
        driver.findElement(shoppingCart).click();
    }

    //добавление из списка продуктов
    public void addToCartInProductPage(String product) {
        driver.findElement(By.xpath(String.format(addToCartInPage, product))).click();
    }

    //удаление продукта из списка
    public void removeProduct(String product) {
        driver.findElement(By.xpath(String.format(removeProductPage, product))).click();
    }

    //удаление из корзины
    public void removeProductCar(String product) {
        driver.findElement(By.xpath(String.format(removeCar, product))).click();
    }

    //переход на страницу продукта
    public void goToProductPage(String product) {
        driver.findElement(By.xpath(String.format(productPage, product))).click();
    }
}
