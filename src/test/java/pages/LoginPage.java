package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AllureUtils;

import static utils.AllureUtils.takeScreenshot;

public class LoginPage {
    WebDriver driver;

    By userField = By.cssSelector("[data-test='username']");
    By passwordField = By.cssSelector("[data-test='password']");
    By loginButton = By.cssSelector("[data-test='login-button']");
    By errorMassage = By.cssSelector("[data-test=error]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Открытие страницы LoginPage")
    public void open() {
        driver.get("https://www.saucedemo.com/");
    }
    @Step("Вход в систему с логином {user} и паролем {password}")
    public void login(String user, String password) {
        driver.findElement(userField).sendKeys(user);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public String getErrorMassage() {
        return driver.findElement(errorMassage).getText();
    }

}
