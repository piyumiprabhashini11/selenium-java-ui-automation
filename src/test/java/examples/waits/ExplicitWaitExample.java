package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitWaitExample {

    @Test
    public void testExplicitWaitSauceDemo() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for username field
        WebElement username = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))
        );
        username.sendKeys("standard_user");

        // Wait for password field
        WebElement password = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("password"))
        );
        password.sendKeys("secret_sauce");

        // Wait for login button
        WebElement loginBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("login-button"))
        );
        loginBtn.click();

        // Wait for product title on the next page
        WebElement productTitle = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("title"))
        );

        // Validate login success
        Assert.assertEquals(productTitle.getText(), "Products");
        System.out.println("Login successful and Products page loaded!");

        driver.quit();
    }
}
