package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {


    @Test
    public void checkAdditionProductToShoppingCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addBackpack();
        productsPage.addLight();
        productsPage.addTShirt();
        productsPage.shopping();
        assertEquals(productsPage.countProducts(), "3", "Количество товара не равно 3м");
    }

    @Test
    public void checkRemovalItemFromShoppingCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addBackpack();
        productsPage.addLight();
        productsPage.addTShirt();
        productsPage.shopping();
        productsPage.removeTShirt();
        assertEquals(productsPage.countProducts(), "2", "Количество товара не равно 2м");
    }
}