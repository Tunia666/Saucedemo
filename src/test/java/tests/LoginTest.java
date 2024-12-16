package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {


    @Test
    public void checkingLoginWithCorrectUsernameAndPassword() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(),
                "Products",
                "Логин не выполнен");
    }

    @Test
    public void checkLoginWithWrongPassword() {
        loginPage.open();
        loginPage.login("standard_user", "12345");
        assertEquals(loginPage.getErrorMassage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Сообщение об ошибке не появилось");
    }

    @Test
    public void checkLoginWithWrongUsername() {
        loginPage.open();
        loginPage.login("name_user", "secret_sauce");
        assertEquals(loginPage.getErrorMassage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Сообщение об ошибке не появилось");
    }
}
