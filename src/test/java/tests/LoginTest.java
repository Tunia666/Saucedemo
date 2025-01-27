package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test(testName = "Проверка корректного логина и пароля", description = "Тестирование корректного логина или пароля",
            retryAnalyzer = Retry.class, groups = {"smoke"},alwaysRun = true)
    public void checkingLoginWithCorrectUsernameAndPassword() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(),
                "Products",
                "Логин не выполнен");
    }

    @DataProvider(name = "LoginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"standard_user", "12345", "Epic sadface: Username and password do not match any user in this service"},
                {"name_user", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"},
        };
    }
    @Test(testName = "Проверка негативного логина и пароля", description = "Тестирование некорректного логина или пароля",
            retryAnalyzer = Retry.class, groups = {"smoke"},alwaysRun = true, dataProvider = "LoginData")
    public void checkNegativLogin(String user, String password, String message) {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(loginPage.getErrorMassage(),
                message,
                "Сообщение об ошибке не появилось");
    }
}
