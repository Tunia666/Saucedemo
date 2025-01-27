package tests;


import io.qameta.allure.*;
import jdk.jfr.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {

    @Test(testName = "Проверка добавления товаров в корзину")
    @Description("Проверка корректности добавления нескольких товаров в корзину")
    @Severity(SeverityLevel.NORMAL)
    @Epic("Sausedemo-1.0")
    @Feature("Cart in Sausedemo")
    @Story("Добавление товаров в корзину")
    @TmsLink("www.jira.com/ITM-5")
    @Issue("www.jira.com/ITM-6")
    public void checkAdditionProductToShoppingCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Bolt T-Shirt");
        assertEquals(productsPage.countProducts(), "3", "Количество товара не равно 3м");
    }

    @Test(testName = "Проверка удаления товара из корзины")
    @Description("Проверка корректности удаления одного товара из корзины")
    @Severity(SeverityLevel.NORMAL)
    @Epic("Sausedemo-1.0")
    @Feature("Cart in Sausedemo")
    @Story("Удаление товаров из корзины")
    @TmsLink("www.jira.com/ITM-7")
    @Issue("www.jira.com/ITM-8")
    public void checkRemovalItemFromShoppingCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Bolt T-Shirt");
        productsPage.removeProduct("Sauce Labs Bolt T-Shirt");
        productsPage.shopping();
        assertEquals(productsPage.countProducts(), "2", "Количество товара не равно 2м");
    }

    @Test(testName = "Проверка добавления товара со страницы товара")
    @Description("Проверка, что товар можно добавить в корзину со страницы товара")
    @Severity(SeverityLevel.MINOR)
    @Epic("Sausedemo-1.0")
    @Feature("Product Details")
    @Story("Добавление товара из страницы его описания")
    @TmsLink("www.jira.com/ITM-9")
    @Issue("www.jira.com/ITM-10")
    public void checkAddProductPage() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.goToProductPage("Sauce Labs Bike Light");
        productsPage.addToCartInProductPage("Sauce Labs Bike Light");
        productsPage.shopping();
        assertEquals(productsPage.countProducts(), "1", "Количество товара не равно 2м");
    }

    @Test (testName = "Проверка удаления товара из корзины")
    @Description("Проверка удаления товара из корзины") //аннотация
    @Severity(SeverityLevel.CRITICAL)//уровень теста
    @Epic("Sausedemo-1.0")//
    @Feature("Cart in Sausedemo")
    @Story("Удаление товара из корзины")
    @TmsLink("www.jira.com/ITM-3")
    @Issue("www.jira.com/ITM-4")
    public void checkRemoveProductFormCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Bolt T-Shirt");
        productsPage.goToProductPage("Sauce Labs Bike Light");
        productsPage.addToCartInProductPage("Sauce Labs Bike Light");
        productsPage.shopping();
        productsPage.removeProductCar("Sauce Labs Bolt T-Shirt");
        assertEquals(productsPage.countProducts(), "2", "Количество товара не равно 2м");
    }
}
