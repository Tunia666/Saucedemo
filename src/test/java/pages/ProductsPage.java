package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static utils.AllureUtils.takeScreenshot;

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
    @Step("Добавление в корзину товара с именем: {product}")
    public void addToCart(String product) {
        driver.findElement(By.xpath(String.format(addToCartPattern, product))).click();
    }

    public String countProducts() {
        return driver.findElement(countPoductsShoppingCart).getText();
    }

    //переход в корзину
    @Step("Нажатие на кнопку корзины")
    public void shopping() {
        driver.findElement(shoppingCart).click();
    }

    //добавление из списка продуктов
    @Step("Добавление в корзину товара с именем: {product}")
    public void addToCartInProductPage(String product) {
        driver.findElement(By.xpath(String.format(addToCartInPage, product))).click();
    }

    //удаление продукта из списка
    @Step("Удаление товара с именем: {product}")
    public void removeProduct(String product) {
        driver.findElement(By.xpath(String.format(removeProductPage, product))).click();
    }

    //удаление из корзины
    @Step("Удаление товара с именем: {product}")
    public void removeProductCar(String product) {
        driver.findElement(By.xpath(String.format(removeCar, product))).click();
    }

    //переход на страницу продукта
    @Step("Переход на страницу товара с именем: {product}")
    public void goToProductPage(String product) {
        driver.findElement(By.xpath(String.format(productPage, product))).click();
    }
}
