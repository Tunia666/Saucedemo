package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AllureUtils;

import java.time.Duration;

import static utils.AllureUtils.takeScreenshot;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    By userField = By.cssSelector("[data-test='username']");
    By passwordField = By.cssSelector("[data-test='password']");
    By loginButton = By.cssSelector("[data-test='login-button']");
    By errorMassage = By.cssSelector("[data-test=error]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void isPageOpened(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(userField));
    }
    @Step("Открытие страницы LoginPage")
    public void open() {
        driver.get("https://www.saucedemo.com/");
    }

    @Step("Вход в систему с логином {user} и паролем {password}")
    public ProductsPage login(String user, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userField));
        driver.findElement(userField).sendKeys(user);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        driver.findElement(passwordField).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        driver.findElement(loginButton).click();
        return new ProductsPage(driver);
    }

    public String getErrorMassage() {
        return driver.findElement(errorMassage).getText();
    }

}
