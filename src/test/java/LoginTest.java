import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import java.time.Duration;

public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkPozitiveTest() {
        driver.get("https://www.saucedemo.com/");
        // извлечение логина
        String loginText = driver.findElement(By.id("login_credentials")).getText();
        String[] loginElements = loginText.split("\\n");//добавление элемента строки в массив
        String username = loginElements[1].trim();//извлечение элемента
        // извлечение пароля
        String passwordText = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div/div[2]")).getText();
        String password = passwordText.split(":")[1].trim();
        // ввод логина и пароля
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).isDisplayed());
        softAssert.assertEquals(driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText(), "Products");//Products находится в следующей странице
    }

    @Test
    public void checkNegativeLoginTest() {
        driver.get("https://www.saucedemo.com/");
        // извлечение негатив_логина
        String loginText = driver.findElement(By.id("login_credentials")).getText();
        String[] loginElements = loginText.split("\\n");//добавление элемента строки в массив
        String username = loginElements[2].trim();//извлечение элемента
        // извлечение пароля
        String passwordText = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div/div[2]")).getText();
        String password = passwordText.split(":")[1].trim();
        // ввод логина и пароля
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        String errorMassage = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        Assert.assertEquals(errorMassage, "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void checkNegativePasswordTest() {
        driver.get("https://www.saucedemo.com/");
        // извлечение логина
        String loginText = driver.findElement(By.id("login_credentials")).getText();
        String[] loginElements = loginText.split("\\n");//добавление элемента строки в массив
        String username = loginElements[1].trim();//извлечение элемента
        String password = "Password";//неверный password
        // ввод логина и пароля
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        String errorMassage = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        Assert.assertEquals(errorMassage, "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void checkNegativeLoginAndPasswordTest() {
        driver.get("https://www.saucedemo.com/");
        String username = "Username";//неверный login
        String password = "Password";//неверный password
        // ввод логина и пароля
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        String errorMassage = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        Assert.assertEquals(errorMassage, "Epic sadface: Username and password do not match any user in this service");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
