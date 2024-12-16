package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {


    @Test
    public void CheckAdditionProductToShoppingCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.AddBackpack();
        productsPage.AddLight();
        productsPage.AddTShirt();
        productsPage.Shopping();
        assertEquals(productsPage.CountProducts(), "3", "Количество товара не равно 3м");
    }

    @Test
    public void CheckRemovalItemFromShoppingCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.AddBackpack();
        productsPage.AddLight();
        productsPage.AddTShirt();
        productsPage.Shopping();
        productsPage.RemoveTShirt();
        assertEquals(productsPage.CountProducts(), "2", "Количество товара не равно 2м");
    }
}